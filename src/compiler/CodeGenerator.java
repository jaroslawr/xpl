import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class CodeGenerator implements Opcodes {
  private CodeGeneratorArithmetic  cgArithmetic;
  private CodeGeneratorBoolean     cgBoolean;
  private CodeGeneratorConditional cgConditional;
  private CodeGeneratorLoop        cgLoop;
  private CodeGeneratorMethod      cgMethod;
  private CodeGeneratorMisc        cgMisc;

  public CodeGeneratorArithmetic   arithmetic()  { return cgArithmetic; }
  public CodeGeneratorBoolean      bool()        { return cgBoolean; }
  public CodeGeneratorConditional  conditional() { return cgConditional; }
  public CodeGeneratorLoop         loop()        { return cgLoop; }
  public CodeGeneratorMethod       method()      { return cgMethod; }
  public CodeGeneratorMisc         misc()        { return cgMisc; }

  private Context context;
  private ContextBuilder contextBuilder = new ContextBuilder();

  private Output output;
  public  Output getOutput() { return output; }

  public CodeGenerator(String filename) {
    context       = contextBuilder.create(extractClassName(filename));

    cgArithmetic  = new CodeGeneratorArithmetic(context);
    cgBoolean     = new CodeGeneratorBoolean(context);
    cgConditional = new CodeGeneratorConditional(context);
    cgLoop        = new CodeGeneratorLoop(context);
    cgMethod      = new CodeGeneratorMethod(context);
    cgMisc        = new CodeGeneratorMisc(context);

    output        = new Output(context.getClassWriter(), filename);
  }

  public void switchScope(Scope scope) {
    context.switchScope(scope);
  }

  private String extractClassName(String filename) {
    return filename.substring(filename.lastIndexOf("/")+1, filename.indexOf("."));
  }
}
