function plotEstimatedGraph(x, y, estimatedX, type)
  plot(x,y,'rx', 'MarkerSize', 10)
  hold on
  
  switch type
    case 1
      plot(x, estimatedX, 'b')
      title('Normalization Graph')
    case 2
      plot(x, estimatedX, 'b')
      title('Estimated Graph')
    case 3
      plot(x, estimatedX, "ok")
      title('Estimated Polynomial Regression Graph')
  endswitch
      
  xlabel('Population')
  ylabel('Profit')
  legend('Traning Set', 'Estimated Fit Line')
  
endfunction
