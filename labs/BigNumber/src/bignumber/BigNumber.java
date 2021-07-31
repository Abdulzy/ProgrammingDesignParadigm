package bignumber;

/**
 * A big number representing an arbitrarily large integer.
 */
public interface BigNumber extends Comparable<BigNumber> {

  /**
   * The length of the big number.
   *
   * @return the length
   */
  int length();

  /**
   * Shifts the number of position to the left. A negative number of left-shifts will correspond to
   * those many right shifts.
   *
   * @param num the number of positions to shift
   */
  void shiftLeft(int num);

  /**
   * Shifts the number of positions to the right. The number 0 can be right-shifted any positive
   * number of times, yielding the same number, 0. A negative number of right-shifts will correspond
   * to that many left shifts.
   *
   * @param num the number of positions to shift
   */
  void shiftRight(int num);

  /**
   * Take a single digit and add it to this number.
   *
   * @param digit the number to add
   * @throws IllegalArgumentException if the digit passed to it is not a single non-negative digit
   */
  void addDigit(int digit) throws IllegalArgumentException;

  /**
   * Return the number at the given position.
   *
   * @param position the position
   * @return the number
   * @throws IllegalArgumentException if the position is invalid
   */
  int getDigitAt(int position) throws IllegalArgumentException;

  /**
   * Returns an identical and independent copy of this number.
   *
   * @return the copy
   */
  BigNumber copy();

  /**
   * Returns the sum of the current object and the parameter object. This operation does not change
   * either number.
   *
   * @param other the other number
   * @return the sum
   */
  BigNumber add(BigNumber other);
}
