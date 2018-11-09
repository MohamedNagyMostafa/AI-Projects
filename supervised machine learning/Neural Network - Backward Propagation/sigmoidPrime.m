function p = sigmoidPrime(z)
  a = sigmoid(z);
  p = a .* (1-a);
endfunction
