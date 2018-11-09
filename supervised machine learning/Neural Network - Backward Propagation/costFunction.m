function [J grad] = costFunction(inputLayers, hiddenLayers, outputLayers, Theta, X, y)
  
  [r c] = size(X);
  num_labels = size(y);
  num_examples = r;
  
  %Reshape Thetas ...
  Theta1 = reshape(Theta(1:hiddenLayers *(inputLayers+1)), hiddenLayers, inputLayers + 1));
  Theta2 = reshape(Theta((inputLayers.*(hiddenLayers+1))+1:end, outputLayers, hiddenLayers + 1));
  
  %OneVsAll Tech ...
  Y = zeros(num_examples, num_labels);
  for e = 1:num_examples
    Y(e, y) = 1;
  endfor
  
  %Feed Forward ...
  a1 = [ones(r,1) X];
  z2 = X * Theta1';
  a2 = [ones(size(z2,1),1) sigmoid(z2)];
  z3 = z2 * Theta2';
  a3 = sigmoid(z3);
  
  
  
endfunction
