// JUnit test cases
import org.java.Loan;
import org.java.LoanStore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class LoanStoreTest {
    private LoanStore loanStore;

    @BeforeEach
    public void setUp() {
        loanStore = new LoanStore();
    }

    @Test
    public void testAddLoanWithValidPaymentDate() throws Exception {
        Loan loan = createLoan("L1", "C1", "LEN1", 10000, 10000,
                "05/06/2023", 1, "05/07/2023", 0.01);

        loanStore.addLoan(loan);

        // Assert that loan is added successfully
        Assertions.assertEquals(1, loanStore.aggregateByLender().size());
        Assertions.assertEquals(1, loanStore.aggregateByInterest().size());
        Assertions.assertEquals(1, loanStore.aggregateByCustomerId().size());
    }

    @Test
    public void testAddLoanWithInvalidPaymentDate() throws Exception {
        Loan loan = createLoan("L2", "C1", "LEN1", 20000, 5000,
                "01/06/2023", 1, "05/08/2023", 0.01);

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            loanStore.addLoan(loan);
        });

        // Assert that the exception message is correct
        Assertions.assertEquals("Payment date cannot be greater than the due date", exception.getMessage());

        // Assert that loan is not added
        Assertions.assertEquals(0, loanStore.aggregateByLender().size());
        Assertions.assertEquals(0, loanStore.aggregateByInterest().size());
        Assertions.assertEquals(0, loanStore.aggregateByCustomerId().size());
    }

    @Test
    public void testAddLoanWithCrossedDueDate() throws Exception {
        Loan loan = createLoan("L3", "C2", "LEN2", 50000, 30000,
                "04/04/2023", 2, "04/05/2023", 0.02);

        loanStore.addLoan(loan);

        // Assert that loan is added successfully
        Assertions.assertEquals(1, loanStore.aggregateByLender().size());
        Assertions.assertEquals(1, loanStore.aggregateByInterest().size());
        Assertions.assertEquals(1, loanStore.aggregateByCustomerId().size());
    }

    private Loan createLoan(String loanId, String customerId, String lenderId, double amount, double remainingAmount,
                            String paymentDate, int interestPerDay, String dueDate, double penaltyPerDay) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date payment = dateFormat.parse(paymentDate);
        Date due = dateFormat.parse(dueDate);

        return new Loan(loanId, customerId, lenderId, amount, remainingAmount, payment, interestPerDay, due, penaltyPerDay);
    }
}
