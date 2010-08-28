def circle(n)
  if n == 1
    return 1, 1
  else
    sum, last = circle(n - 1)
    sum += last * 4 + (n - 1) * 2 * 10
    return sum, last + (n - 1) * 2 * 4
  end
end

puts circle(501)[0]
