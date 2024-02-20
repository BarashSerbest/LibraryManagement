//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Kütüphane yönetimi için LibraryManagament sınıfından "library" nesnesi oluşturuluyor.
        LibraryManagement library = new LibraryManagement();

        // Burada yapıcı metoda "Kitap" ve "Yazar" ismi verilerek ilk Kitap nesnesi oluşturuluyor.
        Book book1 = new Book("Nutuk", "Mustafa Kemal Atatürk");
        Book book2 = new Book("Robotların İktidarı", "Martin Ford");
        Book book3 = new Book("Gurur ve Önyargı", "Jane Austen");

        System.out.print("\n");
        // Burada kütüphaneye static tanımlanmış metot ile doğrudan sınıf ismi kullanılarak görevli ekleniyor.
        LibraryManagement.addOfficer("Metin Özdemir",4001);
        LibraryManagement.addOfficer("Ali Gökdeniz",4002);
        System.out.print("\n");

        // Burada kütüphane üye nesneleri oluşturuluyor.
        Member member1 = new Member("Barash Serbest",1001);
        Member member2 = new Member("Yavuz Dikkaya", 1002);
        //Kutuphane nesnesi ile üyeler ekleniyor.
        library.addMember(member1);
        library.addMember(member2);
        System.out.print("\n");

        // Oluşturulan kitap nesneleri kütüphane içerisine ekleniyor.
        // Burada kitapları görevli nesnesi ile "KutuphaneYonetimSistemi"nden kalıtım ile aldığımız metod ile ekliyoruz.
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        System.out.print("\n");


        // "Kitap1" library nesnesinin metodu ile "member1"e ödünç veriliyor.
        library.giveLend(book1, member1);
        // "Kitap1" gorevli nesnesinin kalıtım ile aldığı metot ile "member1"e ödünç veriliyor.
        library.giveLend(book2,member1);
        library.giveLend(book3,member2);
        System.out.print("\n");

        // Ödünç verilen kitapların bilgileri ve verilen kullanıcının bilgileri kontrol ediliyor.
        System.out.println("Şu anda ödünç alınan kitaplar ve alan üyeler:");
        library.lendFollowUp();
        System.out.print("\n");

        // Ödünç alınan kitap kutuphaneye geri alınıyor.
        library.revoke(book3,member2);
        System.out.print("\n");

        // Ödünç verilen kitap iade edildikten sonra tekrar ödünç alınan kitaplar kontrol ediliyor.
        System.out.println("Şu anda ödünç alınan kitaplar ve alan üyeler:");
        library.lendFollowUp();
        System.out.print("\n");

        // Kütüphaneden kitap çıkarma
        library.removeBook(book3);
        System.out.print("\n");

        // Kütüphaneden üye çıkarma
        library.removeMember(member2);
        System.out.print("\n");

        // Kütüphaneden görevli çıkarma
        library.removeOfficer(4002);
        System.out.print("\n");
    }
}