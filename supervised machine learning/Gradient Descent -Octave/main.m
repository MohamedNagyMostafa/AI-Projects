function main(features, y, theta, traningRate, iteration)
  [r c] = size(features)
  theta = ones(c + 1,1)*theta
  estimatedX = hypothese(theta,features)
  cost = costFunction(estimatedX, y)
  
  for i=1:iteration
    theta = gradient(theta, traningRate, estimatedX,y,features)
    estimatedX = hypothese(theta,features)
    cost = [cost ;costFunction(estimatedX, y)]
  endfor
  
  plotCostGraph(cost, iteration)
  plotEstimatedGraph(features, y, estimatedX)
endfunction
