package xpl.codegen;

import xpl.semantic.ast.*;
import xpl.semantic.symbols.*;
import xpl.semantic.Types;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class CodeGeneratorMisc extends CodeGeneratorModule {
  public CodeGeneratorMisc(Context context) { super(context); }

  private int stackDepth = 0;
  public int getStackDepth() { return stackDepth; }

  public void load(ASTNode numberNode) {
    stackDepth += 1;
    if(numberNode.getNodeType() == Types.Integer)
      currentMethod.visitLdcInsn(Integer.parseInt(numberNode.getText()));
    else
      currentMethod.visitLdcInsn(Double.parseDouble(numberNode.getText()));
    promoteType(numberNode);
  }

  public void pushThis() {
    currentMethod.visitVarInsn(ALOAD, 0);
  };

  public void createVariable(VariableNode node) {
    Variable var = node.getVariable();
    classWriter.visitField(ACC_PUBLIC, var.getVariableId(), var.typeSignature(), "", null);
    assignToVariable(node);
  }

  public void assignToVariable(VariableNode node) {
    Variable var = node.getVariable();
    currentMethod.visitFieldInsn(PUTFIELD, className, var.getVariableId(), var.typeSignature());
  }

  public void loadVariable(IdentifierNode node) {
    Identifier identifier = node.getIdentifier();

    if(identifier instanceof Argument) {
      Argument arg = (Argument) identifier;
      if(arg.getType().equals(Types.Integer))
	currentMethod.visitVarInsn(ILOAD, arg.getId());
      else if(arg.getType().equals(Types.Real))
	currentMethod.visitVarInsn(DLOAD, arg.getId());
      else
	currentMethod.visitVarInsn(ALOAD, arg.getId());
    }
    else if (identifier instanceof Variable) {
      Variable var = (Variable) identifier;
      currentMethod.visitVarInsn(ALOAD, 0);
      currentMethod.visitFieldInsn(GETFIELD, className, var.getVariableId(), var.typeSignature());
    }

    promoteType(node);
  }

  public void finish() {
    currentMethod.visitInsn(RETURN);
    currentMethod.visitMaxs(10, 1);
    currentMethod.visitEnd();
  }

  private void promoteType(ASTNode operationNode) {
    if(operationNode.getTypeToPromoteTo() != null)
      currentMethod.visitInsn(I2D);
  }
}
