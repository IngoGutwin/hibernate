import de.hibernate.database.Person;
import de.hibernate.database.PersonHandler;
import org.junit.jupiter.api.Test;

public class FrontendTest {
    private final PersonHandler handler = new PersonHandler();

    @Test
    public void getAll() {
        for(Person person : handler.getAll()) {
            System.out.println(person);
        }
    }
}
