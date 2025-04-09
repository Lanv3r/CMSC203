import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.classfile.instruction.NewMultiArrayInstruction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {

	@Test
	void testDefaultConstructor() {
		Plot plot = new Plot();
        assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(1, plot.getWidth());
        assertEquals(1, plot.getDepth());	
	}

	@Test
	void testConstructorWithValues() {
		Plot plot = new Plot(1, 2, 2, 4);
        assertEquals(1, plot.getX());
        assertEquals(2, plot.getY());
        assertEquals(2, plot.getWidth());
        assertEquals(4, plot.getDepth());	
	}

	@Test
	void testCopyConstructor() {
		Plot other = new Plot(1, 2, 2, 4);
		Plot plot = new Plot(other);
        assertEquals(other.getX(), plot.getX());
        assertEquals(other.getY(), plot.getY());
        assertEquals(other.getWidth(), plot.getWidth());
        assertEquals(other.getDepth(), plot.getDepth());	
	}

	@Test
	void testOverlaps() {
		Plot p1 = new Plot(0, 0, 5, 5);
		
        Plot p2 = new Plot(3, 3, 4, 4); // Partial overlap
        assertTrue(p1.overlaps(p2)); 
        
        Plot p3 = new Plot(6, 0, 1, 1); // Completely to the right
        assertFalse(p1.overlaps(p3)); 
        
        Plot p4 = new Plot(5, 0, 1, 1); // Touches on the one side
        assertFalse(p1.overlaps(p4)); 
        
        Plot p5 = new Plot(0, 6, 1, 1); // Completely below
        assertFalse(p1.overlaps(p5)); 
        
        Plot p6 = new Plot(1, 1, 2, 2); // Encompasses
        assertTrue(p1.overlaps(p6)); 
	}

	@Test
	void testEncompasses() {
		Plot p1 = new Plot(0, 0, 5, 5);
		
        Plot p2 = new Plot(3, 3, 4, 4); // Partial overlap
        assertFalse(p1.encompasses(p2)); 
        
        Plot p3 = new Plot(6, 0, 1, 1); // Completely to the right
        assertFalse(p1.encompasses(p3)); 
        
        Plot p4 = new Plot(5, 0, 1, 1); // Touches on the one side
        assertFalse(p1.encompasses(p4)); 
        
        Plot p5 = new Plot(0, 6, 1, 1); // Completely below
        assertFalse(p1.encompasses(p5)); 
        
        Plot p6 = new Plot(1, 1, 2, 2); // Encompasses
        assertTrue(p1.encompasses(p6));
        
        Plot p7 = new Plot(2, 2, 2, 2); // Encompasses
        assertTrue(p1.encompasses(p7));
	}

	@Test
	void testToString() {
		Plot p1 = new Plot(0, 0, 5, 5);
		assertEquals("0,0,5,5", p1.toString());
		
        Plot p2 = new Plot(3, 3, 4, 4); 
        assertEquals("3,3,4,4", p2.toString());
        
        Plot p3 = new Plot(6, 0, 1, 1); 
        assertEquals("6,0,1,1", p3.toString()); 
        
        Plot p4 = new Plot(5, 0, 1, 1); 
        assertEquals("5,0,1,1", p4.toString()); 
        
        Plot p5 = new Plot(0, 6, 1, 1); 
        assertEquals("0,6,1,1", p5.toString()); 
        
        Plot p6 = new Plot(1, 1, 2, 2); 
        assertEquals("1,1,2,2", p6.toString());
        
        Plot p7 = new Plot(2, 2, 2, 2);
        assertEquals("2,2,2,2", p7.toString());
	}

}
