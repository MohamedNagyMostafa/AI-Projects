function [J grad] = costFunction(theta, X, y, lambda)
  [m n] = size(X)
  X = [ones(m,1) X]
  h0 = logistic(X * theta)
  
  J = ((-y'*log(h0)) - ((1-y)'*log(1-h0)))./m + (lambda*sum(theta(2:end).^2))./(2*m)

  grad = 1.0 ./ m *((h0-y)' * X)
  grad(2:end) = grad(2:end) + ((lambda./m) *theta(2:end))'
  grad = grad'
endfunction
