function j = costFunction(m,h0,y)
  j = 1/m *(-y'*log(h0)-(1-y)'*log(1-h0))
endfunction
