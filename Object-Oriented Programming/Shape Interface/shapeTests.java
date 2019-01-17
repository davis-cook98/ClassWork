package shape;

import static org.junit.Assert.*;

import org.junit.Test;

public class shapeTests 
{
	@Test
	public void squaretest() 
	{
		Square s = new Square(4);
		assertEquals(s.getx().intValue(), 4);
		assertEquals(s.getOtherField().intValue(), 4);
		assertEquals(s.getArea().doubleValue(), 16.0, 0.1);
		assertEquals(s.getPerimeter().doubleValue(), 16.0, 0.1);
		assertEquals(s.isQuadrilateral(), true);
		assertEquals(s.isTriangle(), false);
		assertEquals(s.isCircle(), false);
	}
	
	@Test
	public void rectangletest() 
	{
		Rectangle r = new Rectangle(3, 5);
		assertEquals(r.getx().intValue(), 3);
		assertEquals(r.getOtherField().intValue(), 5);
		assertEquals(r.getArea().doubleValue(), 15.0, 0.1);
		assertEquals(r.getPerimeter().doubleValue(), 16.0, 0.1);
		assertEquals(r.isQuadrilateral(), true);
		assertEquals(r.isTriangle(), false);
		assertEquals(r.isCircle(), false);
	}

	@Test
	public void rhombustest() 
	{
		Rhombus r = new Rhombus(4, 3);
		Rhombus r1 = new Rhombus(4, 6);
		assertEquals(r.getx().intValue(), 4);
		assertEquals(r.getOtherField().intValue(), 3);
		assertEquals(r.getArea().doubleValue(), 12.0, 0.1);
		assertEquals(r.getPerimeter().doubleValue(), 16.0, 0.1);
		assertEquals(r.isQuadrilateral(), true);
		assertEquals(r.isTriangle(), false);
		assertEquals(r.isCircle(), false);
		assertEquals(r.isRhombus(), true);
		assertEquals(r1.isRhombus(), false);
	}
	
	@Test
	public void equilateraltest() 
	{
		Equilateral e = new Equilateral(4, 5);
		assertEquals(e.getx().intValue(), 4);
		assertEquals(e.getOtherField().intValue(), 5);
		assertEquals(e.getSide2().intValue(), 4);
		assertEquals(e.getSide3().intValue(), 4);
		assertEquals(e.getArea().doubleValue(), 10.0, 0.1);
		assertEquals(e.getPerimeter().doubleValue(), 12.0, 0.1);
		assertEquals(e.isQuadrilateral(), false);
		assertEquals(e.isTriangle(), true);
		assertEquals(e.isCircle(), false);
	}
	
	@Test
	public void isoscelestest() 
	{
		Isosceles i = new Isosceles(4, 6, 7);
		assertEquals(i.getx().intValue(), 4);
		assertEquals(i.getOtherField().intValue(), 7);
		assertEquals(i.getSide2().intValue(), 6);
		assertEquals(i.getSide3().intValue(), 6);
		assertEquals(i.getArea().doubleValue(), 14.0, 0.1);
		assertEquals(i.getPerimeter().doubleValue(), 16.0, 0.1);
		assertEquals(i.isQuadrilateral(), false);
		assertEquals(i.isTriangle(), true);
		assertEquals(i.isCircle(), false);
	}
	
	@Test
	public void scalenetest() 
	{
		Scalene s = new Scalene(4, 5, 6, 3);
		assertEquals(s.getx().intValue(), 4);
		assertEquals(s.getOtherField().intValue(), 3);
		assertEquals(s.getSide2().intValue(), 5);
		assertEquals(s.getSide3().intValue(), 6);
		assertEquals(s.getArea().doubleValue(), 6.0, 0.1);
		assertEquals(s.getPerimeter().doubleValue(), 15.0, 0.1);
		assertEquals(s.isQuadrilateral(), false);
		assertEquals(s.isTriangle(), true);
		assertEquals(s.isCircle(), false);
	}
	
	@Test
	public void circletest() 
	{
		Circle c = new Circle(2);
		assertEquals(c.getx().intValue(), 2);
		assertEquals(c.getArea().doubleValue(), 12.56, 0.1);
		assertEquals(c.getPerimeter().doubleValue(), 12.56, 0.1);
		assertEquals(c.isQuadrilateral(), false);
		assertEquals(c.isTriangle(), false);
		assertEquals(c.isCircle(), true);
	}
	
}
