import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
	private GradeBook gb1;
    private GradeBook gb2;

	@BeforeEach
	void setUp() throws Exception {
		// Initialize GradeBook objects with 5 scores
		gb1 = new GradeBook(5);
		gb2 = new GradeBook(5);
		
		// Add some random scores to both GradeBook objects
		gb1.addScore(2.0);
		gb1.addScore(2.5);
		gb1.addScore(4.0);
		gb1.addScore(3.5);
		
		gb2.addScore(1.0);
		gb2.addScore(5.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		// Nullify GradeBook objects
		gb1 = null;
		gb2 = null;
	}

	@Test
	void testAddScore() {
		gb1.addScore(7.7);
		gb2.addScore(6.0);
		String expectedScores1 = "2.0 2.5 4.0 3.5 7.7";
		String expectedScores2 = "1.0 5.0 6.0";
		assertEquals(expectedScores1, gb1.toString());
		assertEquals(expectedScores2, gb2.toString());
		assertEquals(5, gb1.getScoreSize());
		assertEquals(3, gb2.getScoreSize());
	}

	@Test
	void testSum() {
		double expectedSum1 = 2.0 + 2.5 + 4.0 + 3.5;
		double expectedSum2 = 1.0 + 5.0;
		assertEquals(expectedSum1, gb1.sum());
		assertEquals(expectedSum2, gb2.sum());
	}

	@Test
	void testMinimum() {
		double expectedMin1 = 2.0;
		double expectedMin2 = 1.0;
		assertEquals(expectedMin1, gb1.minimum());
		assertEquals(expectedMin2, gb2.minimum());
	}

	@Test
	void testFinalScore() {
		double expectedScore1 = 2.5 + 4.0 + 3.5;
		double expectedScore2 = 5.0;
		assertEquals(expectedScore1, gb1.finalScore());
		assertEquals(expectedScore2, gb2.finalScore());
	}

	@Test
	void testGetScoreSize() {
		assertEquals(4, gb1.getScoreSize());
		assertEquals(2, gb2.getScoreSize());
	}

	@Test
	void testToString() {
		String expectedScores1 = "2.0 2.5 4.0 3.5";
		String expectedScores2 = "1.0 5.0";
		assertEquals(expectedScores1, gb1.toString());
		assertEquals(expectedScores2, gb2.toString());
	}

}
