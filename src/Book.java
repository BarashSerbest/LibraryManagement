public class Book {
    private String name;
    private String author;

    //  Constructor method
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    // Book sınıfı içerisindeki değişkenlerin içeriğine erişebilmek için get özelliği ekleniyor.
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
}
