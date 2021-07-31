import bignumber.BigNumber;
import bignumber.BigNumberImpl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Testing the BigNumberImp class.
 */
public class BigNumberImplTest {

  BigNumber bigNumber;
  BigNumber bigNumberWithValue;

  @Before
  public void setUp() {
    bigNumber = new BigNumberImpl();
    bigNumberWithValue = new BigNumberImpl("19933889");
  }


  @Test(expected = IllegalArgumentException.class)
  public void testIllegalConstructor() {
    new BigNumberImpl("12345.98");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalGetNumber() {
    bigNumberWithValue.getDigitAt(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOutOfRangeGetNumber() {
    bigNumberWithValue.getDigitAt(9);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOutOfRangeAdd() {
    bigNumberWithValue.addDigit(11);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeAdd() {
    bigNumberWithValue.addDigit(-1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeConstruct() {
    bigNumberWithValue = new BigNumberImpl("-19933889");
  }

  @Test
  public void length() {
    assertEquals(1, bigNumber.length());
    assertEquals(8, bigNumberWithValue.length());
  }

  @Test
  public void testConstructor() {
    assertEquals("0", bigNumber.toString());
    assertEquals("19933889", bigNumberWithValue.toString());
  }

  @Test
  public void shiftLeft() {
    bigNumberWithValue.shiftLeft(4);
    assertEquals("199338890000", bigNumberWithValue.toString());
    bigNumberWithValue.shiftLeft(-4);
    assertEquals("19933889", bigNumberWithValue.toString());
  }

  @Test
  public void shiftRight() {
    bigNumberWithValue.shiftRight(4);
    assertEquals("1993", bigNumberWithValue.toString());
    bigNumberWithValue.shiftRight(-4);
    assertEquals("19930000", bigNumberWithValue.toString());
    bigNumber.shiftRight(2);
    assertEquals("0", bigNumber.toString());
  }

  @Test
  public void shiftAndAdd() {
    bigNumberWithValue.shiftRight(4);
    assertEquals("1993", bigNumberWithValue.toString());
    bigNumberWithValue.addDigit(4);
    assertEquals("1997", bigNumberWithValue.toString());
    bigNumberWithValue.shiftRight(-4);
    assertEquals("19970000", bigNumberWithValue.toString());
    BigNumber bigNumber = new BigNumberImpl("1130000");
    bigNumberWithValue.add(bigNumber);
    assertEquals("21100000", bigNumberWithValue.add(bigNumber).toString());
  }

  @Test
  public void addDigit() {
    bigNumberWithValue.addDigit(7);
    assertEquals("19933896", bigNumberWithValue.toString());
  }

  @Test
  public void getDigitAt() {
    BigNumber bigNumberEqual = new BigNumberImpl("8439218801");
    assertEquals(0, bigNumberEqual.getDigitAt(8));
    assertEquals(9, bigNumberWithValue.getDigitAt(1));
    assertEquals(1, bigNumberWithValue.getDigitAt(0));
  }


  @Test
  public void compareTo() {
    BigNumber bigNumberEqualO = new BigNumberImpl("32411");
    BigNumber bigNumberEqual = new BigNumberImpl("32411");
    BigNumber bigNumberGreater = new BigNumberImpl("324111");
    BigNumber bigNumberSmaller = new BigNumberImpl("32311");
    assertEquals(0, bigNumberEqualO.compareTo(bigNumberEqual));
    assertEquals(-1, bigNumberEqualO.compareTo(bigNumberGreater));
    assertEquals(1, bigNumberEqualO.compareTo(bigNumberSmaller));
    assertEquals(1, bigNumberWithValue.compareTo(bigNumberSmaller));
    assertEquals(-1, bigNumberSmaller.compareTo(bigNumberEqual));
  }

  @Test
  public void copy() {
    BigNumber bigNumberEqual = bigNumberWithValue.copy();
    assertEquals("19933889", bigNumberEqual.toString());
  }

  @Test
  public void add() {
    BigNumber number = new BigNumberImpl("99999999999999999999999999999999"
            + "99999999999999999999999999999999999999999999999999999999999999999999");
    BigNumber number2 = new BigNumberImpl("999999999999999999999999"
            + "9999999999999999999999999999999999999999999999999999999999999999999999999999");
    assertEquals("19999999999999999999999999999999999999999999999999999"
            + "999999999999999999999999999999999999999999999998", number.add(number2).toString());
  }

  @Test
  public void addTwo() {
    BigNumber number = new BigNumberImpl("99999999999999999999999999999999"
            + "99999999999999999999999999999999999999999999999999999999999912345678");
    BigNumber number2 = new BigNumberImpl("999999999999999999999999"
            + "9999999999999999999999999999999999999999999999999999991234567899999999999999");
    assertEquals("1999999999999999999999999999999999999999999999999999999"
            + "9999999999999999999999991234567899999912345677", number.add(number2).toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void addNegative() {
    BigNumber number = new BigNumberImpl("-99999999999999999999999999999999"
            + "99999999999999999999999999999999999999999999999999999999999912345678");
    BigNumber number2 = new BigNumberImpl("999999999999999999999999"
            + "9999999999999999999999999999999999999999999999999999991234567899999999999999");
    assertEquals("1999999999999999999999999999999999999999999999999999999"
            + "9999999999999999999999991234567899999912345677", number.add(number2).toString());
  }
}