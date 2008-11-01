package xpl.codegen;

import java.io.*;

import org.objectweb.asm.ClassWriter;

public class Output {
  private ClassWriter writer;
  private String      filename;

  public Output(ClassWriter writer, String filename) {
    this.writer   = writer;
    this.filename = filename;
  }

  public void save() {
    try {
      FileOutputStream stream = new FileOutputStream(filename);
      stream.write(writer.toByteArray());
      stream.close();
    }
    catch(IOException e) {
      System.out.println("Input/output error");
    }
  }
}
