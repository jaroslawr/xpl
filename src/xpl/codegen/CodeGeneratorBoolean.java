package xpl.codegen;

import org.objectweb.asm.Label;

import xpl.semantic.ast.ASTNode;
import xpl.semantic.Types;

public class CodeGeneratorBoolean extends CodeGeneratorModule {
  public CodeGeneratorBoolean(Context context) { super(context); }

  public void or(ASTNode node) {
    currentMethod.visitInsn(IOR);
  }

  public void and(ASTNode node) {
    currentMethod.visitInsn(IAND);
  }

  public void equal(ASTNode node) {
    if(node.getNodeType() == Types.Real) {
      currentMethod.visitInsn(DCMPG);
      intComparision(IFEQ);
      return;
    }

    intComparision(IF_ICMPEQ);
  }

  public void greaterThanOrEqual(ASTNode node) {
    if(node.getNodeType() == Types.Real) {
      currentMethod.visitInsn(DCMPG);
      intComparision(IFGE);
      return;
    }

    intComparision(IF_ICMPGE);
  }

  public void lessThanOrEqual(ASTNode node) {
    if(node.getNodeType() == Types.Real) {
      currentMethod.visitInsn(DCMPL);
      intComparision(IFLE);
      return;
    }

    intComparision(IF_ICMPLE);
  }

  public void greaterThan(ASTNode node) {
    if(node.getNodeType() == Types.Real) {
      currentMethod.visitInsn(DCMPG);
      intComparision(IFGT);
      return;
    }

    intComparision(IF_ICMPGT);
  }

  public void lessThan(ASTNode node) {
    if(node.getNodeType() == Types.Real) {
      currentMethod.visitInsn(DCMPL);
      intComparision(IFLT);
      return;
    }

    intComparision(IF_ICMPLT);
  }

  private void intComparision(int opcode) {
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
