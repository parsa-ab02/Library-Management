package library;

import java.util.Date;

public class Transaction {
    private String transactionId;
    private String bookTitle;
    private String memberName;
    private Date transactionDate;
    private String type;

    public Transaction(String transactionId, String bookTitle, String memberName, String type) {
        if (transactionId == null || bookTitle == null || memberName == null || type == null) {
            throw new IllegalArgumentException("Transaction details cannot be null");
        }
        if (!type.equals("BORROW") && !type.equals("RETURN")) {
            throw new IllegalArgumentException("Transaction type must be either 'BORROW' or 'RETURN'");
        }
        this.transactionId = transactionId;
        this.bookTitle = bookTitle;
        this.memberName = memberName;
        this.transactionDate = new Date();
        this.type = type;
    }
    public String getTransactionId() { return transactionId; }
    public String getBookTitle() { return bookTitle; }
    public String getMember() { return memberName; }
    public Date getTransactionDate() { return transactionDate; }
    public String getType() { return type; }
    public boolean isBorrowTransaction() {
        return "BORROW".equals(type);
    }
    public boolean isReturnTransaction() {
        return "RETURN".equals(type);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId = '" + transactionId + '\'' +
                ", book = " + bookTitle +
                ", member = " + memberName +
                ", transactionDate = " + transactionDate +
                ", type = '" + type + '\'' +
                '}';
    }
}
