function cost = costFunction(estimatedX, y)
  cost = (1/(2*length(y)))*sum((estimatedX - y).^2) 
endfunction
