import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class StreamPreReq {
    public static void main(String[] args) {

        // Predicate - test (Returns boolean)
        // Define
        Predicate<Integer> even = x ->x%2==0;
        Predicate<String> startsWithA = a->a.toUpperCase().startsWith("A");
        Predicate<String> endsWithT = a->a.toUpperCase().endsWith("T");

        // Check both the conditions
        Predicate<String> both = startsWithA.and(endsWithT);

        // use
        System.out.println(even.test(4));
        System.out.println(both.test("Ankit"));

        // Functions - apply (Does some work)
        // Define

        Function<Integer,Integer> doubleIt = x->x*2;
        Function<Integer,Integer> tripleIt = x->x*3;

        //use
        System.out.println(doubleIt.apply(2));
        // runs dobleIt first then tripleIt
        System.out.println(doubleIt.andThen(tripleIt).apply(2));
        // runs tripleIt first  then doubleIt
        System.out.println(doubleIt.compose(tripleIt).apply(2));

        Function<Integer, Integer> identity = Function.identity();
        Integer apply = identity.apply(1);
        System.out.println(apply);

        //Consumer (accept)

        Consumer<Integer> print = x-> System.out.println(x);
        print.accept(50);

        List<Integer> list = Arrays.asList(1,2,3);
        Consumer<List<Integer>> printList = x ->{
            for (int i:x){
                System.out.println(i);
            }
        };
        printList.accept(list);


        // Supplier
        Supplier<String> hello = () ->"Hello";
        System.out.println(hello.get());

        //Works same like function
        UnaryOperator<Integer> a = x -> x+x;
        BinaryOperator<Integer> b = (x,y) -> x+y;

        // Method reference
        List<String> student = Arrays.asList("Ram","Sham");

        // normal lambda expression
        student.forEach(x-> System.out.println(x));
        // Method reference
        student.forEach(System.out::println);

        // Constructor reference
        List<String> name = Arrays.asList("A","B","C");
        List<Mobile> mobiles = name.stream().map(Mobile::new).toList();


    }
}

class Mobile{
    public Mobile(String name) {
        this.name = name;
    }

    String name;
}