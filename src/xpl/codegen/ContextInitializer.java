package xpl.codegen;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ContextInitializer implements Opcodes {
  private ClassWriter classWriter;
  private String className;

  public void initialize(Context context, String filename) {
    this.className   = extractClassName(filename);
    this.classWriter = stubClass();

    context.initialize(className, classWriter, generateInit(), generateMain(), generateRun());
  }

  private ClassWriter stubClass() {
    ClassWriter classWriter = new ClassWriter(0);
    classWriter.visit(V1_1, ACC_PUBLIC, className, null, "java/lang/Object", null);
    return classWriter;
  }

  private MethodVisitor generateInit() {
    MethodVisitor visitor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
    visitor.visitVarInsn(ALOAD, 0);
    visitor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
    visitor.visitInsn(RETURN);
    visitor.visitMaxs(1, 1);
    visitor.visitEnd();
    return visitor;
  }

  private MethodVisitor generateMain() {
    MethodVisitor visitor = classWriter.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
    visitor.visitTypeInsn(NEW, className);
    visitor.visitInsn(DUP);
    visitor.visitMethodInsn(INVOKESPECIAL, className, "<init>", "()V");
    visitor.visitMethodInsn(INVOKEVIRTUAL, className, "run", "()V");
    visitor.visitInsn(RETURN);
    visitor.visitMaxs(2, 1);
    visitor.visitEnd();
    return visitor;
  }

  private MethodVisitor generateRun() {
    return classWriter.visitMethod(ACC_PUBLIC, "run", "()V", null, null);
  }

  private String extractClassName(String filename) {
    return filename.substring(filename.lastIndexOf("/")+1, filename.indexOf("."));
  }
}