function estimatedX = normalizaion(features, y)
  [r c] = size(features)
  X = [ones(r,1) features]
  theta = pinv(X'*X) * X' *y
  estimatedX = hypothese(theta, features)
endfunction
