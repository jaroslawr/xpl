package xpl.semantic;

import xpl.semantic.ast.*;

import java.util.*;

/**
 * The type checker estabilishes the type of a parent AST node based
 * on the type of the two or more child nodes
 *
 * @author Jarosław Rzeszótko
 */

public class TypeChecker {
  private Type[] typePrecedence = { Types.String, Types.Real, Types.Integer };

  /**
     Find the type of 'parent' based on the types of 'childA' and 'childB'

     @param parent The parent node of 'childA' and 'childB' in the AST
     @param childA The left child node of 'parent'
     @param childB The right child node of 'parent'
  */
  public void findType(ASTNode parent, final ASTNode childA, final ASTNode childB) {
    for(Type type : typePrecedence) {
      if(childA.isOf(type) || childB.isOf(type)) {
	parent.setNodeType(type);
	return;
      }
    }
  }

  /**
     A version of the 'findType' method, that additionally handles
     promotion of numeric types when the parent and one of the childs
     numeric type is different from the second childs type

     @param parent The parent node of 'childA' and 'childB' in the AST
     @param childA The left child node of 'parent'
     @param childB The right child node of 'parent'
  */
  public void findTypeWithTypePromotion(ASTNode parent, ASTNode childA, ASTNode childB) {
    findType(parent, childA, childB);
    numericTypesPromotion(parent, childA, childB);
  }

  /**
     Find the type of 'parent' based on the types of the 'children'
     nodes

     @param parent The parent node of 'childA' and 'childB' in the AST
     @param children A list of children nodes
  */
  public void findType(ASTNode parent, final List<ASTNode> children) {
    for(Type type : typePrecedence) {
      for(ASTNode child : children) {
	if(child.isOf(type)) {
	  parent.setNodeType(type);
	  return;
	}
      }
    }
  }

  private void numericTypesPromotion(ASTNode parent, ASTNode childA, ASTNode childB) {
    if(parent.isOf(Types.Real)) {
      if(!childA.isOf(Types.Real)) childA.setTypeToPromoteTo(Types.Real);
      if(!childB.isOf(Types.Real)) childB.setTypeToPromoteTo(Types.Real);
    }
  }
}
