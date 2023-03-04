package com.hspedu.tomcat.http;

import java.io.*;
import java.util.HashMap;

/**
 * @Author: qxy
 * @Date: 2023/3/4
 * @Description:
 */

/*
1. 这个类的作用就是封装http请求
2.  get /calServlet?num1=12&num2=18 HTTP/1.1
3. method (get) uri(calServlet) 参数列表(num1=12&num2=18)
4. 考虑的是get请求
 */
public class HspRequest {
    private String method;
    private String uri;
    // 存放参数列表 参数名 -> 参数值 使用HashMap
    private HashMap<String, String> parametersMapping = new HashMap<String, String>();
    private InputStream inputStream = null;

    // 构造器
    public HspRequest(InputStream inputStream) {
        this.inputStream = inputStream;
        encapHttp();

    }

    /**
     * 完成对httpRquest的封装
     */
    private void encapHttp() {
        // inputStream -> BufferedReader
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            // get /calServlet?num1=12&num2=18 HTTP/1.1
            String regStr = bufferedReader.readLine();
            method = regStr.split(" ")[0];
            if (!regStr.contains("?")) {
                uri = regStr.split(" ")[1];
            } else {
                uri = regStr.split(" ")[1].split("[?]")[0];
                String[] parameters = regStr.split(" ")[1].split("[?]")[1].split("&");
                // 防止用户只提交 /calServlet?
                if (parameters != null && !"".equals(parameters)) {
                    for (String parameter : parameters) {
                        String[] parametersPair = parameter.split("[=]");
                        // 确定一定要有("num1", "12")
                        if (parametersPair.length == 2) {
                            parametersMapping.put(parametersPair[0], parametersPair[1]);
                        }
                    }
                }
            }
//            System.out.println("regStr " + regStr);
//            System.out.println("method " + method);
//            System.out.println("uri = " + uri);
//            System.out.println("parametersMapping = " + parametersMapping);

//            这里不能关闭流, 这个和socket关联, 关闭之后socket也会关闭
//            inputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getParameter(String name) {
        if (parametersMapping.containsKey(name)) { // 判读是否有这个key
            return parametersMapping.get(name);
        } else { // 没有返回null
            return null;
        }
    }

    @Override
    public String toString() {
        return "HspRequest{" +
                "method='" + method + '\'' +
                ", uri='" + uri + '\'' +
                ", parametersMapping=" + parametersMapping +
                ", inputStream=" + inputStream +
                '}';
    }
}
