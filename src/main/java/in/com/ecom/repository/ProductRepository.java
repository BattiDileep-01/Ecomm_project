package in.com.ecom.repository;

import in.com.ecom.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ProductRepository extends JpaRepository <Product, Long > {
}
