function thetas = trainingOneVsAll(X, y, lambda)
  num_labesl = 10;
  [m n] = size(X);
  
  for c = 1:num_labels
    theta = zeros(n+1, 1);
    options = optimset('GradObj', 'on', 'MaxIter', 10);
    [theta] = (fmincg(@(t) (costFunction(t, X, (y==c), lambda)),theta, options))
    thetas(c, :) = theta';
  endfor
endfunction
