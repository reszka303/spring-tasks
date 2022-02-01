package pl.javastart.devicerent.components.device;

import pl.javastart.devicerent.components.customer.Customer;
import pl.javastart.devicerent.components.devicecategory.DeviceCategory;

import javax.persistence.*;
import java.util.*;

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
//    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(
            name = "device_category_id",
            foreignKey = @ForeignKey(
                    name = "fk_device_category_id")
    )
    private DeviceCategory deviceCategory;
//    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @ManyToMany(cascade = CascadeType.PERSIST)
//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
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

    public void addCustomers(Customer customer) {
        customers.add(customer);
        customer.getRentDevices().add(this);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
        customer.getRentDevices().remove(this);
    }

    @Override
    public String toString() {
        return "Urządzenie{" +
                "id=" + id +
                ", nazwa='" + name + '\'' +
                ", ilość=" + quantity +
                ", cena=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return quantity == device.quantity &&
                Double.compare(device.price, price) == 0 &&
                Objects.equals(id, device.id) &&
                Objects.equals(name, device.name) &&
                Objects.equals(description, device.description) &&
                Objects.equals(deviceCategory, device.deviceCategory) &&
                Objects.equals(customers, device.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, quantity, price, deviceCategory, customers);
    }
}
