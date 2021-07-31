package bst;

/**
 * This is the implementation of a generic binary search tree. Specifically it implements the
 * BinarySearchTree interface.
 *
 * @param <T> the type of element in the list.
 */
public class BinarySearchTreeImpl<T extends Comparable<T>> implements BinarySearchTree<T> {

  private GenericTreeNode<T> root;

  /** Default constructor. */
  public BinarySearchTreeImpl() {
    root = new EmptyNode<>();
  }

  @Override
  public void add(T data) {
    root = root.add(data);
  }

  @Override
  public int size() {
    return root.size();
  }

  @Override
  public int height() {
    return root.height();
  }

  @Override
  public boolean present(T data) {
    return root.present(data);
  }

  @Override
  public T minimum() {
    return root.minimum();
  }

  @Override
  public T maximum() {
    return root.maximum();
  }

  @Override
  public String preOrder() {
    return "[" + root.preOrder() + "]";
  }

  @Override
  public String inOrder() {
    return "[" + root.inOrder() + "]";
  }

  @Override
  public String postOrder() {
    return "[" + root.postOrder() + "]";
  }

  @Override
  public String toString() {
    return "[" + root.toString() + "]";
  }
}