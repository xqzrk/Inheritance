import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

    Product product1 = new Product (1, "Чайник", 5000);
    Product product2 = new Book (2, "Война и мир, том 1", 500, "Л.Н.Толстой");
    Product product3 = new Book (3, "Война и мир, том 2", 500, "Л.Н.Толстой");
    Product product4 = new Book (4, "Война и мир, том 3", 500, "Л.Н.Толстой");
    Product product5 = new Book (5, "Война и мир, том 4", 500, "Л.Н.Толстой");
    Product product6 = new Book (6, "Незайка на луне", 300, "Н.Н.Носов");
    Product product7 = new Smartphone (7, "Galaxy", 25_000, "Samsung");
    Product product8 = new Smartphone (8, "Galaxy A2", 35_000, "Samsung");
    Product product9 = new Smartphone (9, "IPhone 15 Pro", 135_000, "Apple");

    @Test
    public void shouldSave() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);
        repo.save(product7);
        repo.save(product8);
        repo.save(product9);

        Product[] expected = { product1, product2, product3, product4, product5, product6, product7, product8, product9 };
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);
        repo.save(product7);
        repo.save(product8);
        repo.save(product9);
        repo.removeById(2);

        Product[] expected = { product1, product3, product4, product5, product6, product7, product8, product9 };
        Product[] actual = repo.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }
}
