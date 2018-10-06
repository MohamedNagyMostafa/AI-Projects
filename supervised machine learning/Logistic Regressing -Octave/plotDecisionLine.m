function plotDecisionLine(X,y,theta)
  plot_x = [min(X(:,2));max(X(:,2))]

  plot_y = (-1./theta(3)) * (theta(1) + theta(2)*plot_x)

  pos = find(y==1);neg = find(y==0);
  
  plot(X(pos,1),X(pos,2),'k+','LineWidth',2)
  hold on;
  plot(X(neg,1),X(neg,2),'ko','MarkerFaceColor','y', 'MarkerSize',7)
  hold on;
  plot(plot_x, plot_y)
  
  xlabel('Exam 1 score'); ylabel('Exam 2 score'); title("Decision Line")
endfunction
