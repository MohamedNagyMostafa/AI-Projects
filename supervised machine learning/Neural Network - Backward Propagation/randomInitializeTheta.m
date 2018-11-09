function Theta = randomInitializeTheta(input_layer_size, output_layer_size)
  init_epsilon = sqrt(6)./sqrt(input_layer_size + output_layer_size);
  Theta = rand(input_layer_size, output_layer_size +1) * (2 *init_epsilon) - init_epsilon;
endfunction
