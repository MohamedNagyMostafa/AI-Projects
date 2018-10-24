function p = neuralPredict(Theta1, Theta2, X)
 X = [ones(size(X,1),1) X]
 z2 = X * Theta1'
 a2 = [ones(size(z2,1),1) logistic(z2)]
 z3 = a2 * Theta2'
 a3 = logistic(z3)
 [predict, p] = max(a3, [], 2)
 p = mod(p,10)
endfunction
