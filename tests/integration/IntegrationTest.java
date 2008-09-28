// This is a convienience wrapper around the work the ant task does -
// the task compiles the given .xpl program, saves the compilation
// output, runs it, saves the output of the run and finally diff's the
// output of the run with an predefined output. This class uses the
// JUnit interface to see if the output is correct and signal errors
// using the compilation output and the diff.

import java.io.*;
import java.util.*;

import org.junit.*;
import static junit.framework.Assert.*;

import org.apache.commons.io.*;
import org.apache.commons.io.filefilter.*;

public class IntegrationTest {
  private String filename;
  private String path;
  private String basename;

  @Test
  public void keepsLanguageConformance() {
    File   dir            = new File("tests/integration");
    FilenameFilter filter = new RegexFileFilter("^.*\\.xpl$");
    File[] files          = dir.listFiles(filter);

    for (File xplProgramFile : files) {
      filename  = xplProgramFile.toString();
      path      = FilenameUtils.getPath(filename);
      basename  = FilenameUtils.getBaseName(filename);

      checkIfWasCompiled(xplProgramFile);
      checkIfOutputWasCorrect(xplProgramFile);
    }
  }

  private void checkIfWasCompiled(File xplProgramFile) {
    File xplClassFile = new File(path + basename + ".class");
    if(!xplClassFile.exists()) {
      try {
	File  compilationOutputFile = new File(path + basename + ".compilation");
	String compilationOutput    = listToString(FileUtils.readLines(compilationOutputFile));
	fail(xplProgramFile + " couldn't be compiled\n" + compilationOutput);
      }
      catch(IOException e) {
	fail(xplProgramFile + " compilation output isn't available");
      }
    }
  }

  private void checkIfOutputWasCorrect(File xplProgramFile) {
    try {
      File   desiredOutputFile = new File(path + basename + ".output-desired");
      String desiredOutput     = listToString(FileUtils.readLines(desiredOutputFile));

      File   currentOutputFile = new File(path + basename + ".output-current");
      String currentOutput     = listToString(FileUtils.readLines(currentOutputFile));

      if(!currentOutput.equals(desiredOutput)) {
	File   outputsDiffFile = new File(path + basename + ".output-diff");
	String outputsDiff     = listToString(FileUtils.readLines(outputsDiffFile));
	fail(xplProgramFile + " gave incorrect output\n" + outputsDiff);
      }
    }
    catch(IOException e) {
      fail(xplProgramFile + " outputs aren't available");
    }
  }

  private String listToString(List list) {
    String result = "";
    for(Object o : list)
      result += (o.toString() + "\n");
    return result;
  }
}
