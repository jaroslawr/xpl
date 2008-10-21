import java.util.*;

import org.objectweb.asm.MethodVisitor;

public class CodeGeneratorMethod extends CodeGeneratorModule {
  private Hashtable<String, String> builtinMethods = new Hashtable<String, String>() {{
      put("puts", "(Ljava/lang/String;)V");
      put("print", "(I)V");
      put("power", "(II)I");
    }};

  public CodeGeneratorMethod(Context context) {
    super(context);
  }

  public void definition(String name) {
    Method method = symbolTable.findMethod(name);
    MethodVisitor methodVisitor = classWriter.visitMethod(ACC_PUBLIC, name, method.getSignature(), null, null);
    context.switchMethodVisitor(methodVisitor);
  }

  public void ret() {
    currentMethod.visitInsn(IRETURN);
  }

  public void finish(int argumentsCount) {
    currentMethod.visitInsn(IRETURN);
    currentMethod.visitMaxs(10, argumentsCount);
    context.leaveMethod();
    symbolTable.exitFrame();
  }

  public void prepareCall() {
    currentMethod.visitVarInsn(ALOAD, 0);
  }

  public void call(String name) {
    String signature = builtinMethods.get(name);
    if(signature != null) {
      currentMethod.visitMethodInsn(INVOKESTATIC, "Runtime", name, signature);
      currentMethod.visitInsn(POP);
    }
    else {
      Method method = symbolTable.findMethod(name);
      currentMethod.visitMethodInsn(INVOKEVIRTUAL, className, name, method.getSignature());
    }
  }
}
