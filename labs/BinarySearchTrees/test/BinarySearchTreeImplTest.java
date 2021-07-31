import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import bst.BinarySearchTree;
import bst.BinarySearchTreeImpl;


/**
 * Tests the binary search tree implementation.
 */
public class BinarySearchTreeImplTest {

  public BinarySearchTree<Integer> bst;
  public BinarySearchTree<Integer> tree;

  @Before
  public void setUp() {
    bst = new BinarySearchTreeImpl<>();
    bst.add(4);
    bst.add(6);
    bst.add(2);
    bst.add(1);
    bst.add(3);
    bst.add(5);
    bst.add(7);
    tree = new BinarySearchTreeImpl<>();
    tree.add(6);
    tree.add(4);
    tree.add(2);
    tree.add(1);
    tree.add(3);
    tree.add(5);
    tree.add(7);
  }

  @Test
  public void add() {
    bst = new BinarySearchTreeImpl<>();
    bst.add(4);
    bst.add(6);
    bst.add(2);
    bst.add(1);
    bst.add(3);
    bst.add(5);
    bst.add(7);
    assertEquals("[1 2 3 4 5 6 7]", bst.toString());
  }

  @Test
  public void duplicateAdd() {
    bst = new BinarySearchTreeImpl<>();
    bst.add(4);
    bst.add(6);
    bst.add(2);
    bst.add(1);
    bst.add(3);
    bst.add(5);
    bst.add(7);
    assertEquals("[1 2 3 4 5 6 7]", bst.toString());
    bst.add(7);
    assertEquals("[1 2 3 4 5 6 7]", bst.toString());
  }

  @Test(expected = NullPointerException.class)
  public void addNull() {
    BinarySearchTree<Integer> nothing = new BinarySearchTreeImpl<>();
    nothing.add(1);
    nothing.add(null);
    assertEquals("[10 20 30 40 50 60 70]", bst.toString());
  }

  @Test
  public void leftAdd() {
    BinarySearchTree<Integer> left = new BinarySearchTreeImpl<>();
    left.add(6);
    left.add(5);
    left.add(4);
    left.add(3);
    left.add(2);
    left.add(1);
    assertEquals("[1 2 3 4 5 6]", left.postOrder());
  }

  @Test
  public void rightAdd() {
    BinarySearchTree<Integer> left = new BinarySearchTreeImpl<>();
    left.add(1);
    left.add(2);
    left.add(3);
    left.add(4);
    left.add(5);
    left.add(6);
    assertEquals("[1 2 3 4 5 6]", left.preOrder());
  }

  @Test
  public void size() {
    assertEquals(7, bst.size());
  }

  @Test
  public void leftSize() {
    BinarySearchTree<Integer> left = new BinarySearchTreeImpl<>();
    left.add(6);
    left.add(5);
    left.add(4);
    left.add(3);
    left.add(2);
    left.add(1);
    assertEquals(6, left.size());
  }

  @Test
  public void rightSize() {
    BinarySearchTree<Integer> left = new BinarySearchTreeImpl<>();
    left.add(1);
    left.add(2);
    left.add(3);
    left.add(4);
    left.add(5);
    left.add(6);
    assertEquals(6, left.size());
  }

  @Test
  public void emptySize() {
    BinarySearchTree<Integer> nothing;
    nothing = new BinarySearchTreeImpl<>();
    assertEquals(0,nothing.size());
  }

  @Test
  public void height() {
    assertEquals(3, bst.height());
  }

  @Test
  public void leftHeight() {
    BinarySearchTree<Integer> left = new BinarySearchTreeImpl<>();
    left.add(6);
    left.add(5);
    left.add(4);
    left.add(3);
    left.add(2);
    left.add(1);
    assertEquals(6, left.height());
  }

  @Test
  public void rightHeight() {
    BinarySearchTree<Integer> left = new BinarySearchTreeImpl<>();
    left.add(1);
    left.add(2);
    left.add(3);
    left.add(4);
    left.add(5);
    left.add(6);
    assertEquals(6, left.height());
  }

  @Test
  public void emptyHeight() {
    BinarySearchTree<Integer> nothing;
    nothing = new BinarySearchTreeImpl<>();
    assertEquals(0,nothing.height());
  }

  @Test
  public void present() {
    assertTrue(bst.present(5));
  }

  @Test
  public void leftPresent() {
    BinarySearchTree<Integer> left = new BinarySearchTreeImpl<>();
    left.add(6);
    left.add(5);
    left.add(4);
    left.add(3);
    left.add(2);
    left.add(1);
    assertTrue(left.present(5));
  }

  @Test
  public void rightPresent() {
    BinarySearchTree<Integer> left = new BinarySearchTreeImpl<>();
    left.add(1);
    left.add(2);
    left.add(3);
    left.add(4);
    left.add(5);
    left.add(6);
    assertTrue(left.present(5));
  }

  @Test
  public void notPresent() {
    assertFalse(bst.present(13));
  }

  @Test
  public void emptyPresent() {
    BinarySearchTree<Integer> nothing = new BinarySearchTreeImpl<>();
    assertFalse(nothing.present(13));
  }

  @Test(expected = NullPointerException.class)
  public void presentNull() {
    BinarySearchTree<Integer> nothing = new BinarySearchTreeImpl<>();
    nothing.add(1);
    assertFalse(bst.present(null));
  }

  @Test
  public void minimum() {
    assertEquals(Integer.valueOf(1), bst.minimum());
  }

  @Test
  public void leftMinimum() {
    BinarySearchTree<Integer> left = new BinarySearchTreeImpl<>();
    left.add(6);
    left.add(5);
    left.add(4);
    left.add(3);
    left.add(2);
    left.add(1);
    assertEquals(Integer.valueOf(1), left.minimum());
  }

  @Test
  public void rightMinimum() {
    BinarySearchTree<Integer> left = new BinarySearchTreeImpl<>();
    left.add(1);
    left.add(2);
    left.add(3);
    left.add(4);
    left.add(5);
    left.add(6);
    assertEquals(Integer.valueOf(1), left.minimum());
  }

  @Test
  public void nullMinimum() {
    BinarySearchTree<Integer> notThere;
    notThere = new BinarySearchTreeImpl<>();
    assertNull(notThere.minimum());
  }


  @Test
  public void maximum() {
    assertEquals(Integer.valueOf(7), bst.maximum());
  }

  @Test
  public void leftMaximum() {
    BinarySearchTree<Integer> left = new BinarySearchTreeImpl<>();
    left.add(6);
    left.add(5);
    left.add(4);
    left.add(3);
    left.add(2);
    left.add(1);
    assertEquals(Integer.valueOf(6), left.maximum());
  }

  @Test
  public void rightMaximum() {
    BinarySearchTree<Integer> left = new BinarySearchTreeImpl<>();
    left.add(1);
    left.add(2);
    left.add(3);
    left.add(4);
    left.add(5);
    left.add(6);
    assertEquals(Integer.valueOf(6), left.maximum());
  }

  @Test
  public void nullMaximum() {
    BinarySearchTree<Integer> notThere;
    notThere = new BinarySearchTreeImpl<>();
    assertNull(notThere.maximum());
  }

  @Test
  public void preOrder() {
    assertEquals("[4 2 1 3 6 5 7]", bst.preOrder());
    assertEquals("[6 4 2 1 3 5 7]", tree.preOrder());
    assertEquals(tree.inOrder(), bst.inOrder());
  }

  @Test
  public void emptyPreOrder() {
    BinarySearchTree<Integer> nothing;
    nothing = new BinarySearchTreeImpl<>();
    assertEquals("[]",nothing.preOrder());
  }

  @Test
  public void inOrder() {
    assertEquals("[1 2 3 4 5 6 7]", bst.inOrder());
    assertEquals("[1 2 3 4 5 6 7]", tree.inOrder());
    assertNotEquals(tree.postOrder(), bst.postOrder());
  }

  @Test
  public void emptyInOrder() {
    BinarySearchTree<Integer> nothing;
    nothing = new BinarySearchTreeImpl<>();
    assertEquals("[]",nothing.inOrder());
  }

  @Test
  public void postOrder() {
    assertEquals("[1 3 2 5 7 6 4]", bst.postOrder());
    assertEquals("[1 3 2 5 4 7 6]", tree.postOrder());
    assertEquals(tree.inOrder(), bst.inOrder());
  }

  @Test
  public void emptyPostOrder() {
    BinarySearchTree<Integer> nothing;
    nothing = new BinarySearchTreeImpl<>();
    assertEquals("[]",nothing.postOrder());
  }

  @Test
  public void testToString() {
    assertEquals("[1 2 3 4 5 6 7]", bst.toString());
  }
}