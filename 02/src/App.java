import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import java.lang.Math;

class Compare_Surnames implements Comparator <Human>
{
    public int compare(Human man1, Human man2)
    {
        String first = man1.getLastName();
        String second = man2.getLastName();
        int i = 0;
        while (true)
        {
            if (((int)(first.toCharArray()[i])) > ((int)(second.toCharArray()[i]))) 
            {
                return -1;
            }
            else if (((int)(first.toCharArray()[i])) == ((int)(second.toCharArray()[i])))
            {
                i++;
                continue;
            }
            else return 1;
        }
    }
}

class Human
{
    private int age;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private int weight;

    public Human (String firstName, String lastName, LocalDate birthDate, int weight)
    {
        this.age = LocalDate.now().getDayOfYear() > birthDate.getDayOfYear() ? LocalDate.now().getYear() - birthDate.getYear() : LocalDate.now().getYear() - birthDate.getYear() - 1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    @Override
    public String toString()
    {
        return "firstName@" + this.firstName + " " + "lastName@" + this.lastName + " " + "birthDate@" + this.birthDate.toString() + " " + "weight@" + this.weight + " age@" + this.age;
    }

    public int getAge() {return this.age;}
    public String getFirstName() {return this.firstName;}
    public String getLastName() {return this.lastName;}
    public int getWeight() {return this.weight;}
    public LocalDate getBirthDate() {return this.birthDate;}
}

public class App {

    static int get_random(int max, int min)
    {
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

    public static void main(String[] args) 
    {
        List <Human> people = new ArrayList<>();
        int weight;
        for (int i = 0; i < 10; i++)
        {
            String firstName = "";
            String lastName = "";
            LocalDate birthDate;
            while (true)
            {
                try
                {
                    birthDate = LocalDate.of(App.get_random(1000, 2021), App.get_random(1, 12), App.get_random(1, 31));
                    break;
                }
                catch (DateTimeException e)
                {
                    birthDate = LocalDate.of(App.get_random(1900, 2021), App.get_random(1, 12), App.get_random(1, 31));
                }
            }
            for (int j = 0; j < 5; j++)
            {
                firstName += (char)App.get_random(90, 65);
                lastName += (char)App.get_random(90, 65);
            }
            weight = (int)App.get_random(30, 150);
            people.add(new Human(firstName, lastName, birthDate, weight));
        }

        Stream <Human> start_stream = people.stream();
        System.out.println("Stream before operations: ");
        start_stream.forEach(System.out::println);

        Stream <Human> stream_for_sort = people.stream();
        Stream <Human> stream_for_filter = people.stream();
        Stream <Human> stream_for_count = people.stream();
        System.out.println("\n\nStream after filtration: ");
        stream_for_filter.filter(man -> man.getWeight() > man.getAge()).forEachOrdered(System.out::println);
        System.out.println("\n\nStream after sorting:");
        stream_for_sort.sorted(new Compare_Surnames()).forEachOrdered(System.out::println);
        
        System.out.print("\n\nTotal weight of that people: " + stream_for_count.reduce(0, (subSum, element)-> subSum + element.getWeight(), Integer::sum));
    }
}
