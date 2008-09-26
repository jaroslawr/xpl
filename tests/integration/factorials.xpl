method factorial(n)
  result = n
  iter   = n - 1
  while iter > 1
    result = result * iter
    iter   = iter - 1
  end
  result
end

n = 1
while n <= 10
  print(factorial(n))
  n = n + 1
end
