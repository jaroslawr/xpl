import java.util.*;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

public class CodeGeneratorLoop extends CodeGeneratorModule {
  public CodeGeneratorLoop(Context context) { super(context); }

  private Stack<Label> loopStartLabels = new Stack<Label>();
  private Stack<Label> loopEndLabels   = new Stack<Label>();

  public void whileBeforeCondition() {
    loopStartLabels.push(new Label());
    loopEndLabels.push(new Label());
    currentMethod.visitLabel(loopStartLabels.peek());
  }

  public void whileAfterCondition() {
    currentMethod.visitJumpInsn(IFEQ, loopEndLabels.peek());
  }

  public void whileAfterBody() {
    currentMethod.visitJumpInsn(GOTO, loopStartLabels.peek());
    currentMethod.visitLabel(loopEndLabels.peek());
    loopStartLabels.pop();
    loopEndLabels.pop();
  }
}
