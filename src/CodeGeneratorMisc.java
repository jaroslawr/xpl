import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class CodeGeneratorMisc extends CodeGeneratorModule {
  public CodeGeneratorMisc(Context context) { super(context); }

  private int stackDepth = 0;
  public int getStackDepth() { return stackDepth; }

  public void load(int number) { stackDepth += 1; currentMethod.visitLdcInsn(number); }

  public void pushThis() {
    currentMethod.visitVarInsn(ALOAD, 0);
  };

  public void storeVariable(String name) {
    LocalVariable var = (LocalVariable) scope.lookup(name);
    if(!var.isInitialized()) {
      classWriter.visitField(ACC_PUBLIC, var.getVariableId(), "I", "", null);
      var.makeInitialized();
    }
    currentMethod.visitFieldInsn(PUTFIELD, className, var.getVariableId(), "I");
  }

  public void loadVariable(String name) {
    Symbol sym = scope.lookup(name);

    if(sym.isOfType("argument")) {
      Argument arg = (Argument) sym;
      currentMethod.visitVarInsn(ILOAD, arg.getId());
    }
    else if (sym.isOfType("local-variable")) {
      LocalVariable var = (LocalVariable) sym;
      currentMethod.visitVarInsn(ALOAD, 0);
      currentMethod.visitFieldInsn(GETFIELD, className, var.getVariableId(), "I");
    }
  }

  public void finish() {
    currentMethod.visitInsn(RETURN);
    currentMethod.visitMaxs(stackDepth, 1);
    currentMethod.visitEnd();
  }
}
