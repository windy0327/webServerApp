package com.server.org;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.HttpURLConnection;
public  class MyResponseHandler implements HttpHandler {
    String responseMessage;
    StringBuilder dataInput = new StringBuilder();

    public void handle(HttpExchange httpExchange) throws IOException {
        String dataInputFromKeyboard;


        InputStream in=httpExchange.getRequestBody();
        BufferedReader reader=new BufferedReader(new InputStreamReader(in));

        while ((dataInputFromKeyboard=(String)reader.readLine())!=null){
            dataInput.append(dataInputFromKeyboard);
            System.out.println("client request:"+dataInputFromKeyboard);
        }
        responseMessage = dataInput.toString();
        String responseMsn=responseMessage;
        httpExchange.sendResponseHeaders(HttpURLConnection.HTTP_OK,responseMsn.length());
        OutputStream out=httpExchange.getResponseBody();
        out.write(responseMsn.getBytes());
        out.flush();
        out.close();
    }
 }

