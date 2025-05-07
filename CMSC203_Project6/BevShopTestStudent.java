import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BevShopTestStudent {

	private BevShop bevShop;

    @BeforeEach
    public void setUp() {
        bevShop = new BevShop();
    }

    @Test
    public void testIsValidTime() {
        assertTrue(bevShop.isValidTime(8));
        assertFalse(bevShop.isValidTime(2));
    }

    @Test
    public void testIsValidAge() {
        assertTrue(bevShop.isValidAge(21));
        assertFalse(bevShop.isValidAge(18));
    }

    @Test
    public void testStartNewOrderAndGetCurrentOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "Alice", 25);
        Order current = bevShop.getCurrentOrder();

        assertNotNull(current);
        assertEquals("Alice", current.getCustomer().getName());
        assertEquals(1, bevShop.totalNumOfMonthlyOrders());
    }

    @Test
    public void testProcessCoffeeOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "Bob", 30);
        bevShop.processCoffeeOrder("Latte", Size.MEDIUM, true, true);

        assertEquals(1, bevShop.getCurrentOrder().getTotalItems());
    }

    @Test
    public void testProcessSmoothieOrder() {
        bevShop.startNewOrder(11, Day.TUESDAY, "Sam", 20);
        bevShop.processSmoothieOrder("Berry Blend", Size.LARGE, 3, true);

        assertEquals(1, bevShop.getCurrentOrder().getTotalItems());
    }

    @Test
    public void testProcessAlcoholOrderAndEligibility() {
        bevShop.startNewOrder(12, Day.WEDNESDAY, "Tom", 25);
        assertTrue(bevShop.isEligibleForMore());

        bevShop.processAlcoholOrder("Wine", Size.SMALL);
        bevShop.processAlcoholOrder("Beer", Size.MEDIUM);
        bevShop.processAlcoholOrder("Vodka", Size.LARGE);

        assertEquals(3, bevShop.getNumOfAlcoholDrink());
        assertFalse(bevShop.isEligibleForMore());  // hit limit
    }

    @Test
    public void testFindOrder() {
        bevShop.startNewOrder(13, Day.THURSDAY, "Lisa", 22);
        int orderNo = bevShop.getCurrentOrder().getOrderNo();

        assertEquals(0, bevShop.findOrder(orderNo));
        assertEquals(-1, bevShop.findOrder(orderNo + 1));
    }

    @Test
    public void testTotalOrderPriceAndMonthlySale() {
        bevShop.startNewOrder(10, Day.FRIDAY, "John", 27);
        bevShop.processCoffeeOrder("Espresso", Size.SMALL, false, false);
        double total1 = bevShop.getCurrentOrder().calcOrderTotal();

        bevShop.startNewOrder(12, Day.SATURDAY, "Jane", 23);
        bevShop.processSmoothieOrder("Tropical", Size.MEDIUM, 2, false);
        double total2 = bevShop.getCurrentOrder().calcOrderTotal();

        double expectedTotal = total1 + total2;
        assertEquals(expectedTotal, bevShop.totalMonthlySale(), 0.01);
    }

    @Test
    public void testSortOrders() {
        bevShop.startNewOrder(9, Day.SUNDAY, "A", 24);
        bevShop.getCurrentOrder().setOrderNo(103);

        bevShop.startNewOrder(10, Day.SUNDAY, "B", 24);
        bevShop.getCurrentOrder().setOrderNo(101);

        bevShop.startNewOrder(11, Day.SUNDAY, "C", 24);
        bevShop.getCurrentOrder().setOrderNo(102);

        bevShop.sortOrders();

        assertEquals(101, bevShop.getOrderAtIndex(0).getOrderNo());
        assertEquals(102, bevShop.getOrderAtIndex(1).getOrderNo());
        assertEquals(103, bevShop.getOrderAtIndex(2).getOrderNo());
    }

}
