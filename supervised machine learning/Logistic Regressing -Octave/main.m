function main(x,y,theta,alpha, iteration)
  [r c] = size(x)
  %visualization
  
  theta = ones(c+1,1)*theta
  h0 = hypothese(theta, x, r)
  cost = []
  for i=1:iteration
    theta = gradient(theta, alpha, h0,x,y,r)
    h0 = hypothese(theta, x, r)
    cost = [cost;costFunction(c,h0,y)]
  endfor
  
  subplot(1,3,2)
  plotCostFunction(cost,iteration)
  subplot(1,3,1)
  plotData(x,y)
  subplot(1,3,3)
  plotEstimatedData(x,h0)
  
endfunction
