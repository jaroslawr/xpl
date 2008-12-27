package xpl.codegen;

import xpl.semantic.ast.*;
import xpl.semantic.symbols.*;
import xpl.semantic.Types;

public class CodeGeneratorVariable extends CodeGeneratorModule {
  public CodeGeneratorVariable(Context context) { super(context); }

  public void beforeReference() {
    currentMethod.visitVarInsn(ALOAD, 0);
  };

  public void initialization(VariableNode node) {
    Variable var = node.getVariable();
    classWriter.visitField(ACC_PUBLIC, var.getVariableId(), var.typeSignature(), "", null);
    assignment(node);
  }

  public void assignment(VariableNode node) {
    Variable var = node.getVariable();
    currentMethod.visitFieldInsn(PUTFIELD, className, var.getVariableId(), var.typeSignature());
  }

  public void reference(IdentifierNode node) {
    Identifier identifier = node.getIdentifier();

    if(identifier instanceof Argument) {
      Argument arg = (Argument) identifier;
      currentMethod.visitVarInsn(InstructionSet.LOAD(arg.getType()), arg.getId());
    }
    else if (identifier instanceof Variable) {
      Variable var = (Variable) identifier;
      currentMethod.visitVarInsn(ALOAD, 0);
      currentMethod.visitFieldInsn(GETFIELD, className, var.getVariableId(), var.typeSignature());
    }

    promoteType(node);
  }
}
