package fr.xebia.xke.java8.step2;

import fr.xebia.xke.java8.data.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicCollectionOperations {

    public static void resetPassword(List<User> users) {
        //TODO :Refactor with forEach

        users.forEach(user -> user.password = null);
    }

    public static void removeExpiredUsers(List<User> users) {
        //TODO :Refactor with removeIf , use method reference

        users.removeIf(User::isExpired);
    }

    public static void addOneDayToDates(List<LocalDate> localDates) {
        //TODO :Refactor with replaceAll

        localDates.replaceAll(date -> date.plusDays(1));
    }

    public static Map<String, Integer> countWord(List<String> words) {
        //TODO :Refactor Map computation with merge and you can eventually change loop by forEach method
        Map<String, Integer> count = new HashMap<>();

        words.forEach(word -> count.merge(word, 1, (oldValue, newValue) -> oldValue + newValue));

        return count;
    }

    private static Map<Integer, Long> fibonacciValues = new HashMap<>();

    static {
        fibonacciValues.put(0, 0L);
        fibonacciValues.put(1, 1L);
        fibonacciValues.put(2, 1L);
    }

    public static List<Long> fibonacci(int expectedNumberResult) {
        //TODO: Unit test for fibonacci(45) is very slow. Optimize with fibonacciValues map and computeIfAbsent

        List<Long> result = new ArrayList<>(expectedNumberResult);

        for (int i = 1; i <= expectedNumberResult; i++) {

            result.add(fibonacciComputation(i));
        }
        return result;
    }

    private static long fibonacciComputation(int number) {
        return fibonacciValues.computeIfAbsent(number, newNumber -> fibonacciComputation(newNumber - 1) + fibonacciComputation(newNumber - 2));
    }

}
