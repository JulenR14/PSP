package api;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService
{
    @Override
    public Set<Product> findAll()
    {
        Set<Product> products = new HashSet();
        products.add(new Product(100, "Mobile", 300.00));
        products.add(new Product(101, "Smart TV", 600.00));
        products.add(new Product(102, "Washing Machine", 400.00));
        products.add(new Product(103, "Laptop", 450.00));
        products.add(new Product(104, "Air Conditioner", 1500.00));
        products.add(new Product(105, "Refrigerator ", 800.00));
        return products;
    }
}