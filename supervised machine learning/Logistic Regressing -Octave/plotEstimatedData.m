function plotEstimatedData(X,y)
  pos = find(y>= 0.5);neg = find(y <0.5);
 
  plot(X(pos,1),X(pos,2),'k+','LineWidth',2)
  hold on;
  plot(X(neg,1),X(neg,2),'ko','MarkerFaceColor','y', 'MarkerSize',7)
  xlabel('Exam 1 score')
  ylabel('Exam 2 score')
  title("Estimated data Visualization")
endfunction
