import java.util.*;

import org.objectweb.asm.MethodVisitor;

public class CodeGeneratorMethod extends CodeGeneratorModule {
  private Hashtable<String, String> builtinMethods = new Hashtable<String, String>() {{
      put("print", "(I)V");
      put("power", "(II)I");
    }};

  public CodeGeneratorMethod(Context context) {
    super(context);
  }

  public void definition(String name) {
    Method method = (Method) scope.lookup(name);
    MethodVisitor methodVisitor = classWriter.visitMethod(ACC_PUBLIC, name, method.getSignature(), null, null);
    context.switchMethodVisitor(methodVisitor);
  }

  public void ret() {
    currentMethod.visitInsn(IRETURN);
  }

  public void finish() {
    currentMethod.visitInsn(IRETURN);
    currentMethod.visitMaxs(10, scope.getArgumentsCount() + 1);
    context.leaveMethod();
    context.switchScope(scope.getParentScope());
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
      Method method = (Method) scope.lookup(name);
      currentMethod.visitMethodInsn(INVOKEVIRTUAL, className, name, method.getSignature());
    }
  }
}
