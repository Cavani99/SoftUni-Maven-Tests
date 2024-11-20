
import IteratorTest.ListIterator;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {

    private String[] elements = {"one", "two"};

    private ListIterator iterator;

    @Before
    public void initializeTestObjects() throws OperationNotSupportedException {
        this.iterator = new ListIterator(this.elements);
    }

    @Test
    public void cannotAddNullElements(){

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            this.elements = null;
            this.iterator = new ListIterator(this.elements);
        });
    }

    @Test
    public void moveToNextIndex(){
        Assertions.assertTrue(this.iterator.hasNext());
        Assertions.assertTrue(this.iterator.move());

        Assertions.assertFalse(this.iterator.hasNext());
        Assertions.assertFalse(this.iterator.move());
    }


    @Test
    public void printFromCurrentIndex(){
        Assertions.assertEquals("one", this.iterator.print());
        Assertions.assertTrue(this.iterator.move());

        Assertions.assertEquals("two", this.iterator.print());
    }

    @Test
    public void cannotPrintEmptyIterator() throws OperationNotSupportedException {
        this.iterator = new ListIterator();

        Assertions.assertThrows(IllegalStateException.class, () -> {
            this.iterator.print();
        });
    }

}
