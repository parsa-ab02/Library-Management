package management;

import library.Book;
import library.Member;
import datastructures.maps.CustomHashMap;

public class BookManager {
    private CustomHashMap<String, Book> booksByIsbn;
    private MemberManager memberManager;
    public BookManager(MemberManager memberManager) {
        this.booksByIsbn = new CustomHashMap<>();
        this.memberManager = memberManager;
    }
    public void addBook(Book book) {
        if (book == null || book.getIsbn() == null) {
            throw new IllegalArgumentException("Book or ISBN cannot be null");
        }
        booksByIsbn.put(book.getIsbn(), book);
    }
    public Book getBookByIsbn(String isbn) {
        if (isbn == null) {
            throw new IllegalArgumentException("ISBN cannot be null");
        }
        return booksByIsbn.get(isbn);
    }
    public boolean isBookAvailable(String isbn) {
        Book book = getBookByIsbn(isbn);
        return book != null && book.isAvailable();
    }
    public void setBookAvailability(String isbn, boolean available) {
        Book book = getBookByIsbn(isbn);
        if (book != null) {
            book.setAvailable(available);
        }
    }
    public void addToWaitlist(String isbn, String memberId) {
        Book book = getBookByIsbn(isbn);
        Member member = memberManager.getMember(memberId);
        if (book != null && member != null) {
            book.addToWaitlist(member);
        }
    }
    public Member getNextFromWaitlist(String isbn) {
        Book book = getBookByIsbn(isbn);
        return book != null ? book.getNextInWaitlist() : null;
    }
    public boolean hasWaitlist(String isbn) {
        Book book = getBookByIsbn(isbn);
        return book != null && book.hasWaitlist();
    }
}
