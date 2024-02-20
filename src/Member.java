public class Member {
    private String name;
    private Integer memberId;

    public Member(String name, Integer memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    // Member sınıfı içerisindeki değişkenlerin içeriğine erişebilmek için get özelliği ekleniyor.
    public String getName() {

        return name;
    }

    public Integer getMemberId() {

        return memberId;
    }
}
