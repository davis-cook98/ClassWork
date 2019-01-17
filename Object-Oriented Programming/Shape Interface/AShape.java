package shape;

public abstract class AShape implements Shape
{
	protected Integer x;
	
	public Integer getx()
	{
		return(this.x);
	}
	
	public abstract Double getPerimeter();
	
	public abstract Double getArea();
	
	public abstract Boolean isQuadrilateral();
	
	public abstract Boolean isTriangle();
	
	public abstract Boolean isCircle();
}
