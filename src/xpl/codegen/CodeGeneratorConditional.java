package xpl.codegen;

import java.util.*;

import org.objectweb.asm.Label;

public class CodeGeneratorConditional extends CodeGeneratorModule {
  public CodeGeneratorConditional(Context context) { super(context); }

  private Stack<Label> labels = new Stack<Label>();

  public void ifAfterCondition(boolean hasElse) {
    if(hasElse)
      ifAfterConditionWithFalseBranch();
    else
      ifAfterConditionWithoutFalseBranch();
  }

  public void ifAfterConditionWithFalseBranch() {
    Label falseBranch = new Label();
    Label rest        = new Label();

    labels.push(falseBranch);
    labels.push(rest);

    currentMethod.visitJumpInsn(IFEQ, falseBranch);
  }

  public void ifAfterConditionWithoutFalseBranch() {
    Label rest = new Label();
    labels.push(rest);
    currentMethod.visitJumpInsn(IFEQ, rest);
  }

  public void ifElseAfterTrueBranch() {
    currentMethod.visitJumpInsn(GOTO, labels.peek());
  }

  public void ifElseBeforeFalseBranch() {
    Label rest        = labels.pop();
    Label falseBranch = labels.pop();

    currentMethod.visitLabel(falseBranch);
    labels.push(rest);
  }

  public void ifAfterBody() {
    Label rest = labels.pop();
    currentMethod.visitLabel(rest);
  }
}
