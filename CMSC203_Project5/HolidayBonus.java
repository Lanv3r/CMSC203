
public class HolidayBonus {
	private final static double HIGH_BONUS = 5000; // Bonus for the highest selling store in the category
	private final static double LOW_BONUS = 1000; // Bonus for the lowest selling store in the category
	private final static double REG_BONUS = 2000; // Bonus for the other stores in the category
	
	/**
	 * Calculates the holiday bonus for each store
	 *
	 * @param data the two-dimensional ragged array of store sales
	 * @return an array of the bonus for each store
	 */
	public static double[] calculateHolidayBonus(double[][] data) {
		int rows = data.length;
		double[] array = new double[rows];
		for (int i = 0; i < rows; i++) {
			double bonus = 0;
			for (int k = 0; k < data[i].length; k++) {
				if (data[i][k] > 0 && data[i][k] == TwoDimRaggedArrayUtility.getHighestInColumn(data, k)) {
					bonus += HIGH_BONUS;
				} else if (data[i][k] > 0 && data[i][k] == TwoDimRaggedArrayUtility.getLowestInColumn(data, k)) {
					bonus += LOW_BONUS;
				} else if (data[i][k] > 0) {
					bonus += REG_BONUS;
				}
			}
			array[i] = bonus;
		}
		return array;
	}
	
	/**
	 * Calculates the total holiday bonuses
	 *
	 * @param data the two-dimensional ragged array of store sales
	 * @return a double representing the total of all holiday bonuses
	 */
	public static double calculateTotalHolidayBonus(double[][] data) {
		double[] array = HolidayBonus.calculateHolidayBonus(data);
		double total = 0;
		for (double val : array) {
			total += val;
		}
		return total;
	}
}
