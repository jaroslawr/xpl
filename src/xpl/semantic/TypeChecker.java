package xpl.semantic;

import xpl.semantic.ast.*;

import java.util.*;

public class TypeChecker {
    public static void infer(ASTNode deduced, final ASTNode a, final ASTNode b) {
        if(a.isOf(Types.String) || b.isOf(Types.String))
            deduced.setNodeType(Types.String);
        else
            deduced.setNodeType(Types.Integer);
    }

    public static void infer(ASTNode deduced, final List<ASTNode> list) {
        if(containsString(list))
            deduced.setNodeType(Types.String);
        else
            deduced.setNodeType(Types.Integer);
    }

    private static void infer(ASTNode deduced, final ASTNode node, final List<ASTNode> list) {
        if(node.isOf(Types.String) || containsString(list))
            deduced.setNodeType(Types.String);
        else
            deduced.setNodeType(Types.Integer);
    }

    private static boolean containsString(final List<ASTNode> astNodes) {
        for(ASTNode node : astNodes)
            if(node.isOf(Types.String))
                return true;
        return false;
    }
}
