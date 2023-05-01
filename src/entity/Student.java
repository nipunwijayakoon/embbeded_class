package entity;

import javax.persistence.*;

@Entity(name ="student_table")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "id")
    private long studentId;
    @Column(name = "student_name", length = 50, nullable = false)
    private String name;
    @Embedded
    @AttributeOverride(column = @Column(name="residential_country"), name ="country")
    @AttributeOverride(column = @Column(name="residential_city"), name ="city")
    @AttributeOverride(column = @Column(name="residential_postal"), name ="postal")
    private Address residentaladdress;

    @Embedded
    @AttributeOverride(column = @Column(name="permenent_country"), name ="country")
    @AttributeOverride(column = @Column(name="permenent_city"), name ="city")
    @AttributeOverride(column = @Column(name="permenent_postal"), name ="postal")
    private Address permenentaddress;

    public Student(long studentId, String name, Address residentaladdress, Address permenentaddress) {
        this.studentId = studentId;
        this.name = name;
        this.residentaladdress = residentaladdress;
        this.permenentaddress = permenentaddress;
    }

    public Student() {
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getResidentaladdress() {
        return residentaladdress;
    }

    public void setResidentaladdress(Address residentaladdress) {
        this.residentaladdress = residentaladdress;
    }

    public Address getPermenentaddress() {
        return permenentaddress;
    }

    public void setPermenentaddress(Address permenentaddress) {
        this.permenentaddress = permenentaddress;
    }
}
