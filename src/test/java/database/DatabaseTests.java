package database;

import Database.Database;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import javax.naming.OperationNotSupportedException;


public class DatabaseTests {
    private static final Integer [] ELEMENTS = {
            1,2,3,4,5,6,7,8,9,10,11,12,13,14,15
    };

    private Database database;


    @Before
    public void initializeTestObjects() throws OperationNotSupportedException {
        this.database = new Database(ELEMENTS);
    }

    @Test
    public void arrayMustBe16Integers() throws OperationNotSupportedException {

        this.database.add(15);
        Assertions.assertEquals(16, this.database.getElements().length, "Elements are not 16");
        Assertions.assertEquals(Integer.class.getSimpleName(),  this.database.getElements()[0].getClass().getSimpleName());
    }

    @Test
    public void addOperationOnNextCell() throws OperationNotSupportedException {

        this.database.add(12);
        Assertions.assertEquals(12, this.database.getElements()[15], "Added element is different");

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            this.database.add(null);
        });
    }

    @Test
    public void removeOperationAtLastIndex() throws OperationNotSupportedException {

        this.database.remove();
        Assertions.assertEquals(14, this.database.getElements().length, "Element is not removed");

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            this.database.getElements()[14].equals(null);
        });

        Integer [] emptyArr = {1};
        this.database = new Database(emptyArr);
        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            this.database.remove();
            this.database.remove();
        });
    }
}
