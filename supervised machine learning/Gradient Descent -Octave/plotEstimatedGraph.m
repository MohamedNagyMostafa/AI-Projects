function plotEstimatedGraph(x, y, estimatedX)
  figure(2)
  xAxis = [min(x)-5 max(x)+5]
  yAxis = [min([y;estimatedX])-5 max([y;estimatedX])+5]
  plot(x,y,'o')
  hold on
  plot(x, estimatedX, 'r')
  axis([xAxis yAxis])
  title('Estimated Graph')
  xlabel('X')
  ylabel('Y')
  legend('Traning Set', 'Estimated Fit Line')
  
endfunction
