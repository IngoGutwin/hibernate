import de.hibernate.Person;
import de.hibernate.PersonHandler;
import org.junit.jupiter.api.Test;

public class PersonHandlerTest {
    private final PersonHandler handler = new PersonHandler();
    @Test
    public void addPersonTest() {
        handler.addPerson( new Person("Ingo", "Gutwin", 39));
    }

    @Test
    public void addAndShowPersonsTest () {
        Person person = handler.addPerson( "Meike", "Mura", 29);
        System.out.println(handler.getPerson(person.getId()));
    }

}
