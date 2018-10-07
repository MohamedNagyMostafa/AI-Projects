function newTheta = gradient(theta, alpha, h0, x, y, r, regulaization, lambda)
  m = length(y)
  x = [ones(r,1) x]
  dj = 1/m * x'*(h0-y)
  
  if(regulaization == 1)
    dj(2:end) = dj(2:end) + (lambda/m)*sum(theta(2:end))
  endif
  newTheta = theta - alpha * dj
endfunction
