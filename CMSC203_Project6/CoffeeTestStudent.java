import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoffeeTestStudent {

	@Test
    public void testConstructorAndToString() {
        Coffee coffee = new Coffee("Latte", Size.MEDIUM, true, false);
        String expected = "Latte, MEDIUM, Extra Shot: true, Extra Syrup: false, Price: $3.00";
        assertEquals(expected, coffee.toString());
    }

    @Test
    public void testCalcPrice_NoExtras() {
        Coffee coffee = new Coffee("Black Coffee", Size.SMALL, false, false);
        // Base: 2.0, Size(SMALL): 0, Extras: 0
        assertEquals(2.0, coffee.calcPrice(), 0.001);
    }

    @Test
    public void testCalcPrice_ExtraShotOnly() {
        Coffee coffee = new Coffee("Espresso", Size.MEDIUM, true, false);
        // Base: 2.0, Size(MEDIUM): +0.5, Extra shot: +0.5
        assertEquals(3.0, coffee.calcPrice(), 0.001);
    }

    @Test
    public void testCalcPrice_ExtraSyrupOnly() {
        Coffee coffee = new Coffee("Mocha", Size.LARGE, false, true);
        // Base: 2.0, Size(LARGE): +1.0, Extra syrup: +0.5
        assertEquals(3.5, coffee.calcPrice(), 0.001);
    }

    @Test
    public void testCalcPrice_BothExtras() {
        Coffee coffee = new Coffee("Deluxe", Size.LARGE, true, true);
        // Base: 2.0, Size(LARGE): +1.0, Extras: +0.5 +0.5
        assertEquals(4.0, coffee.calcPrice(), 0.001);
    }

    @Test
    public void testEquals_SameAttributes() {
        Coffee c1 = new Coffee("Latte", Size.MEDIUM, true, true);
        Coffee c2 = new Coffee("Latte", Size.MEDIUM, true, true);
        assertTrue(c1.equals(c2));
    }

    @Test
    public void testEquals_DifferentExtras() {
        Coffee c1 = new Coffee("Latte", Size.MEDIUM, true, false);
        Coffee c2 = new Coffee("Latte", Size.MEDIUM, false, false);
        assertFalse(c1.equals(c2));
    }

    @Test
    public void testEquals_DifferentName() {
        Coffee c1 = new Coffee("Latte", Size.MEDIUM, true, true);
        Coffee c2 = new Coffee("Mocha", Size.MEDIUM, true, true);
        assertFalse(c1.equals(c2));
    }

    @Test
    public void testEquals_NullObject() {
        Coffee c1 = new Coffee("Latte", Size.MEDIUM, true, true);
        assertFalse(c1.equals(null));
    }

    @Test
    public void testEquals_DifferentClass() {
        Coffee coffee = new Coffee("Latte", Size.MEDIUM, true, true);
        Object notCoffee = new Object();
        assertFalse(coffee.equals(notCoffee));
    }

}
