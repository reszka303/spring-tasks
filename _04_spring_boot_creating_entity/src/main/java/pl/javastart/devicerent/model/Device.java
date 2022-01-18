package pl.javastart.devicerent.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(length = 2048, nullable = false)
    private String description;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private double price;
    @ManyToOne
    @JoinColumn(
            name = "device_category_id",
            foreignKey = @ForeignKey(
                    name = "fk_device_category_id")
    )
    private DeviceCategory deviceCategory;
    @ManyToMany
    //@JoinTable umieszczamy po stronie, która nie jest właścicielem
    @JoinTable(
            name = "device_has_customer",
            joinColumns = {@JoinColumn(
                    name = "device_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(
                            name = "fk_device_id"))},
            inverseJoinColumns = {@JoinColumn(
                    name = "customer_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(
                            name = "fk_customer_id"))}
    )
    private List<Customer> customers = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public DeviceCategory getDeviceCategory() {
        return deviceCategory;
    }

    public void setDeviceCategory(DeviceCategory deviceCategory) {
        this.deviceCategory = deviceCategory;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

}
