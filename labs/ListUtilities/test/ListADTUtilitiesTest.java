import org.junit.Before;
import org.junit.Test;

import listadt.ListADT;
import listadt.ListADTImpl;
import listadt.ListADTUtilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests the ListAdtUtilities for correctness.
 */
public class ListADTUtilitiesTest {
  ListADT<String> list;
  ListADT<Integer> integerList;

  @Before
  public void setUp() {
    list = new ListADTImpl<String>();
    integerList = new ListADTImpl<Integer>();
  }

  @Test
  public void toList() {
    Integer[] arr = new Integer[]{1, 2, 3, 4};
    Integer[] emptyArr = new Integer[]{};

    ListADT<Integer> listAdt = ListADTUtilities.toList(arr);
    assertEquals("(1 2 3 4)", listAdt.toString());

    listAdt = ListADTUtilities.toList(emptyArr);
    assertEquals("()", listAdt.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalToList() {
    Integer[] arr = new Integer[]{1, 2, null, 4};
    ListADTUtilities.toList(arr);
  }

  @Test(expected = IllegalArgumentException.class)
  public void illegalMoreToList() {
    Integer[] arr = new Integer[]{1, 2, null, null};
    ListADTUtilities.toList(arr);
  }

  @Test
  public void addAll() {
    list.addBack("vic");
    list.addBack("bolu");
    list.addBack("chad");

    ListADTUtilities.addAll(list, "dest", "abdul");
    assertEquals("(vic bolu chad dest abdul)", list.toString());
    ListADTUtilities.addAll(list, "cow");
    assertEquals("(vic bolu chad dest abdul cow)", list.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void addAllNull() {
    list.addBack("vic");
    list.addBack("bolu");
    ListADTUtilities.addAll(list, "dest", "abdul", null, null);
  }

  @Test
  public void frequency() {
    list.addBack("vic");
    list.addBack("bolu");
    assertEquals(1, ListADTUtilities.frequency(list, "bolu"));
    assertEquals(1, ListADTUtilities.frequency(list, "vic"));
    assertEquals(0, ListADTUtilities.frequency(list, "abdul"));
    assertEquals(0, ListADTUtilities.frequency(list, null));
    list.addBack("bolu");
    list.addBack("bolu");
    assertEquals(3, ListADTUtilities.frequency(list, "bolu"));

    ListADT<String> emptyList = new ListADTImpl<String>();
    assertEquals(0, ListADTUtilities.frequency(emptyList, "bolu"));
    emptyList.addBack(null);
    emptyList.addBack("yo yo");
    emptyList.addBack("paul");
    emptyList.addBack("paul");
    emptyList.addBack("feet");
    assertEquals(2, ListADTUtilities.frequency(emptyList, "paul"));
    assertEquals(1, ListADTUtilities.frequency(emptyList, null));
    emptyList.addBack(null);
    emptyList.addBack(null);
    assertEquals(3, ListADTUtilities.frequency(emptyList, null));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullFrequency() {
    ListADTUtilities.frequency(null, "cow");
  }

  @Test
  public void disjoint() {
    ListADT<String> newList = new ListADTImpl<String>();
    newList.addBack("abdul");
    newList.addBack("bolu");
    list.addBack("vic");
    list.addBack("bolu");
    assertFalse(ListADTUtilities.disjoint(list, newList));
  }

  @Test
  public void disjointTrue() {
    ListADT<String> newList = new ListADTImpl<String>();
    newList.addBack("abdul");
    newList.addBack("john");
    list.addBack("vic");
    list.addBack("bolu");
    assertTrue(ListADTUtilities.disjoint(list, newList));
  }

  @Test
  public void disjointEmpty() {
    ListADT<String> newList = new ListADTImpl<String>();
    assertTrue(ListADTUtilities.disjoint(list, newList));
  }

  @Test
  public void disjointOneEmpty() {
    ListADT<String> newList = new ListADTImpl<String>();
    newList.addBack("abdul");
    newList.addBack("john");
    assertTrue(ListADTUtilities.disjoint(list, newList));
  }

  @Test
  public void disjointTwoEmpty() {
    ListADT<String> newList = new ListADTImpl<String>();
    newList.addBack("abdul");
    newList.addBack("john");
    assertTrue(ListADTUtilities.disjoint(list, newList));
  }

  @Test(expected = IllegalArgumentException.class)
  public void disjointIllegal() {
    assertTrue(ListADTUtilities.disjoint(list, null));
  }

  @Test(expected = IllegalArgumentException.class)
  public void disjointIllegalNull() {
    assertTrue(ListADTUtilities.disjoint(null, list));
  }

  @Test(expected = IllegalArgumentException.class)
  public void disjointNullElement() {
    ListADT<String> newList = new ListADTImpl<String>();
    newList.addBack("abdul");
    newList.addBack("john");
    newList.addBack(null);
    list.addBack("vic");
    list.addBack("bolu");
    assertTrue(ListADTUtilities.disjoint(list, newList));
  }

  @Test(expected = IllegalArgumentException.class)
  public void disjointNullElementReversed() {
    ListADT<String> newList = new ListADTImpl<String>();
    newList.addBack("abdul");
    newList.addBack("john");
    newList.addBack(null);
    list.addBack("vic");
    list.addBack("bolu");
    assertTrue(ListADTUtilities.disjoint(newList, list));
  }

  @Test(expected = IllegalArgumentException.class)
  public void disjointNullElementTwo() {
    ListADT<String> newList = new ListADTImpl<String>();
    newList.addBack("abdul");
    newList.addBack("john");
    newList.addBack("vic");
    list.addBack(null);
    list.addBack("bolu");
    assertTrue(ListADTUtilities.disjoint(list, newList));
  }

  @Test(expected = IllegalArgumentException.class)
  public void disjointNullElementTwoReversed() {
    ListADT<String> newList = new ListADTImpl<String>();
    newList.addBack("abdul");
    newList.addBack("john");
    newList.addBack("vic");
    list.addBack(null);
    list.addBack("bolu");
    assertTrue(ListADTUtilities.disjoint(newList, list));
  }

  @Test
  public void testEquals() {
    ListADT<String> newList = new ListADTImpl<String>();
    newList.addBack("abdul");
    newList.addBack("john");
    list.addBack("abdul");
    list.addBack("john");
    assertTrue(ListADTUtilities.equals(list, newList));
    assertTrue(ListADTUtilities.equals(newList, list));
  }

  @Test
  public void testEqualsDifferentOrder() {
    ListADT<String> newList = new ListADTImpl<String>();
    newList.addBack("abdul");
    newList.addBack("john");
    list.addBack("goat");
    list.addBack("cow");
    assertFalse(ListADTUtilities.equals(list, newList));
  }

  @Test
  public void testEqualsEmpty() {
    ListADT<String> newList = new ListADTImpl<String>();
    list.addBack("goat");
    list.addBack("fowl");
    assertFalse(ListADTUtilities.equals(list, newList));
  }

  @Test
  public void testEqualsTwoEmpty() {
    ListADT<String> newList = new ListADTImpl<String>();
    newList.addBack("abdul");
    newList.addBack("john");
    assertFalse(ListADTUtilities.equals(list, newList));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEqualsNull() {
    ListADT<String> newList = new ListADTImpl<String>();
    newList.addBack("abdul");
    newList.addBack("john");
    assertFalse(ListADTUtilities.equals(null, newList));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEqualsNullTwo() {
    ListADT<String> newList = new ListADTImpl<String>();
    newList.addBack("abdul");
    newList.addBack("john");
    assertFalse(ListADTUtilities.equals(list, null));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEqualsNullElement() {
    ListADT<String> newList = new ListADTImpl<String>();
    newList.addBack("abdul");
    newList.addBack("john");
    list.addBack("abdul");
    list.addBack(null);
    assertFalse(ListADTUtilities.equals(list, newList));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEqualsNullElementTwo() {
    ListADT<String> newList = new ListADTImpl<String>();
    newList.addBack("abdul");
    newList.addBack(null);
    list.addBack("abdul");
    list.addBack("john");
    assertFalse(ListADTUtilities.equals(list, newList));
  }
}