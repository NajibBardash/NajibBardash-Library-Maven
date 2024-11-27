package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import utilities.GenderType;

import java.time.LocalDate;

public class LoanTest {

	//VG
	@Test
	public void testDueDate() {
		Loan testLoan = new Loan(1,
				new Customer("test", "", "", "", "", "", 1, GenderType.MALE ),
				new Book(1,"Java", "", "", "", 50 ));
		assertEquals(LocalDate.now().plusDays(14), testLoan.getDueDate());
   } // Tests if duedate is + 14 days from the time of the loan-start.
}