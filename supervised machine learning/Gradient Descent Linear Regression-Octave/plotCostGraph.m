function plotCostGraph(cost, iteration)
  xAxis = 1:iteration+1
  plot(xAxis, cost, '-')
  axis([0 iteration min(cost)-5 max(cost)+5])
  xlabel('Iteration Times')
  ylabel('Cost Function (Error)')
  legend('Cost Function Result')
  title('Error Rate')
endfunction
