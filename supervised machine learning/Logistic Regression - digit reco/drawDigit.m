function drawDigit(X,j)
  I = []
  
  for i = 0:19
    I(i+1,:) = X(j,1+(i*20):20*(i+1))
  end
  
  h = imagesc(I',[-1 1])
  
  axis image off
  
  drawnow;
endfunction
