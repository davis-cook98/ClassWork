package shape;

public class Circle extends AShape
{
	private static Double PI = 3.14;
	
	public Circle(Integer radius)
	{
		this.x = radius;
	}
	
	public Boolean isQuadrilateral()
	{
		return(false);
	}
	
	public Boolean isTriangle()
	{
		return(false);
	}
	
	public Boolean isCircle()
	{
		return(true);
	}
	
	public Double getPerimeter()
	{
		return (new Double (2 * PI * x));
	}
	
	public Double getArea()
	{
		return (new Double (PI * (x * x)));
	}
}
