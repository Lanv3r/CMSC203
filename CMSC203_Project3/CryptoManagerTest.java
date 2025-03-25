import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerTest {
	CryptoManager cryptoManager;

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}
	
	@Test
	void testIsStringInBounds() {
		assertFalse(CryptoManager.isStringInBounds("abc"));
	}

	@Test
	void testCaesarEncryption() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("abc", 1));
		assertEquals("UVWXY", CryptoManager.caesarEncryption("ABCDE", 20));
		assertEquals("*Y&-4[##X4(Y'(", CryptoManager.caesarEncryption("VERY GOOD TEST", 404));
	}

	@Test
	void testBellasoEncryption() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.bellasoEncryption("abc", "CMSC203"));
		assertEquals("EFQ_B%R", CryptoManager.bellasoEncryption("BELLASO", "CAESAR"));
		assertEquals("MARYLAND", CryptoManager.bellasoEncryption("@=EU?=A@", "MD"));
		assertEquals("JEVR]&DMXVLJC]", CryptoManager.bellasoEncryption("ICSQ[#CKUUJGB[", "ABC"));
	}

	@Test
	void testCaesarDecryption() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarDecryption("abc", 1));
		assertEquals("-./01", CryptoManager.caesarDecryption("ABCDE", 20));
		assertEquals("B1>EL3;;0L@1?@", CryptoManager.caesarDecryption("VERY GOOD TEST", 404));
	}

	@Test
	void testBellasoDecryption() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.bellasoDecryption("abc", "CMSC203"));
		assertEquals("?DG9@AL", CryptoManager.bellasoDecryption("BELLASO", "CAESAR"));
		assertEquals("HAPPY BIRTHDAY", CryptoManager.bellasoDecryption("ICSQ[#CKUUJGB[", "ABC"));
		assertEquals("398Q294<", CryptoManager.bellasoDecryption("@=EU?=A@", "MD"));
	}

}
