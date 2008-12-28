package xpl.codegen;

import org.objectweb.asm.ClassWriter;

public class CodeGenerator {
  private Context context = new Context(null, null, null);

  private CodeGeneratorMain        cgMain        = new CodeGeneratorMain(context);

  private CodeGeneratorArithmetic  cgArithmetic  = new CodeGeneratorArithmetic(context);
  private CodeGeneratorBoolean     cgBoolean     = new CodeGeneratorBoolean(context);
  private CodeGeneratorConditional cgConditional = new CodeGeneratorConditional(context);
  private CodeGeneratorConstant    cgConstant    = new CodeGeneratorConstant(context);
  private CodeGeneratorLoop        cgLoop        = new CodeGeneratorLoop(context);
  private CodeGeneratorMethod      cgMethod      = new CodeGeneratorMethod(context);
  private CodeGeneratorString      cgString      = new CodeGeneratorString(context);
  private CodeGeneratorVariable    cgVariable    = new CodeGeneratorVariable(context);

  public CodeGeneratorArithmetic   arithmetic()  { return cgArithmetic; }
  public CodeGeneratorBoolean      bool()        { return cgBoolean; }
  public CodeGeneratorConditional  conditional() { return cgConditional; }
  public CodeGeneratorConstant     constant()    { return cgConstant; }
  public CodeGeneratorLoop         loop()        { return cgLoop; }
  public CodeGeneratorMethod       method()      { return cgMethod; }
  public CodeGeneratorString       string()      { return cgString; }
  public CodeGeneratorVariable     variable()    { return cgVariable; }

  private ClassWriter result;

  public CodeGenerator(String filename) {
    result = cgMain.stubMainClass(filename);
  }

  public byte[] finish() {
    cgMain.finishMainClass();
    return result.toByteArray();
  }
}
