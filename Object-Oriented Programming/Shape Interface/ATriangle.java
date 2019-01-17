package shape;

public abstract class ATriangle extends AShape implements Triangle
{
	protected Integer other, side2, side3;
	
	public ATriangle(Integer base, Integer s2, Integer s3, Integer height)
	{
		this.x = base;
		this.side2 = s2;
		this.side3 = s3;
		this.other = height;
	}
	
	public Boolean isQuadrilateral()
	{
		return(false);
	}
	
	public Boolean isTriangle()
	{
		return(true);
	}
	
	public Boolean isCircle()
	{
		return(false);
	}
	
	public Integer getOtherField()
	{
		return(this.other);
	}
	
	public Integer getSide2()
	{
		return(this.side2);
	}
	
	public Integer getSide3()
	{
		return(this.side3);
	}

	public Double getPerimeter()
	{
		return (new Double (x + side2 + side3));
	}
	
	public Double getArea()
	{
		return (new Double ((x * other)/2));
	}
}
