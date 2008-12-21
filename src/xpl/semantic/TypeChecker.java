package xpl.semantic;

import xpl.semantic.ast.*;

import java.util.*;

public class TypeChecker {
  public static void infer(ASTNode deduced, final ASTNode a, final ASTNode b) {
    if(a.isOf(Types.String) || b.isOf(Types.String))
      deduced.setNodeType(Types.String);
    else if(a.isOf(Types.Real) || b.isOf(Types.Real))
      deduced.setNodeType(Types.Real);
    else
      deduced.setNodeType(Types.Integer);
  }

  public static void infer(ASTNode deduced, final List<ASTNode> list) {
    if(containsType(list, Types.String))
      deduced.setNodeType(Types.String);
    else if(containsType(list, Types.Real))
      deduced.setNodeType(Types.Real);
    else
      deduced.setNodeType(Types.Integer);
  }

  private static boolean containsType(final List<ASTNode> astNodes, Type type) {
    for(ASTNode node : astNodes)
      if(node.isOf(type))
	return true;
    return false;
  }
}
