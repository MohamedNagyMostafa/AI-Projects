function [jVal, grad] = costFunctionOpt(theta,x,y, regularization, lambda)
  m = length(y)
  h0 = hypothese(theta,x,m)
  grad = 1/m * [ones(m,1) x]'*(h0-y)
  switch(regularization)
    case 0
      jVal = 1/m *(-y'*log(h0)-(1-y)'*log(1-h0))
    case 1
      jVal = 1/m *(-y'*log(h0)-(1-y)'*log(1-h0)) + (lambda/m)*sum(theta(2:end))
      grad(2:end) = grad(2:end) + (lambda/m)*sum(theta(2:end))
  endswitch
endfunction
