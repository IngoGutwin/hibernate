import de.hibernate.Person;
import de.hibernate.PersonHandler;
import org.junit.jupiter.api.Test;

public class PersonHandlerTest {
    private final PersonHandler handler = new PersonHandler();
    @Test
    public void addPersonTest() {
        int personID = handler.addPerson( new Person("Ingo", "Gutwin", 39));
        System.out.println(personID);
    }

    @Test
    public void addAndShowPersonsTest () {
        int personID = handler.addPerson( "Meika", "Nielsen", 29);
        System.out.println( personID );
    }

}
