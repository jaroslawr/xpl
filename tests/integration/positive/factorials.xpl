fn factorial(int n) -> int
  int result = n
  int iter   = n - 1
  while iter > 1
    result = result * iter
    iter   = iter - 1
  end
  result
end

puts("Factorials")
puts("-------------------------------")

int n = 1
while n < 10
  puts("factorial(" + n + "): " + factorial(n))
  n = n + 1
end
