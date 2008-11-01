package xpl.codegen;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

public class CodeGeneratorBoolean extends CodeGeneratorModule {
  public CodeGeneratorBoolean(Context context) { super(context); }

  public void or()  { currentMethod.visitInsn(IOR); }
  public void and() { currentMethod.visitInsn(IAND); }

  public void equal()              { comparision(IF_ICMPEQ); }
  public void greaterThanOrEqual() { comparision(IF_ICMPGE); }
  public void lessThanOrEqual()    { comparision(IF_ICMPLE); }
  public void greaterThan()        { comparision(IF_ICMPGT); }
  public void lessThan()           { comparision(IF_ICMPLT); }

  private void comparision(int opcode) {
    Label trueBranch = new Label();
    Label rest       = new Label();

    currentMethod.visitJumpInsn(opcode, trueBranch);
    currentMethod.visitLdcInsn(0);
    currentMethod.visitJumpInsn(GOTO, rest);
    currentMethod.visitLabel(trueBranch);
    currentMethod.visitLdcInsn(1);
    currentMethod.visitLabel(rest);
  }
}
