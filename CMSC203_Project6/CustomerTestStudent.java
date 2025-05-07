import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTestStudent {

	/**
     * Tests the constructor for proper initialization.
     */
	@Test
    public void testConstructor() {
        Customer customer = new Customer("Alice", 30);
        assertEquals("Alice", customer.getName());
        assertEquals(30, customer.getAge());
    }

    /**
     * Tests the copy constructor to ensure it creates a new object with the same values.
     */
    @Test
    public void testCopyConstructor() {
        Customer original = new Customer("Bob", 25);
        Customer copy = new Customer(original);
        assertEquals("Bob", copy.getName());
        assertEquals(25, copy.getAge());
        assertNotSame(original, copy); // Ensure it's a deep copy
    }

    /**
     * Tests the toString method for correct formatting.
     */
    @Test
    public void testToString() {
        Customer customer = new Customer("Charlie", 22);
        assertEquals("Charlie, 22", customer.toString());
    }

}
