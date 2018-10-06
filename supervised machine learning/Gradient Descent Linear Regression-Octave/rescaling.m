function [X, y] = rescaling(features, result, c1, c2)
  X=[]
  for i=1:c1
    X=[X (features(:,i)-min(features(:,i)))/(max(features(:,i))-min(features(:,i)))]
  endfor
  y = (result(:,1)-min(result(:,1)))/(max(result(:,1))-min(result(:,1)))
endfunction
