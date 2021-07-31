import bignumber.ListOfNumbers;

import static org.junit.Assert.assertEquals;

import bignumber.Node;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the ListOfInteger Implementation for correctness.
 */
public class NodeTest {
  private ListOfNumbers listOfNumbers;
  private ListOfNumbers node;

  @Before
  public void setUp() throws Exception {
    listOfNumbers = new Node(3, new Node(2, new Node(4,
            new Node(1, new Node(1, null)))));
    node = new Node(1, null);
  }

  @Test
  public void count() {
    assertEquals(5, listOfNumbers.count());
  }

  @Test
  public void testAdd() {
    node.addDataToEnd(2);
    node.addDataToEnd(3);
    node.addDataToEnd(4);
    assertEquals("1234", node.toString());
  }

  @Test
  public void testRemoveLastNode() {
    ListOfNumbers listOf = new Node(3, new Node(2,null));
    listOf.removeLastNode();
    listOfNumbers.removeLastNode();
    node.removeLastNode();
    assertEquals("0", node.toString());
    assertEquals("3", listOf.toString());
    assertEquals("3241", listOfNumbers.toString());
  }

  @Test
  public void testGetDataAtIndex() {
    assertEquals(4, listOfNumbers.getData(2));
  }

  @Test
  public void testGetIntData() {
    assertEquals(3, listOfNumbers.getIntData());
  }

  @Test(expected = java.lang.IllegalArgumentException.class)
  public void testIllegalGetData() {
    assertEquals(0, listOfNumbers.getData(5));
  }

  @Test(expected = java.lang.IllegalArgumentException.class)
  public void testIllegalGetDataNegative() {
    assertEquals(0, listOfNumbers.getData(-1));
  }

  @Test
  public void testAddNumber() {
    listOfNumbers.add(9);
    assertEquals("32420", listOfNumbers.toString());
  }

  @Test
  public void testToString() {
    ListOfNumbers val = new Node(1, new Node(5, new Node(6, new Node(7, new Node(8, null)))));
    assertEquals("15678", val.toString());
  }

  @Test
  public void testEmptyToString() {
    ListOfNumbers val = new Node(0, new Node(0, new Node(0, new Node(0, new Node(0, null)))));
    assertEquals("0", val.toString());
  }
}
