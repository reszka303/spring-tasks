package pl.javastart.devicerent.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 45)
    private String firstName;
    @Column(nullable = false, length = 45)
    private String lastName;
    @Column(nullable = false, length = 11)
    private String pesel;
    @Column(nullable = false, length = 10)
    private String idNumber;
    //mappedBy customer nie jest właścicielem relacji i dlatego mappedBy umieszczamy w tej encji
    @ManyToMany(mappedBy = "customers")
    private List<Device> rentDevices = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public List<Device> getRentDevices() {
        return rentDevices;
    }

    public void setRentDevices(List<Device> rentDevices) {
        this.rentDevices = rentDevices;
    }

}
