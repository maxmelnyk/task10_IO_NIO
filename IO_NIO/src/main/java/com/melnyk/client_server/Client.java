package com.melnyk.client_server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {

  private static final int BUFFER_SIZE = 1024;
  private static String[] messages =
      {"Task 8. Write client-server program using NIO ",
          "(+ if you want, other implementation using IO).",
          "E.g. you have one server and multiple clients.",
          "A client can send direct messages to other client."};

  public static void main(String[] args) {

    System.out.println("Starting Client...");
    try {
      int port = 9999;
      InetAddress hostIP = InetAddress.getLocalHost();
      InetSocketAddress myAddress =
          new InetSocketAddress(hostIP, port);
      SocketChannel myClient = SocketChannel.open(myAddress);

      System.out.println(String.format("Trying to connect to %s:%d...",
          myAddress.getHostName(), myAddress.getPort()));

      for (String msg : messages) {
        ByteBuffer myBuffer = ByteBuffer.allocate(BUFFER_SIZE);
        myBuffer.put(msg.getBytes());
        myBuffer.flip();
        int bytesWritten = myClient.write(myBuffer);
        System.out.println(String
            .format("Sending Message...: %s\nbytesWritten...: %d",
                msg, bytesWritten));
      }
      System.out.println("Closing Client connection...");
      myClient.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }
}
