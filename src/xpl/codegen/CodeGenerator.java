package xpl.codegen;

public class CodeGenerator {
  private Context context = new Context();
  private ContextInitializer contextInitializer = new ContextInitializer();

  private CodeGeneratorArithmetic  cgArithmetic  = new CodeGeneratorArithmetic(context);
  private CodeGeneratorBoolean     cgBoolean     = new CodeGeneratorBoolean(context);
  private CodeGeneratorConditional cgConditional = new CodeGeneratorConditional(context);
  private CodeGeneratorLoop        cgLoop        = new CodeGeneratorLoop(context);
  private CodeGeneratorMethod      cgMethod      = new CodeGeneratorMethod(context);
  private CodeGeneratorMisc        cgMisc        = new CodeGeneratorMisc(context);
  private CodeGeneratorString      cgString      = new CodeGeneratorString(context);

  public CodeGeneratorArithmetic   arithmetic()  { return cgArithmetic; }
  public CodeGeneratorBoolean      bool()        { return cgBoolean; }
  public CodeGeneratorConditional  conditional() { return cgConditional; }
  public CodeGeneratorLoop         loop()        { return cgLoop; }
  public CodeGeneratorMethod       method()      { return cgMethod; }
  public CodeGeneratorMisc         misc()        { return cgMisc; }
  public CodeGeneratorString       string()      { return cgString; }

  private Output output;
  public  Output getOutput() { return output; }

  public CodeGenerator(String filename) {
    contextInitializer.initialize(context, filename);
    output = new Output(context.getClassWriter(), filename);
  }
}
