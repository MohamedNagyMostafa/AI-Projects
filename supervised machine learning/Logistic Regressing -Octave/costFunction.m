function j = costFunction(m,h0,y,regulaization, lambda, theta)
  if(regulaization == 0)
    j = 1/m *(-y'*log(h0)-(1-y)'*log(1-h0))
  else
    j = 1/m *(-y'*log(h0)-(1-y)'*log(1-h0)) + (lambda/m)* sum(theta(2:end))
  endif
endfunction
