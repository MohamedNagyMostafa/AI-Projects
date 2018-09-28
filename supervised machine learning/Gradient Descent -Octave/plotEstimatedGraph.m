function plotEstimatedGraph(x, y, estimatedX, t)
  plot(x,y,'rx', 'MarkerSize', 10)
  hold on
  plot(x, estimatedX, 'b')
  title(t)
  xlabel('Population')
  ylabel('Profit')
  legend('Traning Set', 'Estimated Fit Line')
  
endfunction
