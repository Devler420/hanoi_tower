package hanoi_tower;

public class StepMove
{
	public int start;
	public int dest;
	public StepMove(int start , int dest)
	{
		this.start = start;
		this.dest = dest;
	}
	
	public String toString()
	{
		return ">>>> " + start + "--------> " + dest;
	}
}
