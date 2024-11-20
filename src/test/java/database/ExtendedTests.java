package database;

import Extended_Database.Database;
import Extended_Database.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import javax.naming.OperationNotSupportedException;

public class ExtendedTests {

    private Person[] people = {new Person(0, "Ivan"), new Person(2, "Stefan")};
    private Database database;
    private Person person;

    @Before
    public void initializeTestObjects() throws OperationNotSupportedException {
        this.database = new Database(this.people);
    }

    @Test
    public void personIdsAndNamesMustBeUnique(){

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            person = new Person(0, "Gogo");
            this.database.add(person);
        });

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            person = new Person(123, "Ivan");
            this.database.add(person);
        });
    }

    @Test
    public void NoNegativeOrNullIds(){

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            person = new Person(-3, "Gogo");
            this.database.add(person);
        });
    }

    @Test
    public void cannotFindUnrecognisablePersonByIdAndName(){

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            person = new Person(3, "Gogo");
            this.database.findByUsername(person.getUsername());
        });


        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            person = new Person(3, null);
            this.database.findByUsername(person.getUsername());
        });

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            person = new Person(3, "Gogo");
            this.database.findById(person.getId());
        });
    }

    @Test
    public void forbiddenEmptyDatabase(){

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            this.database = new Database();
        });

    }

}
