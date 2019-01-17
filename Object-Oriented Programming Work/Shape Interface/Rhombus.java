package shape;

public class Rhombus extends AQuadrilateral
{
	public Rhombus(Integer side, Integer height)
	{
		super(side, height);
	}
	
	public Boolean isRhombus()
	{
		if(this.other > this.x)
		{
			return(false);
		}
		else
		{
			return(true);
		}
	}
	
	public Double getPerimeter()
	{
		return(double)(4 * x);
	}
}
