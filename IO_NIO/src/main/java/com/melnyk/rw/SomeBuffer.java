package com.melnyk.rw;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SomeBuffer {

  private final String path;
  private FileChannel fileChannel;
  private ByteBuffer buffer;

  public SomeBuffer(String path) {
    this.path = path;
  }

  public void readFromFile() throws IOException {
    fileChannel = FileChannel.open(Paths.get(path));
    buffer = ByteBuffer.allocate(1024);
    System.out.println("Read:");
    while (fileChannel.read(buffer) != -1) {
      buffer.flip();
      while (buffer.hasRemaining()) {
        System.out.print((char) buffer.get());
      }
      buffer.clear();
    }
  }

  public void writeToFile(String message) throws IOException {
    fileChannel = FileChannel.open(Paths.get(path), StandardOpenOption.WRITE);
    buffer = ByteBuffer.wrap(message.getBytes());
    fileChannel.write(buffer);
    System.out.println("Write: " + message);
  }
}
