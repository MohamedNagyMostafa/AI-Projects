function thetas = main(X, y, lambda, num)
  thetas = trainingOneVsAll(X,y,lambda)
  
  drawDigit(X, num)
  p = predictOneVsAll(X, thetas)
  print(p)
endfunction
