function plotData(X,y)
  pos = find(y==1);neg = find(y==0);
  
  plot(X(pos,1),X(pos,2),'k+','LineWidth',2)
  hold on;
  plot(X(neg,1),X(neg,2),'ko','MarkerFaceColor','y', 'MarkerSize',7)
  xlabel('Microchip Test 1')
ylabel('Microchip Test 2')
  title("Training set Visualization")
endfunction
