package md.utm.entity;

public class University {

    private Long id;
    private String fullName;
    private String shortName;
    private String address;

    public University(Long id, String fullName, String shortName, String address) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
