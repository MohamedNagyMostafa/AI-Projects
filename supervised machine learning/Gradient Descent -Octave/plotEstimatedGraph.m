function plotEstimatedGraph(x, y, estimatedX, t)
  xAxis = [min(x)-5 max(x)+5]
  yAxis = [min([y;estimatedX])-5 max([y;estimatedX])+5]
  plot(x,y,'rx', 'MarkerSize', 10)
  hold on
  plot(x, estimatedX, 'b')
  axis([xAxis yAxis])
  title(t)
  xlabel('Population')
  ylabel('Profit')
  legend('Traning Set', 'Estimated Fit Line')
  
endfunction
