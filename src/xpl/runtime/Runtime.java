package xpl.runtime;

public class Runtime {
  public static void print(String s) {
    System.out.println(s);
  }

  public static void print(int i) {
    System.out.println(i);
  }

  public static void print(double d) {
    System.out.println(d);
  }

  public static double sqrt(double x) {
    return Math.sqrt(x);
  }

  public static int power(int n, int pow) {
    if(pow == 0)
      return 1;

    int result = 1;
    for(int i = 1; i <= pow; i++)
      result = result * n;
    return result;
  }
}
