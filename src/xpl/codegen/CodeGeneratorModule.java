package xpl.codegen;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import xpl.semantic.Types;

import xpl.semantic.ast.ASTNode;

public class CodeGeneratorModule implements Opcodes {
  protected Context       context;
  protected ClassWriter   classWriter;
  protected MethodVisitor currentMethod;
  protected String        className;

  public CodeGeneratorModule(Context context) {
    this.context = context;
    this.context.subscribe(this);
  }

  public void classChanged(String className, ClassWriter classWriter) {
    this.className   = className;
    this.classWriter = classWriter;
  }

  public void currentMethodChanged(MethodVisitor currentMethod) {
    this.currentMethod = currentMethod;
  }

  protected void promoteType(ASTNode node) {
    if(node.getTypeToPromoteTo() == Types.Real)
      currentMethod.visitInsn(I2D);
  }
}
