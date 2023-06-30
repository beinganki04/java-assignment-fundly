package org.java;
import java.text.SimpleDateFormat;
import java.util.*;

public class LoanStore {
    private List<Loan> loans;

    public LoanStore() {
        loans = new ArrayList<>();
    }

    public void addLoan(Loan loan) throws Exception {
        if (loan.getPaymentDate().after(loan.getDueDate())) {
            throw new Exception("Payment date cannot be greater than the due date");
        }

        loans.add(loan);

        if (loan.getDueDate().before(new Date())) {
            System.out.println("Loan with ID " + loan.getLoanId() + " has crossed the due date");
        }
    }

    public Map<String, Double> aggregateByLender() {
        Map<String, Double> aggregate = new HashMap<>();

        for (Loan loan : loans) {
            aggregate.put(loan.getLenderId(), aggregate.getOrDefault(loan.getLenderId(), 0.0) + loan.getRemainingAmount());
        }

        return aggregate;
    }

    public Map<Integer, Double> aggregateByInterest() {
        Map<Integer, Double> aggregate = new HashMap<>();

        for (Loan loan : loans) {
            aggregate.put(loan.getInterestPerDay(), aggregate.getOrDefault(loan.getInterestPerDay(), 0.0) + loan.getRemainingAmount());
        }

        return aggregate;
    }

    public Map<String, Double> aggregateByCustomerId() {
        Map<String, Double> aggregate = new HashMap<>();

        for (Loan loan : loans) {
            aggregate.put(loan.getCustomerId(), aggregate.getOrDefault(loan.getCustomerId(), 0.0) + loan.getRemainingAmount());
        }

        return aggregate;
    }
}