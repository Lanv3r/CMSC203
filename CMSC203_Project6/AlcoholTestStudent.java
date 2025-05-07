import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlcoholTestStudent {

	private Alcohol alcoholWeekdaySmall;
    private Alcohol alcoholWeekendMedium;
    private Alcohol alcoholWeekendLarge;

    @BeforeEach
    public void setUp() {
        alcoholWeekdaySmall = new Alcohol("Wine", Size.SMALL, false);
        alcoholWeekendMedium = new Alcohol("Beer", Size.MEDIUM, true);
        alcoholWeekendLarge = new Alcohol("Whiskey", Size.LARGE, true);
    }

    @Test
    public void testCalcPrice_weekdaySmall() {
        double expectedPrice = 2.0; // base price for SMALL (assumed) + no weekend fee
        assertEquals(expectedPrice, alcoholWeekdaySmall.calcPrice(), 0.01);
    }

    @Test
    public void testCalcPrice_weekendMedium() {
        double expectedPrice = 2.0 + 0.5 + 0.6; // base + MEDIUM size + weekend
        assertEquals(expectedPrice, alcoholWeekendMedium.calcPrice(), 0.01);
    }

    @Test
    public void testCalcPrice_weekendLarge() {
        double expectedPrice = 2.0 + 1.0 + 0.6; // base + LARGE size + weekend
        assertEquals(expectedPrice, alcoholWeekendLarge.calcPrice(), 0.01);
    }

    @Test
    public void testIsWeekend() {
        assertTrue(alcoholWeekendMedium.isWeekend());
        assertFalse(alcoholWeekdaySmall.isWeekend());
    }

    @Test
    public void testSetWeekend() {
        alcoholWeekdaySmall.setWeekend(true);
        assertTrue(alcoholWeekdaySmall.isWeekend());
    }

    @Test
    public void testEquals_sameObject() {
        assertEquals(alcoholWeekendMedium, alcoholWeekendMedium);
    }

    @Test
    public void testEquals_equalValues() {
        Alcohol copy = new Alcohol("Beer", Size.MEDIUM, true);
        assertEquals(alcoholWeekendMedium, copy);
    }

    @Test
    public void testEquals_differentWeekendFlag() {
        Alcohol different = new Alcohol("Beer", Size.MEDIUM, false);
        assertNotEquals(alcoholWeekendMedium, different);
    }

    @Test
    public void testEquals_differentName() {
        Alcohol different = new Alcohol("Ale", Size.MEDIUM, true);
        assertNotEquals(alcoholWeekendMedium, different);
    }

    @Test
    public void testToString_containsKeyInfo() {
        String output = alcoholWeekendMedium.toString();
        assertTrue(output.contains("Beer"));
        assertTrue(output.contains("MEDIUM"));
        assertTrue(output.contains("Offered on Weekend: true"));
        assertTrue(output.contains("Price:"));
    }

}
