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
        Person person = handler.addPerson( "Meika", "Nielsen", 29);
        Person person1 = (Person) handler.getPerson(person.getId());
        System.out.println( person1.toString() );
    }

}
