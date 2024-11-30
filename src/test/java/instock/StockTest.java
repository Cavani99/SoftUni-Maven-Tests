package instock;

import INStock.Instock;
import INStock.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Iterator;


public class StockTest {

    private Instock instock;
    private Product default_product;

    @Before
    public void initializeTestObjects(){
        this.instock = new Instock();
        this.default_product = new Product("Prod", 1.50, 2);
    }

    @Test
    public void addProductIfItsNotContained(){
        Assertions.assertEquals(0, this.instock.getCount());

        this.instock.add(default_product);
        Assertions.assertEquals(1, this.instock.getCount());

        this.instock.add(default_product);
        Assertions.assertEquals(1, this.instock.getCount(), "Cannot add duplicate product");
    }

    @Test
    public void containsReturnsTrue(){
        this.instock.add(default_product);
        Assertions.assertTrue(this.instock.contains(default_product));

        this.default_product = new Product("Prod1", 1.50, 2);
        Assertions.assertFalse(this.instock.contains(default_product));
    }

    @Test
    public void returnsCountOfProducts(){
        Assertions.assertEquals(0, this.instock.getCount());

        this.instock.add(default_product);
        Assertions.assertEquals(1, this.instock.getCount());
    }

    @Test
    public void findProduct(){
        this.instock.add(default_product);
        Assertions.assertEquals(default_product, this.instock.find(0));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            this.instock.find(1);
        });
    }

    @Test
    public void changeQuantityToProduct(){
        this.instock.add(default_product);
        this.instock.changeQuantity("Prod", 3);
        Assertions.assertEquals(3, default_product.getQuantity());

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.instock.changeQuantity("Prod1", 3);
        });
    }


    @Test
    public void getProductByLabel(){
        this.instock.add(default_product);

        Assertions.assertEquals(default_product, instock.findByLabel("Prod"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            this.instock.findByLabel("Prod1");
        });
    }

    @Test
    public void getAlphabeticalOrders(){
        this.instock.add(default_product);

        default_product = new Product("Prod1", 1.50, 2);
        this.instock.add(default_product);

        Iterable<Product> result = instock.findFirstByAlphabeticalOrder(3);

        Assertions.assertFalse(result.iterator().hasNext());

        result = instock.findFirstByAlphabeticalOrder(2);

        Assertions.assertEquals("Prod", result.iterator().next().getLabel());
    }

}
