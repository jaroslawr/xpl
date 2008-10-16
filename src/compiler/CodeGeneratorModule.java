import org.objectweb.asm.Opcodes;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class CodeGeneratorModule implements Opcodes {
  protected Context       context;
  protected ClassWriter   classWriter;
  protected MethodVisitor currentMethod;
  protected SymbolTable   symbolTable;
  protected String        className;

  public CodeGeneratorModule(Context context) {
    this.context = context;
    this.context.subscribe(this);
  }

  public void classChanged(String className, ClassWriter classWriter) {
    this.className   = className;
    this.classWriter = classWriter;
  }

  public void currentMethodVisitorChanged(MethodVisitor currentMethod) {
    this.currentMethod = currentMethod;
  }

  public void symbolTableChanged(SymbolTable symbolTable) {
    this.symbolTable = symbolTable;
  }
}
