package library;

import datastructures.lists.CustomArrayList;

public class Member {
    private String memberId;
    private String name;
    private CustomArrayList<Transaction> transactions;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.transactions = new CustomArrayList<>();
    }
    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public void addTransaction(Transaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaction cannot be null");
        }
        transactions.add(transaction);
    }
    public Transaction getLastTransaction() {
        if (transactions.isEmpty()) {
            return null;
        }
        return transactions.get(transactions.size() - 1);
    }
    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
