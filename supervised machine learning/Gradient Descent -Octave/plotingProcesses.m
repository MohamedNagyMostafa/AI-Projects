function plotingProcesses(iteration, cost, X, Y, estimatedXs)
  colWindow = 3
  rowWindow = 0
  
  if iteraion < 3
    colWindow = 2
  endif
  
  if iteraion % 3 == 0
    rowWindow = (iteraion/3) + 1
  else
    rowWindow = ceil(iteraion/3)
  endif
  for i=1:length(X)
    
  endfor
  subplot(rowWindow, colWindow)  
   
  plotCostGraph(iteration, cost)
endfunction
