package api;

import org.springframework.http.ResponseEntity;

import java.util.Set;


public interface IProductService {
    Set<Product> findAll();
    /*Set<Product> findByCategory(String category);
    Optional<Product> findById(long id);
    Product addProduct(Product product);
    Product modifyProduct(long id, Product newProduct);
    void deleteProduct(long id);*/
}
