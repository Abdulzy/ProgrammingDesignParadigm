package lookandsay;

import java.math.BigInteger;
import java.util.NoSuchElementException;

/**
 * Represents a class that can produce its next and prev values based on the look say algorithm.
 */
public class LookAndSayIterator implements RIterator<BigInteger> {
  private final BigInteger endValue;
  private BigInteger seed;
  private BigInteger temporarySeed;

  /**
   * Initializes fields with the provided values.
   * @param seed the starting value.
   * @param endValue the end value.
   * @throws IllegalArgumentException if the seed is  a non-positive or if the seed is
   *        greater than the end value. Through the helper method called checkUp.
   */
  public LookAndSayIterator(BigInteger seed, BigInteger endValue) throws IllegalArgumentException {
    if (!checkUp(seed, endValue)) {
      throw new IllegalArgumentException("Big integer must be positive and it must "
              + "not be greater than end value");
    }
    this.seed = seed;
    this.endValue = endValue;
    this.temporarySeed = seed;
  }

  /**
   * Initializes fields with the provided values.
   * @param seed the starting value.
   * @throws IllegalArgumentException if the seed is equal to or less than zero or if the seed is
   *        greater than the end value. Through the helper method called checkUp.
   */
  public LookAndSayIterator(BigInteger seed) throws IllegalArgumentException {
    this.endValue = bigIntegerGenerator(BigInteger.valueOf(9));
    if (!checkUp(seed, endValue)) {
      throw new IllegalArgumentException("Big integer must be positive and it must "
              + "not be greater than end value");
    }
    this.seed = seed;
    this.temporarySeed = seed;
  }

  /**
   * Default Constructor.
   */
  public LookAndSayIterator() {
    this.seed = BigInteger.valueOf(1);
    this.endValue = bigIntegerGenerator(BigInteger.valueOf(9));
    this.temporarySeed = seed;
  }

  @Override
  public boolean hasPrevious() {
    int remainder = temporarySeed.toString().length() % 2;
    return remainder == 0;
  }

  @Override
  public BigInteger prev() throws NoSuchElementException {
    if (!hasPrevious()) {
      throw new NoSuchElementException("no prev");
    }
    StringBuilder prevBigInteger = new StringBuilder();
    char[] number = temporarySeed.toString().toCharArray();
    for (int i = 0; i < number.length; i = i + 2) {
      String value =
              String.valueOf(number[i + 1]).repeat(Integer.parseInt(String.valueOf(number[i])));
      prevBigInteger.append(value);
    }
    seed = temporarySeed;
    temporarySeed = new BigInteger(prevBigInteger.toString());
    return temporarySeed;
  }

  @Override
  public boolean hasNext() {
    return (seed.compareTo(endValue) <= 0);
  }

  @Override
  public BigInteger next() {
    if (!hasNext()) {
      throw new NoSuchElementException("no next");
    }
    temporarySeed = seed;
    StringBuilder nextBigInteger = new StringBuilder();
    char currentNumber = seed.toString().charAt(0);
    String number = seed.toString().substring(1) + " ";
    int amount = 1;
    for (char actual : number.toCharArray()) {
      if (actual != currentNumber) {
        nextBigInteger.append(amount).append(currentNumber);
        amount = 1;
        currentNumber = actual;
      } else {
        amount += 1;
      }
    }
    seed = new BigInteger(nextBigInteger.toString());
    return temporarySeed;
  }

  @Override
  public String toString() {
    return String.format("Seed : %s with End Value: %s", seed, endValue);
  }

  /**
   * Generates a Big number of repeated values.
   *
   * @param number the number that will be repeated in the big number.
   * @return the generated big number.
   */
  private BigInteger bigIntegerGenerator(BigInteger number) {
    BigInteger integer = number;
    for (int i = 1; i < 100; i++) {
      integer = integer.multiply(BigInteger.valueOf(10)).add(number);
    }
    return integer;
  }

  /**
   * A helper method for checking the validity of the parameters.
   * @param seed     the starting value.
   * @param endValue the end value.
   * @return true or false
   */
  private boolean checkUp(BigInteger seed, BigInteger endValue) {
    if (!(seed.toString().matches("[1-9]+"))) {
      return false;
    } else if (seed.compareTo(BigInteger.valueOf(0)) <= 0 | seed.compareTo(endValue) > 0) {
      return false;
    }
    return true;
  }
}