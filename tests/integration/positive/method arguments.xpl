fn times(int n, string what) -> string
  int    x      = n
  string result = ""

  while x > 0
    result = result + what
    x = x -1
  end

  result
end

print(times(5,"hello "))
