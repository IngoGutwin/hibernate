import de.hibernate.Person;
import de.hibernate.PersonHandler;
import org.junit.jupiter.api.Test;

public class PersonHandlerTest {
    private final PersonHandler handler = new PersonHandler();
    @Test
    public void addPersonTest() {
        for (int i = 1; i < 10; i++) {
            Person person = new Person("Ingo"+i, "Gutwin"+i, 38);
            handler.addPerson(person);
            System.out.println(person.getId());
        }
    }

    @Test
    public void runTest() {
        for (int i = 0; i < 5; i++) {
            this.addPersonTest();
        }
    }

}
