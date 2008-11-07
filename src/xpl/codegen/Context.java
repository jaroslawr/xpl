package xpl.codegen;

import java.util.*;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class Context {
  private String        className;
  private ClassWriter   classWriter;
  public  ClassWriter   getClassWriter() { return classWriter; }

  private MethodVisitor initMethodVisitor;
  private MethodVisitor mainMethodVisitor;
  private MethodVisitor runMethodVisitor;
  private MethodVisitor currentMethodVisitor;

  public void initialize(String className, ClassWriter classWriter, MethodVisitor initMethodVisitor, MethodVisitor mainMethodVisitor, MethodVisitor runMethodVisitor) {
    this.initMethodVisitor = initMethodVisitor;
    this.mainMethodVisitor = mainMethodVisitor;
    this.runMethodVisitor  = runMethodVisitor;

    switchClassWriter(className, classWriter);
    switchMethodVisitor(runMethodVisitor);
  }

  private ArrayList<CodeGeneratorModule> observers = new ArrayList<CodeGeneratorModule>();

  public void subscribe(CodeGeneratorModule observer) {
    observers.add(observer);
  }

  public void switchMethodVisitor(MethodVisitor methodVisitor) {
    this.currentMethodVisitor = methodVisitor;
    for(CodeGeneratorModule observer : observers)
      observer.currentMethodVisitorChanged(currentMethodVisitor);
  }

  public void switchClassWriter(String className, ClassWriter classWriter) {
    this.className   = className;
    this.classWriter = classWriter;

    for(CodeGeneratorModule observer : observers)
      observer.classChanged(className, classWriter);
  }
}
