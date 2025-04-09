import java.util.Arrays;
import java.util.List;

public class Streams {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5,2,7,1,3);

        List<String> name = Arrays.asList("Ram","Sham","Ankit","Rahul");

        // Names which have length greater than 4
        System.out.println(name.stream().filter(x->x.length()>4).toList());

        //Squaring and sorting
        System.out.println(list.stream().map(x->x*x).sorted().toList());

        //Summing values
        System.out.println(list.stream().reduce((x,y)->x+y).get());
        System.out.println(list.stream().reduce(Integer::sum).get());

        // Counting occurance
        String str  = "Hello World";

        System.out.println(str.toUpperCase().chars().filter(x->x=='L').count());

    }
}
