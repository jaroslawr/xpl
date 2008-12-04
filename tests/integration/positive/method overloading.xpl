fn add(int x, int y) -> int
  x + y
end

fn add(string x, string y) -> string
  x + y
end

fn add(string str, int x, int y) -> string
  str + (x + y)
end

print(add(10, 15))
print(add("Foo", " Bar"))
print(add("Two plus two is ", 2, 2))
