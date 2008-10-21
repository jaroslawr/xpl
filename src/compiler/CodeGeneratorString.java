import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;

public class CodeGeneratorString extends CodeGeneratorModule {
  public CodeGeneratorString(Context context) { super(context); }

  public void builder() {
    currentMethod.visitTypeInsn(NEW, "java/lang/StringBuilder");
    currentMethod.visitInsn(DUP);
    currentMethod.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V");
  }

  public void appendInteger() {
    currentMethod.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(I)Ljava/lang/StringBuilder;");
  }

  public void appendString() {
    currentMethod.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;");
  }

  public void finish() {
    currentMethod.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;");
  }

  public void load(String string) {
    currentMethod.visitLdcInsn(string);
  }
}
