package fr.xebia.xke.java8.step4;


import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class NumberUtils {

    private static Map<Integer, Long> fibonacciValues = new HashMap<>();

    static {
        fibonacciValues.put(0, 0L);
        fibonacciValues.put(1, 1L);
        fibonacciValues.put(2, 1L);
    }

    /**
     * Return the 'number' random int between 0 and 'number * 10'
     *
     * @param number
     * @param seed
     * @return
     */
    public static int[] generateRandom(int number, @Nullable Long seed) {
        Random random = getRandom(seed);

        return random.ints(number, 0, number * 10).toArray();
    }

    public static Map<Boolean, List<Integer>> splitEvenAndOddNumber(int[] numbers) {

		return Arrays.stream(numbers).boxed()
				.collect(Collectors.partitioningBy(n -> (n % 2) == 0));
    }

    public static List<Long> fibonacci(int expectedNumberResult) {
    	
		return IntStream.rangeClosed(1, expectedNumberResult)
				.mapToLong(i -> fibonacciComputation(i))
				.mapToObj(l -> Long.valueOf(l)).collect(Collectors.toList());
    }

    /**
     * @return Infinite stream who return each next number of fibonacci sequence
     */
    public static Stream<Long> fibonacciStream() {
        Iterator<Long> it = LongStream.rangeClosed(1, Integer.MAX_VALUE).map(n -> fibonacciComputation((int) n)).iterator();
        
    	return Stream.generate(() -> it.next());
    }

    private static long fibonacciComputation(int number) {
        return fibonacciValues.computeIfAbsent(number, newNumber -> fibonacciComputation(newNumber - 1) + fibonacciComputation(newNumber - 2));
    }

    private static Random getRandom(Long seed) {
        if (seed == null) {
            return new Random();
        } else {
            return new Random(seed);
        }
    }
}
