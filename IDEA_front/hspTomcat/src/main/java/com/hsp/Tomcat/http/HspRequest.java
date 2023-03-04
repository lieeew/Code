package com.hsp.Tomcat.http;

import java.io.*;
import java.util.HashMap;

/**
 * @Author: qxy
 * @Date: 2023/2/28
 * @Description:
 */

/*
  1. HspRequest 作用封装http请求数据
   GET /hspServlet?num1=10&num2=20
   method(get) url(/hspServlet) 参数列表(num1=10&num2=20)
  2. method get/post url ,参数
  3. HttpRequest 等价于原生Tomcat中的HttpServletRequest
  4. 先考虑get请求
 */
public class HspRequest {
    private String method;
    private String uri;
    // 存放参数(因为可能会有多个)所以可以使用一个HashMap
    private HashMap<String, String> parametersMaps = new HashMap<>();
    // 以后要是使用的话, 可以在其他方法使用, 所以尽量还是一个属性
    private InputStream inputStream = null;
    public HspRequest(InputStream inputStream) {
        this.inputStream = inputStream;
        escapHttpRequest();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 重要的方法
     * @param name 需要返回的名字
     * @return 对应的值
     */
    public String getParameterts(String name) {
        return parametersMaps.getOrDefault(name, "");
    }

    /**
     * 完成對http請求的封裝, 将http请求的方式进行封装
     */
    public void escapHttpRequest() {
        System.out.println("init()被调用");
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            String content = bufferedReader.readLine();
            // GET /hspServlet?num1=10&num2=20 HTTP/1.0
            method = content.split(" ")[0];
            // 有沒有參數列表
            if (!content.contains("?")) {
                uri =  content.split(" ")[1];
            } else {
                uri = content.split(" ")[1].split("[?]")[0];
                String[] parameters = content.split(" ")[1].split("[?]")[1].split("[&]");
                if (null != parameters && !"".equals(parameters)) { // 防止存在只有?没有值得情况
                    for (String parameter : parameters) {
                        String[] split = parameter.split("[=]");
                        if (split.length == 2) { // 如果有两个就放入
                            parametersMaps.put(split[0], split[1]);
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "HspRequest{" +
                "method='" + method + '\'' +
                ", uri='" + uri + '\'' +
                ", parametersMaps=" + parametersMaps +
                '}';
    }

}
