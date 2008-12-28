package xpl.codegen;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class CodeGeneratorMain extends CodeGeneratorModule {
  public CodeGeneratorMain(Context context) { super(context); }

  public ClassWriter stubMainClass(String filename) {
    generateMainClass(extractClassName(filename));
    generateInitMethod();
    generateMainMethod();
    generateRunMethod();

    return classWriter;
  }

  public void finishMainClass() {
    currentMethod.visitInsn(RETURN);
    currentMethod.visitMaxs(10, 1);
    currentMethod.visitEnd();
  }

  private void generateMainClass(String name) {
    ClassWriter mainClass = new ClassWriter(0);
    mainClass.visit(V1_1, ACC_PUBLIC, name, null, "java/lang/Object", null);
    context.switchClassWriter(name, mainClass);
  }

  public void generateInitMethod() {
    MethodVisitor init = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
    init.visitVarInsn(ALOAD, 0);
    init.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
    init.visitInsn(RETURN);
    init.visitMaxs(1, 1);
    init.visitEnd();
  }

  public void generateMainMethod() {
    MethodVisitor main = classWriter.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
    main.visitTypeInsn(NEW, className);
    main.visitInsn(DUP);
    main.visitMethodInsn(INVOKESPECIAL, className, "<init>", "()V");
    main.visitMethodInsn(INVOKEVIRTUAL, className, "run", "()V");
    main.visitInsn(RETURN);
    main.visitMaxs(2, 1);
    main.visitEnd();
  }

  public void generateRunMethod() {
    MethodVisitor run = classWriter.visitMethod(ACC_PUBLIC, "run", "()V", null, null);
    context.switchMethodVisitor(run);
  }

  private String extractClassName(String filename) {
    return filename.substring(filename.lastIndexOf("/")+1, filename.indexOf("."));
  }
}
