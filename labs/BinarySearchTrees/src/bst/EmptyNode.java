package bst;

/**
 * This represents an empty node of the binary search tree implementation.
 * @param <T> the type of element in this node
 */
public class EmptyNode<T extends Comparable<T>> implements GenericTreeNode<T> {

  @Override
  public GenericTreeNode<T> add(T data) {
    return new ElementNode<T>(data);
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public int height() {
    return 0;
  }

  @Override
  public boolean present(T data) {
    return false;
  }

  @Override
  public T minimum() {
    return null;
  }

  @Override
  public T maximum() {
    return null;
  }

  @Override
  public String preOrder() {
    return "";
  }

  @Override
  public String inOrder() {
    return preOrder();
  }

  @Override
  public String postOrder() {
    return preOrder();
  }
}