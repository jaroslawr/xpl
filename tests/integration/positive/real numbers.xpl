fn average(real a, real b) -> real
  (a + b) / 2
end

fn square(real x) -> real
  x * x
end

fn abs(real x) -> real
  if(x >= 0.0) x else -x end
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
