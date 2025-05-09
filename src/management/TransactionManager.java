package management;

import library.Book;
import library.Member;
import library.Transaction;
import datastructures.lists.CustomArrayList;

import java.util.Date;

public class TransactionManager {
    private CustomArrayList<Transaction> transactions;

    public TransactionManager() {
        this.transactions = new CustomArrayList<>();
    }


    public Transaction addTransaction(String bookTitle, String memberName, String type) {
        Transaction transaction = new Transaction(
                "TXN-" + new Date().getTime(),
                bookTitle,
                memberName,
                type
        );
        transactions.add(transaction);

        return transaction;
    }
    public Transaction getTransactionByIndex(int index) {
        if (index < 0 || index >= transactions.size()) {
            throw new IndexOutOfBoundsException("Transaction index out of bounds");
        }
        return transactions.get(index);
    }
}
