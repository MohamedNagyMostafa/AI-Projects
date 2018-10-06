function h0 = hypothese(theta, x, r)
  x = [ones(r,1) x]
  z = x * theta
  h0 = 1./(1+exp(-z))
endfunction
