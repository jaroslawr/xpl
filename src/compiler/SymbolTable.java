import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.util.*;

public class SymbolTable implements Opcodes {
  public SymbolTable() { enterNewFrame(); }
  
  private ArrayList<Frame> frames = new ArrayList<Frame>();
  public int getCurrentFrameId() { return frames.size()-1; }

  private Frame currentFrame = null;

  public Variable findVariable(String name) {
    return currentFrame.find(name, Variable.class);
  }

  public Argument findArgument(String name) {
    return currentFrame.find(name, Argument.class);
  }

  public LocalVariable findLocalVariable(String name) {
    return currentFrame.find(name, LocalVariable.class);
  }

  public Method findMethod(String name) {
    return currentFrame.find(name, Method.class);
  }

  public void put(Symbol sym) {
    currentFrame.put(sym.getName(), sym);
  }

  public void enterFrame(int id) {
    currentFrame = frames.get(id);
  }

  public void enterNewFrame() {
    currentFrame = new Frame(currentFrame);
    frames.add(currentFrame);
  }

  public void exitFrame()  {
    currentFrame = currentFrame.getParent();
  }

  public String toString() {
    return currentFrame.toString();
  }
}
