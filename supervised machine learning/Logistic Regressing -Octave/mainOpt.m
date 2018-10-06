function mainOpt(x,y,theta,iteration)
  [r c] = size(x)
  theta = ones(c+1,1)*theta
  %visualization
  [jVal, grad] = costFunctionOpt(theta,x,y)
  
  options = optimset('GradObj', 'on','MaxIter','100')
  [optTheta, funVal, exitFlag] = fminunc(@(t) costFunctionOpt(t,x,y), theta, options)
  
  h0 = hypothese(optTheta, x, r)
  
  subplot(1,3,2)
  plotDecisionLine(x,y,optTheta)
  subplot(1,3,1)
  plotData(x,y)
  subplot(1,3,3)
  plotEstimatedData(x,h0)
  
endfunction
