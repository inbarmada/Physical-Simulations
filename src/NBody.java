import java.awt.Color;

public class NBody {
	private static final double G = 6.673e-11;   // gravitational constant
	double mass;
	double xPos, yPos; //Position
	double vx, vy; //Velocity
	double fx, fy; //Force
	Color c;
	
	public NBody(double m, double x, double y, double xVel, double yVel, Color color) {
		mass = m;
		xPos = x;
		yPos = y;
		vx = xVel;
		vy = yVel;
		fx = fy = 0;
		c = color;
	}
	
	public void setLoc(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	public void update(double dt) {
		vx += fx/mass * dt;
		vy += fy/mass * dt;
		xPos += vx * dt;
		yPos += vy * dt;
		if(xPos > 750)
			xPos = 750;
		if(xPos < 0)
			xPos = 0;
		if(yPos > 500)
			yPos = 500;
		if(yPos < 0)
			yPos = 0;
	}
	
	public double distSquared(NBody other){
		double xDist = other.xPos - xPos;
		double yDist = other.yPos - yPos;
		return xDist*xDist + yDist*yDist;
	}
	
	public void addForce(NBody other) {
		double dist2 = distSquared(other);
		double forceMag = G*mass*other.mass/dist2;
		double dist = Math.sqrt(dist2) + 1e-6;
		fx += forceMag*(other.xPos - xPos)/dist;
		fy += forceMag*(other.yPos - yPos)/dist;
	}
	
	public void resetForce() {
		fx = fy = 0;
	}
	
	public String toString() {
		String data = "x: " + xPos + " y: " + yPos + 
				" vx: " + vx + " vy: " + vy + 
				" fx: " + fx + " fy: " + fy;
		return data;
	}
}
