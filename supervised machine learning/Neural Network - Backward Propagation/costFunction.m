function [J grad] = costFunction(inputLayers, hiddenLayers, outputLayers, Theta, lambda, num_labels, X, y)
  
  [r c] = size(X);
  num_examples = r;
  
  %Reshape Thetas ...
  Theta1 = reshape(Theta(1:hiddenLayers *(inputLayers+1)), hiddenLayers, inputLayers + 1);
  Theta2 = reshape(Theta(((inputLayers+1) *hiddenLayers)+1:end), outputLayers, hiddenLayers + 1);
  
  %OneVsAll Tech ...
  I = eye(num_labels);
  Y = zeros(num_examples, num_labels);
  Y(:,:) = I(y(:),:);

  %Feed Forward ...
  a1 = [ones(r,1) X];
  z2 = a1 * Theta1';
  a2 = [ones(size(z2,1),1) sigmoid(z2)];
  z3 = a2 * Theta2';
  a3 = sigmoid(z3);
  
  %Determine The Cost ...
  p = (lambda./2.0) .* sum([Theta1(:,2:end)(:);Theta2(:,2:end)(:)].^2);
  J = (-sum(sum(Y .* log(a3) + (1-Y) .* log(1-a3),2),1)+ p)./num_examples;
  
  
endfunction
