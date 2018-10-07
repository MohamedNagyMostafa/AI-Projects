function main(x,y,theta,alpha, iteration, lambda, regularization, degree)
  [theta X r c] = mapFunction(theta, x, degree)
  % 0 : don't use regularization
  % 1 : by using regulaization
  %visualization
  
  h0 = hypothese(theta, X, r)
  cost = []
  for i=1:iteration
    theta = gradient(theta, alpha, h0,X,y,r, regularization, lambda)
    h0 = hypothese(theta, X, r)
    cost = [cost;costFunction(c,h0,y, regularization, lambda, theta)]
  endfor
  
  subplot(1,3,2)
  plotCostFunction(cost,iteration)
  subplot(1,3,1)
  plotData(x,y)
  subplot(1,3,3)
  plotEstimatedData(x,h0)
  
endfunction
