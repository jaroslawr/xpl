method fibonacci(int x)
  if x == 0
    return 0
  end
  if x == 1
    return 1
  end
  fibonacci(x-1) + fibonacci(x-2)
end

int n = 1
while n <= 10
  print(fibonacci(n))
  int n = n + 1
end
