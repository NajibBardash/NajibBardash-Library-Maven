package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BookCatalogTest {

    private BookCatalog bc;

    public BookCatalogTest() {
        bc = new BookCatalog();
        Book book1 = new Book(1, "Learning Java", "", "", "", 0);
        bc.addBook(book1);
    }

    //G
    @Test
    public void testAddABook() {
        Book testBook1 = new Book(1, "Test", "", "", "", 0);
        bc.addBook(testBook1); // getNumberOfBooks should be 1 BEFORE adding this book (one book in catalogue).
        assertEquals(2, bc.getNumberOfBooks()); // Now the value should be 2 because we have added a second book.
        assertEquals(bc.getBookArray()[1], testBook1); // This tests if the actual book is in the array.
    }

    //G
    @Test
    public void testFindBook() {
        try { // A search for the book that was added in the constructor. Should pass.
            assertEquals(bc.getBookArray()[0], bc.findBook("Learning Java"));
        } catch (BookNotFoundException e) {
            fail("Should fail if the book doesn't exist."); // We should not get here.
        }
    }

    //G
    @Test
    public void testFindBookIgnoringCase() {
        try { // A search for the book with mixed cases. Should pass.
            assertEquals(bc.getBookArray()[0], bc.findBook("LEARnInG JAVA"));
        } catch (BookNotFoundException e) {
            fail("Should fail if the book doesn't exist."); // We should not get here.
        }
    }

    //G
    @Test
    public void testFindBookWithExtraSpaces() {
        try { // A search for the book with tab before and after the title name. Should pass.
            assertEquals(bc.getBookArray()[0], bc.findBook("    Learning Java    "));
        } catch (BookNotFoundException e) {
            fail("Should fail if the book doesn't exist."); // We should not get here.
        }
    }

    //VG
    // This test should throw BookNotFoundException in order to pass.
    @Test
    public void testFindBookThatDoesntExist() throws BookNotFoundException {
        assertThrows(BookNotFoundException.class, () -> bc.findBook("Wrong book"));
        // This will throw an exception because "Wrong book" doesn't exist.
    }

}
