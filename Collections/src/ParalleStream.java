import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParalleStream {
    public static void main(String[] args) {

        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(50000).toList();

        //Sequential stream
        long startTime = System.currentTimeMillis();
        List<Integer> list1 = list.stream().map(ParalleStream::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken for sequential stream : "+(endTime-startTime));

        //Paralel stream
        startTime = System.currentTimeMillis();
        List<Integer> list2 = list.parallelStream().map(ParalleStream::factorial).toList();
        endTime = System.currentTimeMillis();
        System.out.println("Total time taken for parallel stream : "+(endTime-startTime));

        // Cumulative sum
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
        AtomicInteger sum = new AtomicInteger(0);
        System.out.println("First"+nums.stream().map(x->sum.addAndGet(x)).toList());
        sum.set(0);
        System.out.println("Second"+nums.stream().map(sum::addAndGet).toList());

    }

    public static int factorial(int a){
        if(a==1) return 1;

        return a*a-1;
    }
}
