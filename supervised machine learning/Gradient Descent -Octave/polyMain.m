function polyMain(features, y, theta, traningRate, iteration, degree) 
  [r c] = size(features)
  theta = ones(c*degree + 1,1)*theta
  [features, y] = rescaling(features, y, c, length(y))
  polyFeatures=[]
  for i=1:c
    for j=1:degree
      polyFeatures = [polyFeatures features(:,i).^j]
    endfor
  endfor
  estimatedX = hypothese(theta,polyFeatures)
  cost = costFunction(estimatedX, y)
  
  for i=1:iteration
    theta = gradient(theta, traningRate, estimatedX,y,polyFeatures)
    estimatedX = hypothese(theta,polyFeatures)
    cost = [cost ;costFunction(estimatedX, y)]
  endfor
  
  estimatedNormalization = normalization(features, y)
  plotingProcesses(iteration, cost, features, y, estimatedX, estimatedNormalization)
endfunction
