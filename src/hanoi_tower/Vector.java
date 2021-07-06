package hanoi_tower;
/**
 * Explanation yet to be explain
 * @author devler420
 *
 */
public class Vector //Class named "Vector"
{
	public double x,y; //included double x,y variables
	
	public Vector add(Vector v) //Add Method
	{
		Vector result = new Vector();
		result.x = x + v.x;
		result.y = y + v.y;
		return result;
	}
	
	public Vector sub(Vector v)
	{
		Vector result = new Vector();
		result.x = x - v.x;
		result.y = y - v.y;
		return result;
	}
	
	public Vector mul(double m)
	{
		Vector result = new Vector();
		result.x = x*m;
		result.y = y*m;
		return result;
	}
	
	public double dot(Vector v) //double because output is "Scalar" scalar in computer is "double"
	{
		double result = x * v.x + y * v.y; //no need to new obj. because "double" is primative type (Tum-ma-da)
		return result;
	}
	
	public double size() //no need input because it will find size of our subject's vector
	{
		double result = Math.sqrt(x*x + y*y); //pythagorus
		return result;
	}
	
	public Vector unit()
	{
		double s = size();
		Vector result = new Vector();
		result.x = x/s;
		result.y = y/s;
		return result;
	}
	
}
