function [J grad] = costFunction(inputLayers, hiddenLayers, outputLayers, Theta, lambda, X, y)
  
  [r c] = size(X);
  num_examples = r;
  num_labels = outputLayers;
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
  
  %Feed Backward ...
  deltas_3 = (a3 - Y)';
  deltas_2 = (deltas_3' * Theta2(:,2:end) .* sigmoidPrime(z2))';
  
  delta_2 = deltas_3 * a2;
  delta_1 = deltas_2 * a1;
  
  D_1 = zeros(size(Theta1));
  D_2 = zeros(size(Theta2));
  
  %Determine Bias Units ...
  %As the backward propagation will be repeated for one time
  %and the initial delta is 0 then the first equation of 
  
  D_1(:,2:end) =  (delta_1(:,2:end) + lambda .* Theta1(:,2:end))./num_examples;
  D_2(:,2:end) =  (delta_2(:,2:end) + lambda .* Theta2(:,2:end))./num_examples;
  D_1(:,1) = delta_1(:,1)./num_examples;
  D_2(:,1) = delta_2(:,1)./num_examples;
  
  grad = [D_1(:);D_2(:)];
  
endfunction
