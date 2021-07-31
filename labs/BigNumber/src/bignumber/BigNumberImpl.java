package bignumber;

/**
 * Represents a big integer value.
 */
public class BigNumberImpl implements BigNumber {
  private ListOfNumbers longNumber;

  /**
   * Constructor initializes the big number as 0.
   */
  public BigNumberImpl() {
    longNumber = new Node(0, null);
  }

  /**
   * Constructor initializes big number with the given parameter.
   *
   * @param numberAsString the value to initialize big number.
   */
  public BigNumberImpl(String numberAsString) {
    if (numberAsString.trim().contains("-")) {
      throw new IllegalArgumentException("negative values are not allowed");
    }
    if (!numberAsString.trim().matches("\\d+")) {
      throw new IllegalArgumentException("Only numbers allowed");
    }
    createNumber(numberAsString.trim());
  }


  @Override
  public int length() {
    return longNumber.count();
  }

  @Override
  public void shiftLeft(int num) {
    if (num >= 0) {
      for (int index = 0; index < num; index++) {
        longNumber.addDataToEnd(0);
      }
    } else {
      shiftRight(Math.abs(num));
    }
  }

  @Override
  public void shiftRight(int num) {
    if (num > length()) {
      longNumber = new Node(0, null);
    } else if (num >= 0) {
      for (int index = 0; index < num; index++) {
        longNumber.removeLastNode();
      }
    } else {
      shiftLeft(Math.abs(num));
    }
  }

  @Override
  public void addDigit(int digit) {
    if (digit < 0) {
      throw new IllegalArgumentException("negative not allowed");
    }
    if (Integer.toString(digit).length() > 1) {
      throw new IllegalArgumentException("only single digits allowed");
    }
    longNumber = longNumber.add(digit);
  }

  @Override
  public int getDigitAt(int position) throws IllegalArgumentException {
    if (position < 0) {
      throw new IllegalArgumentException("Negative not allowed");
    }
    if (position >= longNumber.count()) {
      throw new IllegalArgumentException("Value is out of range");
    }

    return longNumber.getData(position);
  }

  @Override
  public BigNumber copy() {
    String copyString = this.toString();
    return new BigNumberImpl(copyString);
  }


  @Override
  public BigNumber add(BigNumber other) {
    String firstString = this.toString();
    String secondString = other.toString();
    if (firstString.length() > secondString.length()) {
      return new BigNumberImpl(this.addStr(firstString, secondString));
    }
    return new BigNumberImpl(this.addStr(secondString, firstString));
  }

  /**
   * Converts byte to char.
   * @param b byte
   * @return character
   */
  private char toChar(byte b) {
    switch (b) {
      case 1:
        return '1';
      case 2:
        return '2';
      case 3:
        return '3';
      case 4:
        return '4';
      case 5:
        return '5';
      case 6:
        return '6';
      case 7:
        return '7';
      case 8:
        return '8';
      case 9:
        return '9';
      default:
        return '0';
    }
  }

  /**
   * Adds two bigNumbers together.
   * @param lrg String of bigNumber
   * @param sml String of another bigNumber
   * @return
   */
  private String addStr(String lrg, String sml) {

    byte[] n1 = new byte[lrg.length()];
    byte[] n2 = new byte[sml.length()];

    for (int i = 0; i < lrg.length(); i++) {
      char c = lrg.charAt(i);
      byte in = (byte) Character.getNumericValue(c);
      n1[i] = in;
    }
    for (int i = 0; i < sml.length(); i++) {
      char c = sml.charAt(i);
      byte in = (byte) Character.getNumericValue(c);
      n2[i] = in;
    }
    int mx = Math.max(n1.length, n2.length);
    byte[] n3 = new byte[mx + 1];
    int r1 = n1.length - 1;
    int r2 = n2.length - 1;
    int r3 = n3.length - 1;
    byte carry = 0;

    while (r3 >= 0) {
      byte sum = carry;

      if (r1 >= 0) {
        sum += n1[r1--];
      }
      if (r2 >= 0) {
        sum += n2[r2--];
      }
      carry = (byte) (sum / 10);
      n3[r3--] = (byte) (sum % 10);
    }

    char[] cc = new char[n3.length];
    for (int b = 0; b < n3.length; b++) {
      cc[b] = toChar(n3[b]);
    }

    String ret = new String(cc);
    if (ret.charAt(0) == '0') {
      ret = ret.substring(1);
    }
    return ret;
  }

  /**
   * Compares two bigNumbers.
   * @param bigNumber another bigNumber object
   * @return comparison
   */
  @Override
  public int compareTo(BigNumber bigNumber) {
    String firstNumber = this.toString();
    String secondNumber = bigNumber.toString();
    return isBigger(firstNumber, secondNumber);
  }


  /**
   * Returns the toString of this object.
   * @return toString
   */
  @Override
  public String toString() {
    return longNumber.toString();
  }


  /**
   * Calls and initiates a helper method that recursively creates a the big number.
   *
   * @param numberAsString the string value of the number to be stored.
   */
  private void createNumber(String numberAsString) {
    helper(0, numberAsString);
  }

  /**
   * Recursively creates the big number as a linked list.
   *
   * @param index the location of the number that is being added to the list
   * @param num   the number as string
   */
  private void helper(int index, String num) {
    if (index == num.length()) {
      return;
    }
    if (index == 0) {
      char character = num.charAt(index);
      this.longNumber = new Node(character - '0', null);
    } else {
      this.longNumber.addDataToEnd(num.charAt(index) - '0');
    }
    helper(index + 1, num);

  }

  /**
   * Compares two big numbers.
   *
   * @param firstNumber  A Bignumber
   * @param secondNumber A Bignumber
   * @return comparison
   */
  private int isBigger(String firstNumber, String secondNumber) {
    if (firstNumber.length() > secondNumber.length()) {
      return 1;
    } else if (secondNumber.length() > firstNumber.length()) {
      return -1;
    } else {
      for (int index = 0; index < firstNumber.length(); index++) {
        char firstNumberCharacter = firstNumber.charAt(index);
        char secondNumberCharacter = secondNumber.charAt(index);

        if (Integer.parseInt(String.valueOf(firstNumberCharacter))
                > Integer.parseInt(String.valueOf(secondNumberCharacter))) {
          return 1;
        } else if (Integer.parseInt(String.valueOf(secondNumberCharacter))
                > Integer.parseInt(String.valueOf(firstNumberCharacter))) {
          return -1;
        }
      }
    }
    return 0;
  }
}