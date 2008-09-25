import java.util.*;

import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

public class CodeGeneratorConditional extends CodeGeneratorModule {
  public CodeGeneratorConditional(Context context) { super(context); }

  private Stack<Label> labels = new Stack<Label>();

  public void ifAfterCondition() {
    labels.push(new Label());
    currentMethod.visitJumpInsn(IFEQ, labels.peek());
  }

  public void ifAfterBody() {
    currentMethod.visitLabel(labels.pop());
  }
}
