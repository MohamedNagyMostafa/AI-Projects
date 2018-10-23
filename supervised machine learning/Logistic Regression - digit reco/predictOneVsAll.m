function p = predictOneVsAll(theta, X)
  
   X =[0 X] 
  [a, p] = max(logistic(X*theta'),[],2)
endfunction
