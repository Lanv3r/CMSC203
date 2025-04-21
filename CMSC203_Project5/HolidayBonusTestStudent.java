import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class HolidayBonusTestStudent {
	private double[][] dataSet1 = { 
			{ 12.4, -2.5, 3.1 }, 
			{ 4.3, -5.3 }, 
			{ 64.1, -17.1, 8.2 }, 
			{3.2, 6.4, -3.2, -7.6, 9.9} 
		};
	private double[][] dataSet2 = {
		    { -14.2, 3.5, 7.8 },
		    { 0.0, -9.1 },
		    { 22.6, -3.3, 11.7 },
		    { -6.4, 4.1, 5.5, -2.2 },
		    { 8.8 }
		};

	@Test
	public void testCalculateHolidayBonusA() {
		try {
			double[] result1 = HolidayBonus.calculateHolidayBonus(dataSet1);
			double[] result2 = HolidayBonus.calculateHolidayBonus(dataSet2);
			assertEquals(4000.0, result1[0], .001);
			assertEquals(2000.0, result1[1], .001);
			assertEquals(10000.0, result1[2], .001);
			assertEquals(11000.0, result1[3], .001);
			
			assertEquals(4000.0, result2[0], .001);
			assertEquals(0.0, result2[1], .001);
			assertEquals(10000.0, result2[2], .001);
			assertEquals(6000.0, result2[3], .001);
			assertEquals(2000.0, result2[4], .001);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}

	}

	@Test
	public void testCalculateTotalHolidayBonusA() {
		assertEquals(27000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1), .001);
		assertEquals(22000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet2), .001);
	}

}
