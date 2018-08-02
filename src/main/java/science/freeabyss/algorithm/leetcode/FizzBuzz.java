package science.freeabyss.algorithm.leetcode;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Write a program that outputs the string representation of numbers from 1 to n.
 * <p>
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 *
 * @author abyss
 * @date 2018/4/26
 */
public class FizzBuzz {
    public static List<String> solution(int n) {
        return IntStream.range(1, n + 1).mapToObj(x ->
                x % 3 == 0 ?
                        x % 5 == 0 ? "FizzBuzz" : "Fizz"
                        : x % 5 == 0 ? "Buzz" : String.valueOf(x))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int x = 1;
        System.out.println(x % 3 == 0 ?
                x % 5 == 0 ? "FizzBuzz" : "Fizz"
                : x % 5 == 0 ? "Buzz" : String.valueOf(x));
    }

    List<String> sulotion1(int n) {
        String[] ret = new String[n];

        for (int i = 1; i <= n; i++) {
            ret[i - 1] = String.valueOf(i);
        }

        for (int i = 5; i <= n; i += 5) {
            ret[i - 1] = "Buzz";
        }

        for (int i = 3; i <= n; i += 3) {
            ret[i - 1] = "Fizz";
        }
        for (int i = 15; i <= n; i += 15) {
            ret[i - 1] = "FizzBuzz";
        }
        return Arrays.asList(ret);
    }


    public static class Solution {
        private static final String FIZZ = "Fizz";
        private static final String BUZZ = "Buzz";
        private static final String FIZZBUZZ = "FizzBuzz";

        public static List<String> fizzBuzz(int n) {

            return new AbstractList<String>() {
                int size = n;

                @Override
                public String get(int index) {
                    return convert(index + 1);
                }

                @Override
                public int size() {
                    return size;
                }
            };

        }

        public static String convert(int index) {
            if (index % 15 == 0) {
                return FIZZBUZZ;
            } else if (index % 3 == 0) {
                return FIZZ;
            } else if (index % 5 == 0) {
                return BUZZ;
            }
            return Integer.toString(index);
        }
    }

}
