function newThetas = gradient(thetas, rate, estimatedX, y, features)
  [r,c] = size(features)
  featuresAdd = [ones(r,1) features]
  newThetas = thetas - (rate*(1/length(y))* (sum((estimatedX-y).*featuresAdd)))'
endfunction
