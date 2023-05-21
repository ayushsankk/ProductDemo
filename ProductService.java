import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductService {

    List<Product> products = new ArrayList<>();

    public void addProduct(Product p){
        products.add(p);
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public Product getProduct(String name){
        return products.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<Product> getProductWithText(String text) {
        String str = text.toLowerCase();

        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(str)
                        || p.getType().toLowerCase().contains(str)
                        || p.getPlace().toLowerCase().contains(str))
                .collect(Collectors.toList());
    }

    public Stream<Product> getProductByPlace(String text) {
        return products.stream().filter(product -> product.getPlace().equalsIgnoreCase(text));
    }

    public Stream<Product> getOutOfWarrantyProducts() {
        return products.stream().filter(product -> product.getWarranty() < 2023);
    }
}
