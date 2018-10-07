function [theta, X, r, c] = mapFunction(theta, X, degree)
  [r c] = size(X)
  for i=2:degree
    for j=1:c
      X = [X X(:,j).^i]
    endfor
  endfor
  [r c] = size(X)
  theta = ones(c+1,1)*theta
  X = rescaling(X,c,r)
endfunction
