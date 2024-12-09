package md.utm.entity;

import java.util.List;

public class UniversityStudent {

    private Long id;
    private String fullName;
    private String shortName;
    private String address;
    private List<Student> studentList;

    public UniversityStudent(Long id, String fullName, String shortName, String address, List<Student> studentList) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.address = address;
        this.studentList = studentList;
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

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "UniversityStudent{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", address='" + address + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
