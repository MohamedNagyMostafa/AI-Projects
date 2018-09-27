function plotCostGraph(cost, iteration)
  xAxis = 1:iteration+1
  plot(xAxis, cost)
  xlabel('Iteration Times')
  ylabel('Cost Function (Error)')
  legend('Cost Function Result')
  title('Error Rate')
  %saving ..
  %print -dpng 'CostFunctionPlot.png'
  
endfunction
