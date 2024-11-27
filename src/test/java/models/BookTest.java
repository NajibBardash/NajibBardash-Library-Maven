package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookTest {

	//G
	@Test
	public void test2EqualBooks() {
		Book testBook1 = new Book(12345, "1984", "George Orwell", "9780141036144", "Example branch", 336);
		Book testBook2 = new Book(12345, "1984", "George Orwell", "9780141036144", "Example branch", 336);
		assertEquals(testBook1, testBook2); // Tests two equal books that should be equal. Should pass.
	}

	//G
	@Test
	public void test2NonEqualBooks() { // Tests two non-equal books. Should pass.
		Book testBook1 = new Book(12345, "1984", "George Orwell", "9780141036144", "Example branch", 336);
		Book testBook2 = new Book(1, "Anna Karenina", "Leo Tolstoy", "9781853262715", "Example branch", 848);
		assertNotEquals(testBook1, testBook2);
	}

}
