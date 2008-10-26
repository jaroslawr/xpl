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

  public void createVariable(String name) {
    Variable var = symbolTable.findVariable(name);
    classWriter.visitField(ACC_PUBLIC, var.getVariableId(), var.typeSignature(), "", null);
    assignToVariable(name);
  }

  public void assignToVariable(String name) {
    Variable var = symbolTable.findVariable(name);
    currentMethod.visitFieldInsn(PUTFIELD, className, var.getVariableId(), var.typeSignature());
  }

  public void loadVariable(String name) {
    Identifier identifier = symbolTable.findIdentifier(name);

    if(identifier instanceof Argument) {
      Argument arg = (Argument) identifier;
      currentMethod.visitVarInsn(ILOAD, arg.getId());
    }
    else if (identifier instanceof Variable) {
      Variable var = (Variable) identifier;
      currentMethod.visitVarInsn(ALOAD, 0);
      currentMethod.visitFieldInsn(GETFIELD, className, var.getVariableId(), var.typeSignature());
    }
  }

  public void finish() {
    currentMethod.visitInsn(RETURN);
    currentMethod.visitMaxs(10, 1);
    currentMethod.visitEnd();
  }
}
