package xpl.codegen;

public class CodeGenerator {
  private Context context;

  private CodeGeneratorArithmetic  cgArithmetic;
  private CodeGeneratorBoolean     cgBoolean;
  private CodeGeneratorConditional cgConditional;
  private CodeGeneratorConstant    cgConstant;
  private CodeGeneratorLoop        cgLoop;
  private CodeGeneratorMethod      cgMethod;
  private CodeGeneratorString      cgString;
  private CodeGeneratorVariable    cgVariable;

  public CodeGeneratorArithmetic   arithmetic()  { return cgArithmetic; }
  public CodeGeneratorBoolean      bool()        { return cgBoolean; }
  public CodeGeneratorConditional  conditional() { return cgConditional; }
  public CodeGeneratorConstant     constant()    { return cgConstant; }
  public CodeGeneratorLoop         loop()        { return cgLoop; }
  public CodeGeneratorMethod       method()      { return cgMethod; }
  public CodeGeneratorString       string()      { return cgString; }
  public CodeGeneratorVariable     variable()    { return cgVariable; }

  private Output output;

  public CodeGenerator(String filename) {
    context       = new ContextBuilder().create(filename);
    output        = new Output(context.getClassWriter(), filename);

    cgArithmetic  = new CodeGeneratorArithmetic(context);
    cgBoolean     = new CodeGeneratorBoolean(context);
    cgConditional = new CodeGeneratorConditional(context);
    cgConstant    = new CodeGeneratorConstant(context);
    cgLoop        = new CodeGeneratorLoop(context);
    cgMethod      = new CodeGeneratorMethod(context);
    cgString      = new CodeGeneratorString(context);
    cgVariable    = new CodeGeneratorVariable(context);
  }

  public void finish() {
    context.finish();
    output.save();
  }
}
