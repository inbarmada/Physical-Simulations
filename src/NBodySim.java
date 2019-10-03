import java.awt.*;
import java.applet.*;
import java.awt.event.*;


public class NBodySim extends Applet implements MouseListener, MouseMotionListener{
	public int N = 1000;
	public NBody bodies[]= new NBody[N];
	public boolean shouldrun=false;
	public NBody one, two, three, four;
	int count = 100;
//	public static void main(String[] args) {
//		Body one = new Body(5e18, 0, 0, 0, 0);
//		Body two = new Body(2e20, 200000, 200000, 0, 0);
//		System.out.println("start");
//		System.out.println(one);
//		System.out.println(two);
//		for(int i = 0; i < 1000000000; i++) {
//			one.addForce(two);
//			two.addForce(one);
//			
//			one.update(100);
//			two.update(100);
//			
//			System.out.println("one: " + one);
//			System.out.println("two: " + two);
//		}
//	}
	public void init() {
		addMouseListener(this);
	    addMouseMotionListener(this);
		one = new NBody(2e19, 100, 0, 0, 0, Color.RED);
		two = new NBody(2e13, 300, 100, -200, 400, Color.BLUE);
		three = new NBody(2e11, -100, 100, 1000, 2000, Color.PINK);
		four = new NBody(2e14, 300, 100, -500, 1000, Color.GREEN);
	}
	
	public void paint(Graphics g) {
		
		System.out.println(count);
		if(count++ > 100) {
//			for(int i=0; i<N; i++) {
//		        g.setColor(bodies[i].c);
//		        g.fillOval((int) Math.round(bodies[i].xPos*250/1e18),(int) Math.round(bodies[i].yPos*250/1e18),8,8);
//		      }
			one.setLoc(x,y);
			g.setColor(one.c);
			g.fillOval((int)Math.round(one.xPos), (int)Math.round(one.yPos), 8, 8);
			g.setColor(two.c);
			g.fillOval((int)Math.round(two.xPos), (int)Math.round(two.yPos), 8, 8);
			g.setColor(three.c);
			g.fillOval((int)Math.round(three.xPos), (int)Math.round(three.yPos), 8, 8);
			g.setColor(four.c);
			g.fillOval((int)Math.round(four.xPos), (int)Math.round(four.yPos), 8, 8);
		    //go through the Brute Force algorithm (see the function below)
		    addForces();
		    //go through the same process again until applet is stopped
		    repaint();
		}
	}
	
	public void addForces() {
		one.addForce(two);
		one.addForce(three);
		one.addForce(four);
		two.addForce(one);
		two.addForce(three);
		two.addForce(four);
		three.addForce(one);
		three.addForce(two);
		three.addForce(four);
		four.addForce(one);
		four.addForce(two);
		four.addForce(three);
		
		one.update(5e-5);
		two.update(5e-5);
		three.update(5e-5);
		four.update(5e-5);
		
		one.resetForce();
		two.resetForce();
		three.resetForce();
		four.resetForce();
	}
	
	
	  int x, y;
	  String str="";
	                                    // override ML 5 abstract methods
	  public void mousePressed(MouseEvent e)
	  {
	    x = e.getX();
	    y = e.getY();
	    str = "Mouse Pressed";
	    repaint();
	  }
	  public void mouseReleased(MouseEvent e)
	  {
	    x = e.getX();
	    y = e.getY();
	    str = "Mouse Released";
	    repaint();
	   }
	   public void mouseClicked(MouseEvent e)
	   {
	     x = e.getX();
	     y = e.getY();
	     str = "Mouse Clicked";
	     repaint();
	   }
	   public void mouseEntered(MouseEvent e)
	   {
	     x = e.getX();
	     y = e.getY();
	     str = "Mouse Entered";
	     repaint();
	   }
	   public void mouseExited(MouseEvent e)
	   {
	     x = e.getX();
	     y = e.getY();
	     str = "Mouse Exited";
	     repaint();
	   }
	                                    // override two abstract methods of MouseMotionListener
	   public void mouseMoved(MouseEvent e)
	   {
	     x = e.getX();
	     y = e.getY();
	     str = "Mouse Moved";
	     repaint();
	   }
	   public void mouseDragged(MouseEvent e)
	   {
	     x = e.getX();
	     y = e.getY();
	     str = "Mouse dragged";
	     repaint();
	   }
	
	
}