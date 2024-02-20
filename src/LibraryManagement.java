import java.util.ArrayList;
import java.util.List;
public class LibraryManagement implements LibraryOperations {
    private static List<Book> bookList;
    private static List<Member> memberList;
    private static List<Officer> officerList;
    private static List<Book> borrowedBooks;
    private static List<Member> borrowingMember;

    // Constructor method
    public LibraryManagement() {
        bookList = new ArrayList<>();
        memberList = new ArrayList<>();
        officerList = new ArrayList<>();
        borrowedBooks = new ArrayList<>();
        borrowingMember = new ArrayList<>();
    }

    // Kütüphaneye yeni bir kitap ekleme
    public void addBook(Book book) {

        bookList.add(book);
        System.out.println(String.format(book.getAuthor()+" \""+book.getName()+"\""+" kitabı kütüphaneye eklendi."));
    }

    // Kütüphaneden bir kitabı çıkarma
    public void removeBook(Book kitap) {

        bookList.remove(kitap);
        System.out.println("\""+kitap.getName() + "\"" + " kitabı kütüphaneden çıkarıldı.");
    }

    // Kütüphaneye yeni bir üye ekleme
    public void addMember(Member uye) {

        memberList.add(uye);
        System.out.println("\"" + uye.getName() + "\"" + " kütüphaneye üye olarak eklendi.");
    }

    // Kütüphaneden bir üyeyi çıkarma
    public void removeMember(Member uye) {

        memberList.remove(uye);
        System.out.println("\""+uye.getName()+"\""+" isimli üye kütüphaneden çıkarıldı.");
    }

    // Kütüphaneye "static" tanımlanmış metot ile yeni bir görevli ekleme
    public static void addOfficer(String ad, Integer gorevliId) {
        Officer newOfficer = new Officer(ad, gorevliId);
        officerList.add(newOfficer);
        System.out.println("\"" + newOfficer.getName() +"\""+ " kütüphaneye görevli olarak eklendi.");
    }

    // Kütüphaneden bir görevliyi çıkarma
    public void removeOfficer(Integer gorevliId) {
        // Verilen ID'ye sahip görevliyi bul
        Officer officerToRemove = null;
        for (Officer officer : officerList) {
            // Integer sarmalayıcı sınıfından gelen "equals" metodu ile, görevli Id bilgisi aynımı kontrolü yapılıyor.
            if (officer.getOfficerId().equals(gorevliId)) {
                officerToRemove = officer;
                break;
            }
        }
        // Görevli "null" değil ise kütüphaneden çıkarılıyor.
        if (officerToRemove != null) {
            officerList.remove(officerToRemove);
            System.out.println("\"" + officerToRemove.getName() +"\""+ " isimli görevli kütüphaneden çıkarıldı.");
        } else {
            System.out.println("Görevli bulunamadı.");
        }
    }

    // Bir üyeye ödünç kitap verme
    @Override
    public void giveLend(Book kitap, Member uye) {
        // Burada, kitabın kütüphanede olup olmadığı "contains" fonksiyonu ile kontrol ediliyor.
        if (bookList.contains(kitap)) {
            // Bu aşamada, ödünç alınan kitap ve üye bilgileri kaydediliyor.
            System.out.println("\""+kitap.getName() +"\""+ " kitabı, " + "\"" + uye.getName() + "\"" + " adlı üyeye ödünç verildi.");
            borrowedBooks.add(kitap);
            borrowingMember.add(uye);
        } else {
            System.out.println("Kitap kütüphanede bulunmamaktadır.");
        }
    }

    // Bir üyedeki ödünç alınmış kitabı kütüphaneye geri bırakma
    @Override
    public void revoke(Book kitap, Member uye) {
        System.out.println(kitap.getName() + " kitabı, " + uye.getName() + " adlı üye tarafından kütüphaneye geri bırakıldı.");
        borrowedBooks.remove(kitap);
    }

    // Şu anda ödünç alınan kitapların kimlerde olduğunu takip etme
    @Override
    public void lendFollowUp() {

        for (int i = 0; i < borrowedBooks.size(); i++) {
            Book kitap = borrowedBooks.get(i);
            Member uye = borrowingMember.get(i);

            System.out.println(kitap.getAuthor() + " \"" + kitap.getName() +"\""+ " -Alan üye: "+ "\"" + uye.getName() + "\"");
        }
    }
}
