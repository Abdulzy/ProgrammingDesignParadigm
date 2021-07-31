import lookandsay.LookAndSayIterator;
import lookandsay.RIterator;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Testing the LookAndSayIterator class.
 */
public class LookAndSayIteratorTest {
  public RIterator<BigInteger> basic;
  public RIterator<BigInteger> seed;
  public RIterator<BigInteger> complete;

  @Before
  public void setUp() {
    basic = new LookAndSayIterator();
    seed = new LookAndSayIterator(BigInteger.valueOf(1738));
    complete = new LookAndSayIterator(BigInteger.valueOf(1738), BigInteger.valueOf(17385945));
  }

  /**
   * Testing the constructor and toString.
   */
  @Test
  public void basicConstructor() {
    RIterator<BigInteger> second = new LookAndSayIterator();
    assertEquals("Seed : 1 with End Value: 999999999999999999999999999999999"
            + "9999999999999999999999999999999"
            + "999999999999999999999999999999999999", second.toString());
  }

  /**
   * Testing the constructor and toString.
   */
  @Test
  public void seedConstructor() {
    RIterator<BigInteger> second = new LookAndSayIterator(BigInteger.valueOf(1738));
    assertEquals("Seed : 1738 with End Value: 999999999999999999999999999999999"
            + "99999999999999999999999999999999"
            + "99999999999999999999999999999999999", second.toString());
  }

  /**
   * Testing the constructor and toString.
   */
  @Test
  public void completeConstructor() {
    RIterator<BigInteger> second =
            new LookAndSayIterator(BigInteger.valueOf(1738), BigInteger.valueOf(17385945));
    assertEquals("Seed : 1738 with End Value: 17385945", second.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void containZeroConstructor() {
    basic = new LookAndSayIterator(BigInteger.valueOf(1708));
  }

  @Test(expected = IllegalArgumentException.class)
  public void containZeroConstructorTwo() {
    basic = new LookAndSayIterator(BigInteger.valueOf(1708), BigInteger.valueOf(17385945));
  }

  @Test(expected = IllegalArgumentException.class)
  public void nonPositiveConstructor() {
    basic = new LookAndSayIterator(BigInteger.valueOf(-1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void nonPositiveConstructorTwo() {
    basic = new LookAndSayIterator(BigInteger.valueOf(-1), BigInteger.valueOf(17385945));
  }

  @Test(expected = IllegalArgumentException.class)
  public void largerThanEndConstructor() {
    basic = new LookAndSayIterator(BigInteger.valueOf(67385945), BigInteger.valueOf(17385945));
  }

  @Test
  public void trueHasPrevious() {
    basic = new LookAndSayIterator(BigInteger.valueOf(1738));
    assertTrue(basic.hasPrevious());
  }

  @Test
  public void falseHasPrevious() {
    basic = new LookAndSayIterator(BigInteger.valueOf(178));
    assertFalse(basic.hasPrevious());
  }

  @Test
  public void falseHasPreviousTwo() {
    basic = new LookAndSayIterator();
    assertFalse(basic.hasPrevious());
  }

  @Test
  public void prev() {
    basic = new LookAndSayIterator(BigInteger.valueOf(1738));
    assertEquals(BigInteger.valueOf(7888), basic.prev());
  }

  @Test
  public void applyPrevAndNext() {
    assertEquals(BigInteger.valueOf(1), basic.next());
    assertEquals(BigInteger.valueOf(11), basic.next());
    assertEquals(BigInteger.valueOf(21), basic.next());
    assertEquals(BigInteger.valueOf(1211), basic.next());
    assertEquals(BigInteger.valueOf(21), basic.prev());
    assertEquals(BigInteger.valueOf(11), basic.prev());
    assertEquals(BigInteger.valueOf(1), basic.prev());
  }

  @Test(expected = NoSuchElementException.class)
  public void failedPrev() {
    basic = new LookAndSayIterator(BigInteger.valueOf(178));
    basic.prev();
  }

  @Test(expected = NoSuchElementException.class)
  public void failedPrevTwo() {
    basic = new LookAndSayIterator();
    basic.prev();
  }

  @Test
  public void trueHasNext() {
    basic = new LookAndSayIterator();
    assertTrue(basic.hasNext());
  }

  @Test
  public void trueHasNextTwo() {
    basic = new LookAndSayIterator(BigInteger.valueOf(178));
    assertTrue(basic.hasNext());
  }

  @Test
  public void next() {
    basic = new LookAndSayIterator();
    assertEquals(BigInteger.valueOf(1), basic.next());
  }

  @Test
  public void nextTwo() {
    basic = new LookAndSayIterator(BigInteger.valueOf(1788));
    assertEquals(BigInteger.valueOf(1788), basic.next());
  }
}