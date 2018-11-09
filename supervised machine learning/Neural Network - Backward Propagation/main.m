function [Thetas, cost] = main(X, y, lambda)
  
  %Build Nueral Model.
  input_layer_size = 400;
  hidden_layer_size = 25;
  output_layer_size = 10;
  
  %Initial Weights ....
  Theta1 = randomInitializeTheta(hidden_layer_size, input_layer_size);
  Theta2 = randomInitializeTheta(output_layer_size, hidden_layer_size);
  initial_thetas = [Theta1(:);Theta2(:)];

  
  %Identify Cost Function ....
  cost_function = @(p) costFunction(
                                    input_layer_size,
                                    hidden_layer_size, 
                                    output_layer_size,
                                    p, 
                                    lambda,
                                    X,
                                    y);
                                    
  options = optimset('MaxIter', 50);
   
                                   
  [Thetas, cost] = fmincg(cost_function, initial_thetas, options);

endfunction
