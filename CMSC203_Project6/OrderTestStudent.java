import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTestStudent {

	private Order weekdayOrder;
    private Order weekendOrder;
    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer("John Doe", 25);
        weekdayOrder = new Order(10, Day.MONDAY, customer);
        weekendOrder = new Order(15, Day.SUNDAY, customer);
    }

    @Test
    public void testGettersAndSetters() {
        weekdayOrder.setOrderTime(12);
        assertEquals(12, weekdayOrder.getOrderTime());

        weekdayOrder.setOrderNo(12345);
        assertEquals(12345, weekdayOrder.getOrderNo());

        weekdayOrder.setOrderDay(Day.WEDNESDAY);
        assertEquals(Day.WEDNESDAY, weekdayOrder.getOrderDay());

        Customer newCustomer = new Customer("Jane", 30);
        weekdayOrder.setCust(newCustomer);
        Customer returned = weekdayOrder.getCustomer();
        assertEquals("Jane", returned.getName());
        assertEquals(30, returned.getAge());
        assertNotSame(newCustomer, returned); // Deep copy test
    }

    @Test
    public void testAddNewBeverageCoffee() {
        weekdayOrder.addNewBeverage("Latte", Size.MEDIUM, true, false);
        assertEquals(1, weekdayOrder.getTotalItems());
        assertTrue(weekdayOrder.getBeverage(0) instanceof Coffee);
    }

    @Test
    public void testAddNewBeverageAlcohol() {
        weekendOrder.addNewBeverage("Wine", Size.SMALL);
        assertEquals(1, weekendOrder.getTotalItems());
        assertTrue(weekendOrder.getBeverage(0) instanceof Alcohol);
    }

    @Test
    public void testAddNewBeverageSmoothie() {
        weekdayOrder.addNewBeverage("Berry Blast", Size.LARGE, 3, true);
        assertEquals(1, weekdayOrder.getTotalItems());
        assertTrue(weekdayOrder.getBeverage(0) instanceof Smoothie);
    }

    @Test
    public void testCalcOrderTotal() {
        weekdayOrder.addNewBeverage("Latte", Size.MEDIUM, true, false);    // coffee
        weekdayOrder.addNewBeverage("Berry Blast", Size.LARGE, 2, true);   // smoothie
        double total = weekdayOrder.calcOrderTotal();
        assertTrue(total > 0);
    }

    @Test
    public void testFindNumOfBeveType() {
        weekdayOrder.addNewBeverage("Latte", Size.SMALL, true, false);
        weekdayOrder.addNewBeverage("Berry Blast", Size.LARGE, 1, false);
        weekdayOrder.addNewBeverage("Espresso", Size.SMALL, false, false);
        assertEquals(2, weekdayOrder.findNumOfBeveType(Type.COFFEE));
        assertEquals(1, weekdayOrder.findNumOfBeveType(Type.SMOOTHIE));
    }

    @Test
    public void testCompareTo() {
        Order other = new Order(14, Day.TUESDAY, customer);
        other.setOrderNo(99999);
        weekdayOrder.setOrderNo(12345);
        assertTrue(weekdayOrder.compareTo(other) < 0);
        assertEquals(0, weekdayOrder.compareTo(weekdayOrder));
    }

    @Test
    public void testIsWeekend() {
        assertFalse(weekdayOrder.isWeekend());
        assertTrue(weekendOrder.isWeekend());
    }

    @Test
    public void testGetBeverageInvalidIndex() {
        assertNull(weekdayOrder.getBeverage(0));
    }

    @Test
    public void testToStringContainsInfo() {
        weekdayOrder.addNewBeverage("Latte", Size.SMALL, false, false);
        String output = weekdayOrder.toString();
        assertTrue(output.contains("Order Number:"));
        assertTrue(output.contains("Latte"));
    }
}
