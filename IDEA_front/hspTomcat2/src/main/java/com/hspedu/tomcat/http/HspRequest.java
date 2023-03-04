package com.hspedu.tomcat.http;

/**
 * @author 韩顺平
 * @version 1.0
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * 老韩解读
 * 1. HspRequest 作用是封装http请求的数据
 * get /hspCalServlet?num1=10&num2=30
 * 2. 比如 method(get) 、 uri(/hspCalServlet) 、 还有参数列表 (num1=10&num2=30)
 * 3. HspRequest 作用就等价原生的servlet 中的HttpServletRequest
 * 4. 一会老韩在走代码
 * 5. 老韩这里考虑的是GET请求
 */
public class HspRequest {

    private String method;
    private String uri;
    //存放参数列表 参数名-参数值 => HashMap
    private HashMap<String, String> parametersMapping =
            new HashMap<String, String>();
    private InputStream inputStream = null;


    //构造器=> 对http请求进行封装 => 可以将老师写的代码封装成方法
    //inputStream 是和 对应http请求的socket关联
    public HspRequest(InputStream inputStream) {
        this.inputStream = inputStream;
        //完成对http请求数据的封装..
        encapHttpRequest();
    }

    /**
     * 将http请求的相关数据，进行封装,然后提供相关的方法，进行获取
     */
    private void encapHttpRequest() {
        System.out.println("HspRequest init()");
        try {
            //inputstream -> BufferedReader
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(inputStream, "utf-8"));

            //读取第一行
            /**
             * GET /hspCalServlet?num1=10&num2=30 HTTP/1.1
             * Host: localhost:8080
             * User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:97.0) Gecko/20100101 Fi
             */
            String requestLine = bufferedReader.readLine();
            //GET - /hspCalServlet?num1=10&num2=30 - HTTP/1.1
            String[] requestLineArr = requestLine.split(" ");
            //得到method
            method = requestLineArr[0];
            //解析得到 /hspCalServlet
            //1. 先看看uri 有没有参数列表
            int index = requestLineArr[1].indexOf("?");
            if (index == -1) { //说明没有参数列表
                uri = requestLineArr[1];
            } else {
                //[0,index)
                uri = requestLineArr[1].substring(0, index);
                //获取参数列表->parametersMapping
                //parameters => num1=10&num2=30
                String parameters = requestLineArr[1].substring(index + 1);
                //num1=10 , num2=30 .... parametersPair= ["num1=10","num2=30" ]
                String[] parametersPair = parameters.split("&");
                //防止用户提交时 /hspCalServlet?
                if (null != parametersPair && !"".equals(parametersPair)) {
                    //再次分割 parameterPair = num1=10
                    for (String parameterPair : parametersPair) {
                        //parameterVal ["num1", "10"]
                        String[] parameterVal = parameterPair.split("=");
                        if (parameterVal.length == 2) {
                            //放入到 parametersMapping
                            parametersMapping.put(parameterVal[0], parameterVal[1]);
                        }
                    }
                }
            }
            //这里不能关闭流 inputStream 和 socket关联
            //inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //request对象有一个特别重要方法
    public String getParameter(String name) {
        if (parametersMapping.containsKey(name)) {
            return parametersMapping.get(name);
        } else {
            return "";
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

    @Override
    public String toString() {
        return "HspRequest{" +
                "method='" + method + '\'' +
                ", uri='" + uri + '\'' +
                ", parametersMapping=" + parametersMapping +
                '}';
    }
}
