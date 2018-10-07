function drawing(x,y, theta, degree)
  minx1 =min(x(:,1));maxx1 =max(x(:,1))
  minx2 =min(x(:,1));maxx2 =max(x(:,1))
  minx1p =min(x(:,1).^2);maxx1p =max(x(:,1).^2)
  minx2p =min(x(:,1).^2);maxx2p =max(x(:,1).^2)
  [t X r c] = mapFunction(0.3, x, degree)
  line =[]
  for x2=min(x(:,2)):100
    for x1=min(x(:,1)):100
      x1s = (x1 - minx1)/(maxx1 -minx1)
      x2s = (x2 - minx2)/(maxx2 -minx2)
      x1sp = (x1.^2 - minx1p)/(maxx1p -minx1p)
      x2sp = (x2.^2 - minx2p)/(maxx2p -minx2p)
      h0 = theta(1) + theta(2)*x1s + theta(3)*x2s + theta(4)*x1sp + theta(5)*x2sp
      if(abs(h0) <=0.5)
        line =[line;x1 x2]
        break;
      endif
    endfor
  endfor
  pos = find(y==1);neg = find(y==0);
  
  plot(x(pos,1),x(pos,2),'k+','LineWidth',2)
  hold on;
  plot(x(neg,1),x(neg,2),'ko','MarkerFaceColor','y', 'MarkerSize',7)
  hold on;
  plot(line(:,1),line(:,2),'b','LineWidth',1)
  xlabel('Exam 1 score')
  ylabel('Exam 2 score')
  
endfunction
