function plotingProcesses(iteration, cost, X, y, estimatedXs)
  subplot(1, 2, 2)
  plotCostGraph(cost, iteration)  
  subplot(1, 2, 1)
  plotEstimatedGraph(X, y, estimatedXs)
  print -dpng 'CostFunctionPlot.png'
endfunction
