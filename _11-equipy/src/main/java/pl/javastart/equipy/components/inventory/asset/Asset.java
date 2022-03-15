package pl.javastart.equipy.components.inventory.asset;

import pl.javastart.equipy.components.assignment.Assignment;
import pl.javastart.equipy.components.inventory.category.Category;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "asset")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(unique = true)
    private String serialNumber;
    @ManyToOne
    @JoinColumn(
            name = "category_id",
            foreignKey = @ForeignKey(
                    name = "fk_asset_category_id"
            )
    )
    // mapujemy category w klasie Category za pomocą adnotacji @OneToMany(mappedBy = "category")
    private Category category;
    @OneToMany(mappedBy = "asset")
    private List<Assignment> assignments = new ArrayList<>();

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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asset asset = (Asset) o;
        return Objects.equals(id, asset.id) &&
                Objects.equals(name, asset.name) &&
                Objects.equals(description, asset.description) &&
                Objects.equals(serialNumber, asset.serialNumber) &&
                Objects.equals(category, asset.category) &&
                        Objects.equals(assignments, asset.assignments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, serialNumber, category, assignments);
    }

}
