function newTheta = gradient(theta, alpha, h0, x, y, r)
  m = length(y)
  x = [ones(r,1) x]
  dj = 1/m * x'*(h0-y)
  newTheta = theta - alpha * dj
endfunction
