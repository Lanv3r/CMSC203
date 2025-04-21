import java.io.*;
import java.util.*;

public final class TwoDimRaggedArrayUtility {
	private final static int MAX_ROW = 10; // The maximum number of rows allowed
	private final static int MAX_COLUMN = 10; // The maximum number of columns allowed

	/**
	 * Reads a file and returns its contents as a ragged 2D array of doubles.
	 *
	 * @param file the file to read from
	 * @return a ragged array of doubles, or null if the file is empty
	 * @throws FileNotFoundException if the file is not found
	 */
    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String[][] temp_array = new String[MAX_ROW][MAX_COLUMN];

        // Read file
        int row = 0;
        while (scanner.hasNextLine() && row < MAX_ROW) {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
            	String[] tokens = line.split(" ");
            	for (int i = 0; i < tokens.length; i++) {
                    temp_array[row][i] = tokens[i];
                }
                row++;
            }
        }
        scanner.close();

        //Count valid rows
        int valid_rows = 0;
        for (int i = 0; i < MAX_ROW; i++) {
            if (temp_array[i][0] != null) {
            	valid_rows++;
            }
        }
        
        if (valid_rows == 0) return null;  //Returns null if file is empty
        
        // Determine the number of columns for each row and put the values from the temporary array into in the row
        double[][]array = new double[valid_rows][];
        for (int i = 0; i < valid_rows; i++) {
        	int valid_cols = 0;
        	for (int k = 0; k < MAX_COLUMN; k++) {
        		if (temp_array[i][k] != null) {
        			valid_cols++;
        		} else {
        			break;
        		}
        	}
        	array[i] = new double[valid_cols];
        	for (int k = 0; k < valid_cols; k++) {
        		array[i][k] = Double.parseDouble(temp_array[i][k]);
        	}
        }

        return array; // 2D array of doubles
    }

    /**
     * Writes a ragged 2D array of doubles to a file.
     * Each row is written on a new line, values are separated by a space.
     *
     * @param data the ragged array of doubles
     * @param outputFile the file to write to
     * @throws FileNotFoundException if the file cannot be opened
     */
    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(outputFile);
        for (double[] row : data) {
            for (int i = 0; i < row.length; i++) {
                writer.print(row[i]);
                if (i < row.length - 1) writer.print(" "); // No need to add a space after the last value in a row
            }
            writer.println(); // Print new line
        }
        writer.close();
    }

    /**
     * Calculates the total of all elements in a 2D array.
     *
     * @param data the 2D array of doubles
     * @return the total of all elements in the array
     */
    public static double getTotal(double[][] data) {
        double total = 0;
        for (double[] row : data)
            for (double val : row)
                total += val;
        return total;
    }

    /**
     * Calculates the average of all elements in a 2D array.
     *
     * @param data the 2D array of doubles
     * @return the average of the elements in the array
     */
    public static double getAverage(double[][] data) {
        double total = 0;
        int count = 0;
        for (double[] row : data) {
            for (double val : row) {
                total += val;
                count++;
            }
        }
        return count == 0 ? 0 : total / count;
    }

    /**
     * Calculates the total of a row in a 2D array.
     *
     * @param data the 2D array of doubles
     * @param row the index of the row
     * @return the total of all elements in the row
     */
    public static double getRowTotal(double[][] data, int row) {
        double total = 0;
        for (double val : data[row])
            total += val;
        return total;
    }

    /**
     * Calculates the total of a column in a 2D array.
     *
     * @param data the 2D array of doubles
     * @param col the index of the column
     * @return the total of all elements in the column
     */
    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;
        for (double[] row : data) {
            if (col < row.length) {
                total += row[col];
            }
        }
        return total;
    }

    /**
     * Finds the highest element in a row of a 2D array.
     *
     * @param data the 2D array of doubles
     * @param row the index of the row
     * @return the highest element in the row
     */
    public static double getHighestInRow(double[][] data, int row) {
        double max = Double.NEGATIVE_INFINITY;
        for (double val : data[row]) {
            if (val > max) max = val;
        }
        return max;
    }

    /**
     * Finds the index of the highest element in a row of a 2D array.
     *
     * @param data the 2D array of doubles
     * @param row the index of the row
     * @return the index of the highest element in the row
     */
    public static int getHighestInRowIndex(double[][] data, int row) {
        int index = 0;
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] > max) {
                max = data[row][i];
                index = i;
            }
        }
        return index;
    }

    /**
     * Finds the lowest element in a row of a 2D array.
     *
     * @param data the 2D array of doubles
     * @param row the index of the row
     * @return the lowest element in the row
     */
    public static double getLowestInRow(double[][] data, int row) {
        double min = Double.POSITIVE_INFINITY;
        for (double val : data[row]) {
            if (val < min) min = val;
        }
        return min;
    }

    /**
     * Finds the index of the lowest element in a row of a 2D array.
     *
     * @param data the 2D array of doubles
     * @param row the index of the row
     * @return the index of the lowest element in the row
     */
    public static int getLowestInRowIndex(double[][] data, int row) {
        int index = 0;
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] < min) {
                min = data[row][i];
                index = i;
            }
        }
        return index;
    }

    /**
     * Finds the highest element in a column of a 2D array.
     *
     * @param data the 2D array of doubles
     * @param col the index of the column
     * @return the highest element in the column
     */
    public static double getHighestInColumn(double[][] data, int col) {
        double max = Double.NEGATIVE_INFINITY;
        for (double[] row : data) {
            if (col < row.length && row[col] > max) {
                max = row[col];
            }
        }
        return max;
    }

    /**
     * Finds the index of the highest element in a column of a 2D array.
     *
     * @param data the 2D array of doubles
     * @param col the index of the column
     * @return the index of the highest element in the column
     */
    public static int getHighestInColumnIndex(double[][] data, int col) {
        int index = -1;
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] > max) {
                max = data[i][col];
                index = i;
            }
        }
        return index;
    }

    /**
     * Finds the lowest element in a column of a 2D array.
     *
     * @param data the 2D array of doubles
     * @param col the index of the column
     * @return the lowest element in the column
     */
    public static double getLowestInColumn(double[][] data, int col) {
        double min = Double.POSITIVE_INFINITY;
        for (double[] row : data) {
            if (col < row.length && row[col] < min) {
                min = row[col];
            }
        }
        return min;
    }

    /**
     * Finds the index of the lowest element in a column of a 2D array.
     *
     * @param data the 2D array of doubles
     * @param col the index of the column
     * @return the index of the lowest element in the column
     */
    public static int getLowestInColumnIndex(double[][] data, int col) {
        int index = -1;
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] < min) {
                min = data[i][col];
                index = i;
            }
        }
        return index;
    }

    /**
     * Finds the highest element in the 2D array.
     *
     * @param data the 2D array of doubles
     * @return the highest element in the 2D array
     */
    public static double getHighestInArray(double[][] data) {
        double max = Double.NEGATIVE_INFINITY;
        for (double[] row : data)
            for (double val : row)
                if (val > max) max = val;
        return max;
    }

    /**
     * Finds the lowest element in the 2D array.
     *
     * @param data the 2D array of doubles
     * @return the lowest element in the 2D array
     */
    public static double getLowestInArray(double[][] data) {
        double min = Double.POSITIVE_INFINITY;
        for (double[] row : data)
            for (double val : row)
                if (val < min) min = val;
        return min;
    }
}
