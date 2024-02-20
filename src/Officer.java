public class Officer extends LibraryManagement {
    private String name;
    private Integer officerId;

    // Constructor method
    public Officer(String name, Integer officerId) {
        this.name = name;
        this.officerId = officerId;
    }

    // Officer sınıfı içerisindeki değişkenlerin içeriğine erişebilmek için get özelliği ekleniyor.
    public String getName() {
        return name;
    }

    public Integer getOfficerId() {
        return officerId;
    }
}
