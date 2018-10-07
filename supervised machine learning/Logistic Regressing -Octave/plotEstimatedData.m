function plotEstimatedData(X,y)
  pos = find(y>= 0.5);neg = find(y <0.5);
 
  plot(X(pos,1),X(pos,2),'k+','LineWidth',2)
  hold on;
  plot(X(neg,1),X(neg,2),'ko','MarkerFaceColor','y', 'MarkerSize',7)
  xlabel('Microchip Test 1')
ylabel('Microchip Test 2')
  title("Estimated data Visualization")
endfunction
