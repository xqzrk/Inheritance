import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Product(1, "Чайник", 5000);
    Product product2 = new Book(2, "Война и мир, том 1", 500, "Л.Н.Толстой");
    Product product3 = new Book(3, "Война и мир, том 2", 500, "Л.Н.Толстой");
    Product product4 = new Book(4, "Война и мир, том 3", 500, "Л.Н.Толстой");
    Product product5 = new Book(5, "Война и мир, том 4", 500, "Л.Н.Толстой");
    Product product6 = new Book(6, "Незайка на луне", 300, "Н.Н.Носов");
    Product product7 = new Smartphone(7, "Galaxy", 25_000, "Samsung");
    Product product8 = new Smartphone(8, "Galaxy A2", 35_000, "Samsung");
    Product product9 = new Smartphone(9, "IPhone 15 Pro", 135_000, "Apple");

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
        manager.add(product7);
        manager.add(product8);
        manager.add(product9);

    }

    @Test
    public void shouldFindByName() {
        Product[] expected = {product2, product3, product4, product5};
        Product[] actual = manager.searchBy("Война");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByNameifOneMatch() {
        Product[] expected = {product9};
        Product[] actual = manager.searchBy("IPhone");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByNameifNoMatches() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Motorola");

        Assertions.assertArrayEquals(expected, actual);
    }
}
