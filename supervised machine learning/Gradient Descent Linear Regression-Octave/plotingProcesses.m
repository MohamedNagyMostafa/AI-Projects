function plotingProcesses(iteration, cost, X, y, estimatedXs, estimatedNorm, type)
  subplot(1, 3, 3)
  plotEstimatedGraph(X, y, estimatedNorm, 1)
  subplot(1, 3, 2)
  plotCostGraph(cost, iteration)  
  subplot(1, 3, 1)
  plotEstimatedGraph(X, y, estimatedXs, type)
  print -dpng 'CostFunctionPlot.png'
endfunction
