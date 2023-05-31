import de.hibernate.Person;
import de.hibernate.PersonHandler;
import org.junit.jupiter.api.Test;

public class PersonHandlerTest {
    private final PersonHandler handler = new PersonHandler();
    @Test
    public void addPersonTest() {
        for (int i = 1; i < 40; i++) {
            Person person = new Person("Ingo"+i, "Gutwin"+i, 38);
            handler.addPerson(person);
            System.out.println(person.getId());
        }
    }

    @Test
    public void getAll() {
        for(Person person : handler.getAll()) {
            System.out.println(person);
        }
    }

}
