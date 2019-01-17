package shape;

public abstract class AQuadrilateral extends AShape
{
	protected Integer other;
	
	public AQuadrilateral(Integer side1, Integer side2)
	{
		this.x = side1;
		this.other = side2;
	}
	
	public Boolean isQuadrilateral()
	{
		return(true);
	}
	
	public Boolean isTriangle()
	{
		return(false);
	}
	
	public Boolean isCircle()
	{
		return(false);
	}
	
	public Integer getOtherField()
	{
		return(this.other);
	}
	
	public Double getPerimeter()
	{
		return (new Double (2 * x + 2 * other));
	}
	
	public Double getArea()
	{
		return (new Double (x * other));
	}
}
