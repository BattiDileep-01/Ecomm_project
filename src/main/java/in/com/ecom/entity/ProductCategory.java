package in.com.ecom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long CategoryId;
    private String CategoryName;

    @OneToMany(mappedBy = "category" , cascade = CascadeType.ALL)
    private Set<Product> product;

    public Long getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(long categoryId) {
        CategoryId = categoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }
}
