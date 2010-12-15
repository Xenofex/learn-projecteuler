h = {}

2.upto(100) do |a|
  2.upto(100) do |b|
    r = a**b
    v = a.to_s + "^" + b.to_s
    if h.has_key?(r)
      puts "#{h[r]} == #{a}^#{b}"
    else
      h[r] = v
    end
  end
end
