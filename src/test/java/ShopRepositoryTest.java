import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void shouldProductFindById() {
        ShopRepository repo = new ShopRepository();
        Product productI = new Product(1, "хлеб", 100);
        Product productII = new Product(2, "сыр", 200);
        Product productIII = new Product(3, "конфеты", 300);

        repo.add(productI);
        repo.add(productII);
        repo.add(productIII);
        repo.remove(1);
        Product[] expected = {productII, productIII};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNoProductFindById() {
        ShopRepository repo = new ShopRepository();
        Product productI = new Product(1, "хлеб", 100);
        Product productII = new Product(2, "сыр", 200);
        Product productIII = new Product(3, "конфеты", 300);

        repo.add(productI);
        repo.add(productII);
        repo.add(productIII);
        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(5)
        );
    }
}
