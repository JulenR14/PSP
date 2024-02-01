package api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;


@RestController
public class ProductController
{
    @Autowired
    private IProductService productService;

    @GetMapping(value = "/product")
    public ResponseEntity<Set<Product>> getProduct()
    {
        Set<Product> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}