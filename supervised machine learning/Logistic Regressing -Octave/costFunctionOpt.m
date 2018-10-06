function [jVal, grad] = costFunctionOpt(theta,x,y)
  m = length(y)
  h0 = hypothese(theta,x,m)
  jVal = 1/m *(-y'*log(h0)-(1-y)'*log(1-h0))
  grad = 1/m * [ones(m,1) x]'*(h0-y)
endfunction
