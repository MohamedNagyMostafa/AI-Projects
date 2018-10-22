function p = predictOneVsAll(theta, X)
  [a, p] = max(logistic(X*theta'),[],2)
endfunction
