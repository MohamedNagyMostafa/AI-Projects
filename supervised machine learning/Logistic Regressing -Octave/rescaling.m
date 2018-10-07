function X = rescaling(X, c, r)
  for i=1:c
    maxVal = max(X(:,i))
    minVal = min(X(:,i))
    X(:,i) = (X(:,i)-minVal)/(maxVal - minVal)
  endfor
endfunction
