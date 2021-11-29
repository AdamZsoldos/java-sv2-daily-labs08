package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberSequence {

    private final List<Integer> numbers;

    public NumberSequence(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public NumberSequence(int countOfRandomNumbers, int minValue, int maxValue) {
        this.numbers = getRandomNumbers(countOfRandomNumbers, minValue, maxValue);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public double getAverage() {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.size();
    }

    public List<Integer> getCloseToAverage(int proximityThreshold) {
        double average = getAverage();
        List<Integer> result = new ArrayList<>();
        for (int number : numbers) {
            if (Math.abs(number - average) <= proximityThreshold) {
                result.add(number);
            }

        }
        return result;
    }

    private List<Integer> getRandomNumbers(int countOfRandomNumbers, int minValue, int maxValue) {
        Random random = new Random();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < countOfRandomNumbers; i++) {
            result.add(random.nextInt(minValue, maxValue + 1));
        }
        return result;
    }
}
