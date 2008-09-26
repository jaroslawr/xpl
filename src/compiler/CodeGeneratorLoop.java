import java.util.*;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

public class CodeGeneratorLoop extends CodeGeneratorModule {
  public CodeGeneratorLoop(Context context) { super(context); }

  private Stack<Pair<Label,Label>> loopLabels = new Stack<Pair<Label,Label>>();

  public void whileBeforeCondition() {
    loopLabels.push(new Pair<Label, Label>(new Label(), new Label()));
    currentMethod.visitLabel(loopLabels.peek().first());
  }

  public void whileAfterCondition() {
    currentMethod.visitJumpInsn(IFEQ, loopLabels.peek().second());
  }

  public void whileAfterBody() {
    currentMethod.visitJumpInsn(GOTO, loopLabels.peek().first());
    currentMethod.visitLabel(loopLabels.peek().second());
    loopLabels.pop();
  }
}
