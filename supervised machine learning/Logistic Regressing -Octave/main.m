function main(x,y,theta,alpha, iteration)
  [r c] = size(x)
  %visualization
  plotData(x,y)
  theta = ones(c+1,1)*theta
  h0 = hypothese(theta, x, r)
  cost = []
  for i=1:iteration
    theta = gradient(theta, alpha, h0,x,y,r)
    h0 = hypothese(theta, x, r)
    cost = [cost;costFunction(c,h0,y)]
  endfor
  plotEstimatedData(x,h0)
endfunction
