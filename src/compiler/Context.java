import java.util.*;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class Context {
  private String        className;
  private SymbolTable   symbolTable;
  private ClassWriter   classWriter;
  public  ClassWriter   getClassWriter() { return classWriter; }

  private MethodVisitor initMethodVisitor;
  private MethodVisitor mainMethodVisitor;
  private MethodVisitor runMethodVisitor;
  private MethodVisitor currentMethodVisitor;

  public Context(SymbolTable symbolTable, String className, ClassWriter classWriter, MethodVisitor initMethodVisitor, MethodVisitor mainMethodVisitor, MethodVisitor runMethodVisitor) {
    this.symbolTable          = symbolTable;
    this.className            = className;
    this.classWriter          = classWriter;
    this.initMethodVisitor    = initMethodVisitor;
    this.mainMethodVisitor    = mainMethodVisitor;
    this.runMethodVisitor     = runMethodVisitor;
    this.currentMethodVisitor = runMethodVisitor;
  }

  private ArrayList<CodeGeneratorModule> observers = new ArrayList<CodeGeneratorModule>();

  public void subscribe(CodeGeneratorModule observer) {
    observers.add(observer);
    observer.classChanged(className, classWriter);
    observer.currentMethodVisitorChanged(currentMethodVisitor);
    observer.symbolTableChanged(symbolTable);
  }

  public void switchMethodVisitor(MethodVisitor methodVisitor) {
    this.currentMethodVisitor = methodVisitor;
    for(CodeGeneratorModule observer : observers)
      observer.currentMethodVisitorChanged(currentMethodVisitor);
  }

  public void enterFrame(int frameId) {
    symbolTable.enterFrame(frameId);
  }

  public void leaveMethod() {
    switchMethodVisitor(runMethodVisitor);
  }
}
