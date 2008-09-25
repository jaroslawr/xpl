import org.objectweb.asm.MethodVisitor;

public class CodeGeneratorArithmetic extends CodeGeneratorModule {
  public CodeGeneratorArithmetic(Context context) { super(context); }

  public void add()      { currentMethod.visitInsn(IADD); }
  public void subtract() { currentMethod.visitInsn(ISUB); }
  public void multiply() { currentMethod.visitInsn(IMUL); }
  public void divide()   { currentMethod.visitInsn(IDIV); }
  public void mod()      { currentMethod.visitInsn(IREM); }
}
