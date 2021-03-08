package com.jzOffer;

public class JZ32 {
    public static void main(String[] args) {
        int[] array = new int[]{3, 32, 321};
        Solution solution = new Solution();
        String minNumber = solution.PrintMinNumber(array);
        System.out.println(minNumber);
    }

    static public class Solution {
        public String PrintMinNumber(int[] numbers) {
            for (int i = 0; i < numbers.length; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    int sum1 = Integer.parseInt(numbers[i] + "" + numbers[j]);
                    int sum2 = Integer.parseInt(numbers[j] + "" + numbers[i]);
                    if (sum1 > sum2) {
                        int temp = numbers[i];
                        numbers[i] = numbers[j];
                        numbers[j] = temp;
                    }
                }
            }

            StringBuilder str = new StringBuilder();
            for (int number : numbers) {
                str.append(number);
            }
            return str.toString();
        }
    }
}
