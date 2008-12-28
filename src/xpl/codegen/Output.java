package xpl.codegen;

import java.io.*;

import org.objectweb.asm.ClassWriter;

public class Output {
  private String filename;
  private byte[] bytes;

  public Output(String filename, byte[] bytes) {
    this.filename = filename;
    this.bytes    = bytes;
  }

  public void save() {
    try {
      FileOutputStream stream = new FileOutputStream(filename);
      stream.write(bytes);
      stream.close();
    }
    catch(IOException e) {
      System.out.println("Input/output error");
    }
  }
}
