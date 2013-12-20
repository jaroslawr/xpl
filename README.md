xpl
===

This is a toy programming language and compiler that emits JVM code. About the most sophisticated program that can currently be compiled is this example (square root via Newton's method example from SICP):

```
fn average(real a, real b) -> real
  (a + b) / 2
end

fn square(real x) -> real
  x * x
end

fn abs(real x) -> real
  if(x >= 0) x else -x end
end

fn sqrt(real x) -> real
  fn improve(real guess, real x) -> real
    average(guess, x / guess)
  end

  fn goodenough(real guess, real x) -> int
    abs(square(guess) - x) < 0.0001
  end

  fn sqrtiter(real guess, real x) -> real
    if(goodenough(guess, x))
      guess
    else
      sqrtiter(improve(guess, x), x)
    end
  end

  sqrtiter(1.0, x)
end

print(sqrt(3.0))
```

The compiler has a suite of quite a few integration tests, so some other example programs can be found in tests/integration/positive, in files with .xpl extension, with corresponding .output-desired files containing the output expected from the program. tests/integration/negative are programs that are expected to not be compiled by the compiler, and the corresponding .compilation-desired file contains the desired compiler output in such case.
