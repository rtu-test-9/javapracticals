import java.util.function.Predicate;
import java.lang.NumberFormatException;

class Pin implements Predicate
{
    @Override
    public boolean test(Object t) {
        String temp = t.toString();
        if (temp.length() == 4 || temp.length() == 6)
        {
            try
            {
                Integer.parseInt(temp);
                return true;
            }
            catch (NumberFormatException e)
            {
                return false;
            }
        }
        else return false;
    }
}

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        Pin checker = new Pin();
        System.out.println(checker.test(3453));
        System.out.println(checker.test(34253));
        System.out.println(checker.test(343253));
        System.out.println(checker.test("34a253"));

    }
}
