package xpl.codegen;

import java.util.*;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class Context implements Opcodes {
  private String        className;
  private ClassWriter   classWriter;
  public  ClassWriter   getClassWriter() { return classWriter; }

  private MethodVisitor initMethodVisitor;
  private MethodVisitor mainMethodVisitor;
  private MethodVisitor runMethodVisitor;
  private MethodVisitor currentMethodVisitor;

  public Context(String className, ClassWriter classWriter, MethodVisitor initMethodVisitor, MethodVisitor mainMethodVisitor, MethodVisitor runMethodVisitor) {
    this.className            = className;
    this.classWriter          = classWriter;
    this.initMethodVisitor    = initMethodVisitor;
    this.mainMethodVisitor    = mainMethodVisitor;
    this.runMethodVisitor     = runMethodVisitor;
    this.currentMethodVisitor = runMethodVisitor;
  }

  public void finish() {
    currentMethodVisitor.visitInsn(RETURN);
    currentMethodVisitor.visitMaxs(10, 1);
    currentMethodVisitor.visitEnd();
  }

  private ArrayList<CodeGeneratorModule> observers = new ArrayList<CodeGeneratorModule>();

  public void subscribe(CodeGeneratorModule observer) {
    observers.add(observer);
    observer.classChanged(className, classWriter);
    observer.currentMethodVisitorChanged(currentMethodVisitor);
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
