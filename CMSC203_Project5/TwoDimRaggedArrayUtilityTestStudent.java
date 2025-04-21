import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class TwoDimRaggedArrayUtilityTestStudent {
	private double[][] dataSet1 = {
			{ 7, 2, 4 }, 
			{ 1, 5, 6 }, 
			{ 9, 3 }
		};
	private double[][] dataSet2 = {
		    { -14.2, 3.5, 7.8 },
		    { 0.0, -9.1 },
		    { 22.6, -3.3, 11.7 },
		    { -6.4, 4.1, 5.5, -2.2 },
		    { 8.8 }
		};
	@Test
	public void testGetTotal() {
		assertEquals(37.0,TwoDimRaggedArrayUtility.getTotal(dataSet1),.001);
		assertEquals(28.8,TwoDimRaggedArrayUtility.getTotal(dataSet2),.001);
	}
	
	@Test
	public void testGetAverage() {
		assertEquals(4.625,TwoDimRaggedArrayUtility.getAverage(dataSet1),.001);
		assertEquals(2.215,TwoDimRaggedArrayUtility.getAverage(dataSet2),.001);
	}
	
	@Test
	public void testGetRowTotal() {
		assertEquals(12.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 1),.001);
		assertEquals(31.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet2, 2),.001);
	}
	
	@Test
	public void testGetColumnTotal() {
		assertEquals(17.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 0),.001);
		assertEquals(-4.8,TwoDimRaggedArrayUtility.getColumnTotal(dataSet2, 1),.001);
	}
	
	@Test
	public void testGetHighestInRow() {
		assertEquals(7.0,TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 0),.001);
		assertEquals(7.8,TwoDimRaggedArrayUtility.getHighestInRow(dataSet2, 0),.001);
	}
	
	@Test
	public void testGetHighestInRowIndex() {
		assertEquals(0,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 0),.001);
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet2, 0),.001);
	}
	
	@Test
	public void testGetLowestInRow() {
		assertEquals(1.0,TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 1),.001);
		assertEquals(-6.4,TwoDimRaggedArrayUtility.getLowestInRow(dataSet2, 3),.001);
	}
	
	@Test
	public void testGetLowestInRowIndex() {
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 1),.001);
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet2, 3),.001);
	}
	
	@Test
	public void testGetHighestInColumn() {
		assertEquals(5.0,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 1),.001);
		assertEquals(11.7,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet2, 2),.001);
	}
	
	@Test
	public void testGetHighestInColumnIndex() {
		assertEquals(1,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 1),.001);
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet2, 2),.001);
	}
	
	@Test
	public void testGetLowestInColumn() {
		assertEquals(2.0,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 1),.001);
		assertEquals(-9.1,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet2, 1),.001);
	}
	
	@Test
	public void testGetLowestInColumnIndex() {
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 1),.001);
		assertEquals(1,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet2, 1),.001);
	}
	
	@Test
	public void testGetHighestInArray() {
		assertEquals(9.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSet1),.001);
		assertEquals(22.6,TwoDimRaggedArrayUtility.getHighestInArray(dataSet2),.001);
	}
	
	@Test
	public void testGetLowestInArray() {
		assertEquals(1.0,TwoDimRaggedArrayUtility.getLowestInArray(dataSet1),.001);
		assertEquals(-14.2,TwoDimRaggedArrayUtility.getLowestInArray(dataSet2),.001);
	}
}
