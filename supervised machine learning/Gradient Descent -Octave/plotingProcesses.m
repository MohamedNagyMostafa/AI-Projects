function plotingProcesses(iteration, cost, X, y, estimatedXs, estimatedNorm)
  subplot(1, 3, 3)
  plotEstimatedGraph(X, y, estimatedNorm, 'Normalization Graph')
  subplot(1, 3, 2)
  plotCostGraph(cost, iteration)  
  subplot(1, 3, 1)
  plotEstimatedGraph(X, y, estimatedXs, 'Estimated By Iteration Graph')
  print -dpng 'CostFunctionPlot.png'
endfunction
