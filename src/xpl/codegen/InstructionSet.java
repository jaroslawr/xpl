package xpl.codegen;

import org.objectweb.asm.Opcodes;

import xpl.semantic.Type;
import xpl.semantic.Types;

public class InstructionSet implements Opcodes {
  public static int LOAD(Type t) {
    if(t == Types.Integer) return ILOAD;
    if(t == Types.Real)    return DLOAD;

    return ALOAD;
  }

  public static int RETURN(Type t) {
    if(t == Types.Integer) return IRETURN;
    if(t == Types.Real)    return DRETURN;
    if(t == Types.String)  return ARETURN;

    return RETURN;
  }

  public static int ADD(Type t) {
    if(t == Types.Integer) return IADD;

    return DADD;
  }

  public static int SUB(Type t) {
    if(t == Types.Integer) return ISUB;

    return DSUB;
  }

  public static int MUL(Type t) {
    if(t == Types.Integer) return IMUL;

    return DMUL;
  }

  public static int DIV(Type t) {
    if(t == Types.Integer) return IDIV;

    return DDIV;
  }

  public static int REM(Type t) {
    if(t == Types.Integer) return IREM;

    return DREM;
  }

  public static int NEG(Type t) {
    if(t == Types.Integer) return INEG;

    return DNEG;
  }
}
