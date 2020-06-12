import java.util.logging.Logger;
import com.powertamil.util.DateFormatter;

public class temp {

    protected static final Logger LOG = Logger.getLogger(hworld.class.getName());



    public static void main(String args[]) {

        System.out.println("THIS IS A HELLO WORLD......!");

        String dt = DateFormatter.now();

        System.out.println(dt);
    }
}
