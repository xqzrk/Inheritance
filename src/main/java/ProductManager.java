public class ProductManager {

    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.save(product);
    }


    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.getProducts()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                result = tmp;
            }
        }

        Product[] tmp = new Product[result.length];
        int copyToIndex = 0;
        for (Product product : repo.getProducts()) {
            if (matches(product, text)) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
            result = tmp;
        }
        return result;
    }
}
