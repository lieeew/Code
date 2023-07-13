package com.leikooo.hspmybatis.sqlsession;

import com.leikooo.hspmybatis.config.Function;
import com.leikooo.hspmybatis.config.MapperBean;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author leikooo
 * @create 2023-07-12 19:48
 * @Package com.leikooo.hspmybatis.sqlsession
 * @Description 读取 xml 文件, 建立连接
 */
public class HspConfiguration {
    /**
     * 类的加载器
     */
    private static ClassLoader loader = ClassLoader.getSystemClassLoader();

    /**
     * 读取 xml 文件信息，并处理
     *
     * @param resource 资源文件
     * @return 数据库连接
     */
    public Connection build(String resource) {
        InputStream inputStream = loader.getResourceAsStream(resource);
        Connection connection = null;
        // dom4j 读取配置文件
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(inputStream);
            Element rootElement = document.getRootElement();
//            System.out.println("rootElement = " + rootElement);
            // 单独编写一个方法
            connection = evalDataSource(rootElement);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        // 解析 xml 文件
        return connection;
    }

    /**
     * 读取配置文件
     *
     * @param node 根节点
     * @return 数据库连接
     */
    private @Nullable Connection evalDataSource(@NotNull Element node) {
        if (!"database".equals(node.getName())) {
            throw new RuntimeException("The root node should be <database>");
        }

        String driverClassName = "";
        String url = "";
        String username = "";
        String password = "";
        Connection connection = null;
        for (Element element : node.elements()) {
            if ("properties".equals(element.getName())) {
                for (Element ele : element.elements()) {
                    String value = ele.attributeValue("value");
                    String name = ele.attributeValue("name");
                    if ("".equals(name) || ("".equals(value))) {
                        throw new RuntimeException("The properties node should not be <properties name=\"\" value=\"\"/>");
                    }
                    if ("driverClassName".equals(name)) {
                        driverClassName = value;
                    } else if ("url".equals(name)) {
                        url = value;
                    } else if ("username".equals(name)) {
                        username = value;
                    } else if ("password".equals(name)) {
                        password = value;
                    }
                }
            }
        }

        try {
            Class<?> aClass = Class.forName(driverClassName);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    /**
     * 读取 XxxMapper.xml 文件，创建对应的 MapperBean 对象
     *
     * @param path 就是 xml 的路径 + 文件名
     * @return
     */
    public MapperBean readMapper(String path) {
        MapperBean mapperBean = new MapperBean();
        InputStream inputStream = loader.getResourceAsStream(path);
        try {
            Document document = new SAXReader().read(inputStream);
            String namespace = document.getRootElement().attributeValue("namespace").trim();
            // 设置相关的属性
            mapperBean.setInterfaceName(namespace);
            List<Function> functions = new ArrayList<>();
            // 拿到根节点下面的写的 配置信息
            for (Element element : document.getRootElement().elements()) {
                String name = element.getName();
                if ("select".equals(name)) {
                    Object resultType = Class.forName(element.attributeValue("resultType").trim()).newInstance();
                    Function function = getFunction(element);
                    function.setSqlType("select");
                    function.setResultType(resultType);
                    functions.add(function);
                } else if ("insert".equals(name)) {
                    String parameterType = element.attributeValue("parameterType").trim();
                    Function function = getFunction(element);
                    function.setSqlType("insert");
                    function.setParameterType(parameterType);
                    functions.add(function);
                } else if ("update".equals(name)) {
                    String parameterType = element.attributeValue("parameterType").trim();
                    Function function = getFunction(element);
                    function.setSqlType("update");
                    function.setParameterType(parameterType);
                    functions.add(function);
                } else if ("delete".equals(name)) {
                    String parameterType = element.attributeValue("parameterType").trim();
                    Function function = getFunction(element);
                    function.setSqlType("delete");
                    function.setParameterType(parameterType);
                    functions.add(function);
                }
            }
            mapperBean.setFunctions(functions);
        } catch (DocumentException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return mapperBean;
    }

    /**
     * 获取 Function 配置文件
     *
     * @param element 节点
     * @return Function 对象
     */
    private Function getFunction(Element element) {
        Function function = new Function();

        String id = element.attributeValue("id").trim();
        String sql = element.getText().trim();

        // 如果有 "" 、null
        if (StringUtils.isAllBlank(id, sql)) {
            throw new RuntimeException("The corresponding attribute cannot be empty");
        }

        function.setFuncName(id);
        function.setSql(sql);
        return function;
    }
}
