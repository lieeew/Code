package com.hspedu.tomcat.http;

import javax.swing.plaf.SplitPaneUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @Author: qxy
 * @Date: 2023/3/6
 * @Description:
 */
public class HspRequest {
    private String method;
    private String uri;
    private InputStream inputStream;
    private HashMap<String, String> parameters = new HashMap<String, String>();

    public HspRequest(InputStream inputStream) {
        this.inputStream = inputStream;
        initRequest();
    }

    public void initRequest() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            // get /hspServlet?num1=12&num2=18
            String mesHeader = bufferedReader.readLine();
            method = mesHeader.split(" ")[0];
            if (!mesHeader.contains("?")) {
                uri = mesHeader.split(" ")[1];
            } else {
                uri = mesHeader.split(" ")[1].split("[?]")[0];
                String paramters = mesHeader.split(" ")[1].split("[?]")[1];
                if (paramters != null) {
                    String[] split = paramters.split("[&]");
                    for (String s : split) {
                        if (s.split("[=]").length == 2) {
                            parameters.put(s.split("[=]")[0], s.split("[=]")[1]);
                        }
                    }
                }
            }
            System.out.println("method = " + method);
            System.out.println("uri = " + uri);
            System.out.println("parameters = " + parameters);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getMethod() {
        return method;
    }

    public String getUri() {
        return uri;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public String getParameter(String name) {
        return parameters.get(name);
    }
}
