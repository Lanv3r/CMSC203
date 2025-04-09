import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PropertyTestStudent {

	@Test
	void testDefaultConstructor() {
		Property p = new Property();
        assertEquals("", p.getPropertyName());
        assertEquals("", p.getCity());
        assertEquals(0.0, p.getRentAmount());
        assertEquals("", p.getOwner());
        
        Plot plot = p.getPlot();
        assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(1, plot.getWidth());
        assertEquals(1, plot.getDepth());		
	}

	@Test
	void testConstructorNoPlot() {
		Property p = new Property("House", "Rockville", 500.0, "Jack");
        assertEquals("House", p.getPropertyName());
        assertEquals("Rockville", p.getCity());
        assertEquals(500.0, p.getRentAmount());
        assertEquals("Jack", p.getOwner());
        
        Plot plot = p.getPlot();
        assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(1, plot.getWidth());
        assertEquals(1, plot.getDepth());	
	}

	@Test
	void testConstructorWithValues() {
		Property p = new Property("House", "Rockville", 500.0, "Jack", 1, 2, 3, 4);
        assertEquals("House", p.getPropertyName());
        assertEquals("Rockville", p.getCity());
        assertEquals(500.0, p.getRentAmount());
        assertEquals("Jack", p.getOwner());
        
        Plot plot = p.getPlot();
        assertEquals(1, plot.getX());
        assertEquals(2, plot.getY());
        assertEquals(3, plot.getWidth());
        assertEquals(4, plot.getDepth());	
	}

	@Test
	void testCopyConstructor() {
		Property other = new Property("House", "Rockville", 500.0, "Jack", 1, 2, 3, 4);
		Property copy = new Property(other);
		
		assertEquals(other.getPropertyName(), copy.getPropertyName());
        assertEquals(other.getCity(), copy.getCity());
        assertEquals(other.getRentAmount(), copy.getRentAmount());
        assertEquals(other.getOwner(), copy.getOwner());
        
        Plot otherPlot = other.getPlot();
        Plot copyPlot = copy.getPlot();
        assertEquals(otherPlot.getX(), copyPlot.getX());
        assertEquals(otherPlot.getY(), copyPlot.getY());
        assertEquals(otherPlot.getWidth(), copyPlot.getWidth());
        assertEquals(otherPlot.getDepth(), copyPlot.getDepth());
		
	}

	@Test
	void testToString() {
		Property p1 = new Property("House", "Rockville", 500.0, "Jack", 1, 2, 3, 4);
		assertEquals("House,Rockville,Jack,500.0", p1.toString());
		
		Property p2 = new Property("House", "Rockville", 500.0, "Jack");
		assertEquals("House,Rockville,Jack,500.0", p2.toString());
		
		Property p3 = new Property();
		assertEquals(",,,0.0", p3.toString());
	}

}
