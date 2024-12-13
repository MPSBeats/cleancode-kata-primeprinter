package com.cleancode.knuth;

public class PrimePrinterHelper {

    private final int numberOfNumbers;
    private final int[] numbers;
    private final int ordmax = 30;
    private final int[] multiples = new int[ordmax + 1];
    private int candidate = 1;
    private int primeIndex = 1;
    private boolean possiblyPrime;
    private int ord = 2;
    private int square = 9;
    private int n = 0;

    public PrimePrinterHelper(int numberOfNumbers) {
        this.numberOfNumbers = numberOfNumbers;
        this.numbers = new int[numberOfNumbers + 1];
    }

    public int[] generatePrimes() {
        numbers[1] = 2;

        while (primeIndex < numberOfNumbers) {
            do {
                candidate += 2;
                if (candidate == square) {
                    ord++;
                    square = numbers[ord] * numbers[ord];
                    multiples[ord - 1] = candidate;
                }
                n = 2;
                possiblyPrime = true;
                while (n < ord && possiblyPrime) {
                    while (multiples[n] < candidate)
                        multiples[n] += numbers[n] + numbers[n];
                    if (multiples[n] == candidate)
                        possiblyPrime = false;
                    n++;
                }
            } while (!possiblyPrime);
            primeIndex++;
            numbers[primeIndex] = candidate;
        }

        return numbers;
    }
}