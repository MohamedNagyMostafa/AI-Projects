function thetas = trainingOneVsAll(X, y, lambda)
  num_labels = 10;
  [m n] = size(X);
  options = optimset('GradObj', 'on', 'MaxIter', 10);

  for c = 1:num_labels
    theta_initial = zeros(n+1, 1);
    [theta] = fmincg(@(t) (costFunction(t, X, (y==c), lambda)),theta_initial, options)
    thetas(c, :) = theta';
    pause;
  endfor
  
endfunction
