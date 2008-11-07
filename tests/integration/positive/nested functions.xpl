fn accumulate(int start, int finish) -> int
  fn accumulate_rec(int start, int finish, int acc) -> int
    if start == finish
      return acc + finish
   else
      accumulate_rec(start + 1, finish, acc + start)
    end
  end

  accumulate_rec(start, finish, 0)
end

print(accumulate(10, 20))
