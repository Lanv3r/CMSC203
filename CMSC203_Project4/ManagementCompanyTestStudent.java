import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

class ManagementCompanyTestStudent {

	@Test
	void testDefaultConstructor() {
		ManagementCompany mc = new ManagementCompany();
		assertEquals("", mc.getName());
		assertEquals("", mc.getTaxID());
		assertEquals(0, mc.getMgmFeePer());
		assertEquals(0, mc.getPropertiesCount());
		
		Plot plot = mc.getPlot();
		assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(10, plot.getWidth());
        assertEquals(10, plot.getDepth());
	}

	@Test
	void testConstructorNoPlot() {
		ManagementCompany mc = new ManagementCompany("Company", "12345", 5);
		assertEquals("Company", mc.getName());
		assertEquals("12345", mc.getTaxID());
		assertEquals(5.0, mc.getMgmFeePer());
		
		Plot plot = mc.getPlot();
		assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(10, plot.getWidth());
        assertEquals(10, plot.getDepth());
	}

	@Test
	void testConstructorWithValues() {
		ManagementCompany mc = new ManagementCompany("CompanyABC", "7777", 8.5, 1, 1, 5, 5);
		assertEquals("CompanyABC", mc.getName());
		assertEquals("7777", mc.getTaxID());
		assertEquals(8.5, mc.getMgmFeePer());
		
		Plot plot = mc.getPlot();
		assertEquals(1, plot.getX());
        assertEquals(1, plot.getY());
        assertEquals(5, plot.getWidth());
        assertEquals(5, plot.getDepth());
	}

	@Test
	void testCopyConstructor() {
		ManagementCompany other = new ManagementCompany("CompanyABC", "7777", 8.5, 1, 1, 5, 5);
		ManagementCompany copy = new ManagementCompany(other);
		assertEquals(other.getName(), copy.getName());
		assertEquals(other.getTaxID(), copy.getTaxID());
		assertEquals(other.getMgmFeePer(), copy.getMgmFeePer());
		
		Plot otherPlot = other.getPlot();
		Plot copyPlot = copy.getPlot();
		assertEquals(otherPlot.getX(), copyPlot.getX());
        assertEquals(otherPlot.getY(), copyPlot.getY());
        assertEquals(otherPlot.getWidth(), copyPlot.getWidth());
        assertEquals(otherPlot.getDepth(), copyPlot.getDepth());
	}

	@Test
	void testAddPropertyNoPlot() {
		ManagementCompany mc = new ManagementCompany("CompanyABC", "7777", 8.5, 1, 1, 5, 5);
		assertEquals(-3, mc.addProperty("House", "Rockville", 500.0, "Jack")); // Management company does not encompass the property plot
		
		ManagementCompany c1 = new ManagementCompany("CompanyABC", "7777", 8.5, 0, 0, 10, 10);
		assertEquals(0, c1.addProperty("House1", "Rockville", 500.0, "Jack")); // Index at which property is stored
		
		assertEquals(-4, c1.addProperty("Garage", "DC", 100.0, "Me")); // Property plot overlaps one of the of properties in array		
	}

	@Test
	void testAddPropertyWithValues() {
		ManagementCompany c1 = new ManagementCompany("CompanyABC", "7777", 8.5, 0, 0, 10, 10);
		
		assertEquals(0, c1.addProperty("House1", "Rockville", 500.0, "Jack", 0, 0, 1, 1)); 
		assertEquals(1, c1.addProperty("House2", "Rockville", 500.0, "Jack", 0, 1, 1, 1));
		assertEquals(2, c1.addProperty("House3", "Rockville", 500.0, "Jack", 0, 2, 1, 1));
		assertEquals(3, c1.addProperty("House4", "Rockville", 500.0, "Jack", 0, 3, 1, 1));
		assertEquals(4, c1.addProperty("House5", "Rockville", 500.0, "Jack", 0, 4, 1, 1));
		assertEquals(-1, c1.addProperty("House6", "Rockville", 500.0, "Jack", 0, 5, 1, 1)); // Array is full
	}

	@Test
	void testAddProperty() {
		ManagementCompany c1 = new ManagementCompany("CompanyABC", "7777", 8.5, 0, 0, 10, 10);
		
		Property p = new Property("House", "City", 666.0, "Jack");
		assertEquals(0, c1.addProperty(p)); // Index at which property is stored
		
		assertEquals(-2, c1.addProperty(null)); // Property object is null
	}

	@Test
	void testRemoveLastProperty() {
		ManagementCompany c1 = new ManagementCompany("CompanyABC", "7777", 8.5, 0, 0, 10, 10);
		
		c1.addProperty("House", "City", 300.0, "Jack");
		assertEquals(1, c1.getPropertiesCount()); // Property added
		c1.removeLastProperty();
		assertEquals(0, c1.getPropertiesCount()); // Property removed
		
		ManagementCompany c2 = new ManagementCompany("CompanyCDE", "7777", 8.5, 0, 0, 10, 10);
		
		c2.addProperty("House", "City", 300.0, "Jack");
		assertEquals(1, c2.getPropertiesCount()); // Property added
		c2.addProperty("House2", "City", 300.0, "Jack", 2, 2, 1, 1);
		assertEquals(2, c2.getPropertiesCount()); // Property added
		c2.removeLastProperty();
		assertEquals(1, c2.getPropertiesCount()); // Property removed
		c2.removeLastProperty();
		assertEquals(0, c2.getPropertiesCount()); // Property removed
	}

	@Test
	void testIsPropertiesFull() {
		ManagementCompany c1 = new ManagementCompany("CompanyABC", "7777", 8.5, 0, 0, 10, 10);
		assertFalse(c1.isPropertiesFull()); // 0 Properties in array
		for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
			c1.addProperty("House" + i, "City", 300.0, "Jack", i, i, 1, 1);
		}
		assertTrue(c1.isPropertiesFull()); // Array is full
	}

	@Test
	void testGetTotalRent() {
		ManagementCompany c1 = new ManagementCompany("CompanyABC", "7777", 8.5, 0, 0, 10, 10);
		
		c1.addProperty("House1", "City", 200.0, "Jack");
		c1.addProperty("House2", "City", 500.0, "Jack", 2, 2, 1, 1);
		assertEquals(700.0, c1.getTotalRent());
	}

	@Test
	void testGetHighestRentProperty() {
		ManagementCompany c1 = new ManagementCompany("CompanyABC", "7777", 8.5, 0, 0, 10, 10);
		
		c1.addProperty("House1", "City", 200.0, "Jack");
		c1.addProperty("House2", "City", 1500.0, "Jack", 2, 2, 1, 1);
		c1.addProperty("House3", "City", 1000.0, "Jack", 4, 4, 1, 1);
		assertEquals("House2", c1.getHighestRentProperty().getPropertyName());
	}

	@Test
	void testIsMangementFeeValid() {
		ManagementCompany c1 = new ManagementCompany("CompanyABC", "7777", 8.5, 0, 0, 10, 10);
		
		assertTrue(c1.isMangementFeeValid());
		ManagementCompany c2 = new ManagementCompany("CompanyABC", "7777", -4.0, 0, 0, 10, 10);
		assertFalse(c2.isMangementFeeValid());
		ManagementCompany c3 = new ManagementCompany("CompanyABC", "7777", 105.0, 0, 0, 10, 10);
		assertFalse(c3.isMangementFeeValid());
	}

	@Test
	void testToString() {
		ManagementCompany c1 = new ManagementCompany("CompanyABC", "7777", 8.5, 0, 0, 10, 10);
		
		c1.addProperty("House1", "City", 200.0, "Jack");
		c1.addProperty("House2", "City", 1500.0, "Jack", 2, 2, 1, 1);
		assertEquals("List of the properties for CompanyABC, taxID: 7777\n"
				+ "______________________________________________________\n"
				+ "House1,City,Jack,200.0\n"
				+ "House2,City,Jack,1500.0\n"
				+ "______________________________________________________\n"
				+ "\n"
				+ " total management Fee: 144.5", c1.toString());
	}
}