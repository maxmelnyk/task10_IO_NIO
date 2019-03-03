package com.melnyk.rw;


import java.io.*;

public class MyInputStream extends FilterInputStream {

  private byte[] buf;
  private int pos;

  public MyInputStream(InputStream in, int size) {
    super(in);
    if (size <= 0) {
      throw new IllegalArgumentException("size <= 0");
    }
    this.buf = new byte[size];
    this.pos = size;
  }

  public MyInputStream(InputStream in) {
    this(in, 1);
  }

  private void ensureOpen() throws IOException {
    if (in == null) {
      throw new IOException("Stream closed");
    }
  }

  @Override
  public int read() throws IOException {
    ensureOpen();
    if (pos < buf.length) {
      return buf[pos++] & 0xff;
    }
    return super.read();
  }

  public int available() throws IOException {
    ensureOpen();
    int n = buf.length - pos;
    int avail = super.available();
    return n > (Integer.MAX_VALUE - avail)
        ? Integer.MAX_VALUE
        : n + avail;
  }

  public synchronized void close() throws IOException {
    if (in == null) {
      return;
    }
    in.close();
    in = null;
    buf = null;
  }
}
