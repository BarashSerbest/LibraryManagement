public interface LibraryOperations {
    void giveLend(Book book, Member member);
    void revoke(Book book, Member member);
    void lendFollowUp();
}
