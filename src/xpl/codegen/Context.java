package xpl.codegen;

import java.util.*;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class Context implements Opcodes {
  private String        className;
  private ClassWriter   classWriter;
  public  ClassWriter   getClassWriter() { return classWriter; }

  private MethodVisitor runMethodVisitor;
  private MethodVisitor currentMethodVisitor;

  public Context(String className, ClassWriter classWriter, MethodVisitor runMethodVisitor) {
    this.className            = className;
    this.classWriter          = classWriter;
    this.runMethodVisitor     = runMethodVisitor;
    this.currentMethodVisitor = runMethodVisitor;
  }

  private ArrayList<CodeGeneratorModule> observers = new ArrayList<CodeGeneratorModule>();

  public void subscribe(CodeGeneratorModule observer) {
    observers.add(observer);
    observer.classChanged(className, classWriter);
    observer.currentMethodChanged(currentMethodVisitor);
  }

  public void switchMethodVisitor(MethodVisitor methodVisitor) {
    this.currentMethodVisitor = methodVisitor;
    for(CodeGeneratorModule observer : observers)
      observer.currentMethodChanged(currentMethodVisitor);
  }

  public void switchClassWriter(String className, ClassWriter classWriter) {
    this.className   = className;
    this.classWriter = classWriter;

    for(CodeGeneratorModule observer : observers)
      observer.classChanged(className, classWriter);
  }
}
