import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmoothieTestStudent {

	private Smoothie smoothie1;
    private Smoothie smoothie2;
    private Smoothie smoothie3;

    @BeforeEach
    public void setUp() {
        smoothie1 = new Smoothie("Strawberry Blast", Size.SMALL, 2, true);  // 2.00 + 1.5 + (2 × 0.5) = 4.5
        smoothie2 = new Smoothie("Berry Delight", Size.LARGE, 3, false);    // 3.00 + (3 × 0.5) = 4.5
        smoothie3 = new Smoothie("Strawberry Blast", Size.SMALL, 2, true);  // identical to smoothie1
    }

    @Test
    public void testCalcPrice_withProteinAndFruits() {
        double expected = 2.0 + 1.5 + (2 * 0.5); // SMALL + protein + 2 fruits
        assertEquals(expected, smoothie1.calcPrice(), 0.01);
    }

    @Test
    public void testCalcPrice_withoutProteinWithFruits() {
        double expected = 2.0 + 0.5 * 2; // SMALL + 2 fruits, no protein
        Smoothie smoothie = new Smoothie("Tropical Twist", Size.SMALL, 2, false);
        assertEquals(expected, smoothie.calcPrice(), 0.01);
    }

    @Test
    public void testCalcPrice_largeSizeNoProtein() {
        double expected = 2.0 + 2 * 0.5 + 3 * 0.5; // LARGE base + 3 fruits
        assertEquals(expected, smoothie2.calcPrice(), 0.01);
    }

    @Test
    public void testToString() {
        String expected = "Strawberry Blast, SMALL, Protein Added: true, Number of Fruits: 2, Price: $4.50";
        assertEquals(expected, smoothie1.toString());
    }

    @Test
    public void testEquals_sameData() {
        assertTrue(smoothie1.equals(smoothie3));
    }

    @Test
    public void testEquals_differentData() {
        assertFalse(smoothie1.equals(smoothie2));
    }

    @Test
    public void testEquals_null() {
        assertFalse(smoothie1.equals(null));
    }

    @Test
    public void testEquals_differentClass() {
        assertFalse(smoothie1.equals("Not a Smoothie"));
    }

}
