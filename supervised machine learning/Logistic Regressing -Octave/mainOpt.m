function mainOpt(x,y,theta,iteration, lambda, regularization, degree)
  [theta X r c] = mapFunction(theta, x, degree)
  % 0 : don't use regularization
  % 1 : by using regulaization
  %visualization
  [jVal, grad] = costFunctionOpt(theta,X,y, regularization, lambda)
  
  options = optimset('GradObj', 'on','MaxIter','100')
  [optTheta, funVal, exitFlag] = fminunc(@(t) costFunctionOpt(t,X,y, regularization, lambda),theta, options)
  
  h0 = hypothese(optTheta, X, r)
  
  subplot(1,3,2)
  plotDecisionLine(x,y,optTheta)
  subplot(1,3,1)
  plotData(x,y)
  subplot(1,3,3)
  plotEstimatedData(x,h0)
  
endfunction
