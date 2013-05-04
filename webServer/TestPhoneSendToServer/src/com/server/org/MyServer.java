package com.server.org;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.spi.HttpServerProvider;

import java.io.IOException;
import java.net.InetSocketAddress;

public class MyServer {

          public static void main(String args[]) throws IOException {
              HttpServerProvider provider=HttpServerProvider.provider();
              HttpServer server=provider.createHttpServer(new InetSocketAddress(8807),400);
              server.createContext("/home",new MyResponseHandler());
              server.setExecutor(null);
              server.start();
              System.out.println("server is started");

          }

  }



