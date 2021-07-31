package bst;

/**
 * This is a non-empty node in a binary search tree. It contains the object data and the rest of the
 * tree.
 * @param <T> the type of element in the tree
 */
public class ElementNode<T extends Comparable<T>> implements GenericTreeNode<T> {
  private final T object;
  private GenericTreeNode<T> rightNode;
  private GenericTreeNode<T> leftNode;

  /**
   * Constructor.
   * @param object the element of this node.
   */
  public ElementNode(T object) {
    this.object = object;
    rightNode = new EmptyNode<>();
    leftNode = new EmptyNode<>();
  }

  @Override
  public GenericTreeNode<T> add(T data) {
    if (data.compareTo(this.object) < 0) {
      leftNode = leftNode.add(data);
    } else if (data.compareTo(this.object) > 0) {
      rightNode = rightNode.add(data);
    }
    return this;
  }

  @Override
  public int size() {
    int left = 1 + leftNode.size();
    int right = 1 + rightNode.size();
    return (left + right) - 1;
  }

  @Override
  public int height() {
    int left = 1 + leftNode.height();
    int right = 1 + rightNode.height();
    return Math.max(left, right);
  }

  @Override
  public boolean present(T data) {
    if (data.compareTo(this.object) == 0) {
      return true;
    } else if (data.compareTo(this.object) < 0) {
      return leftNode.present(data);
    } else {
      return rightNode.present(data);
    }
  }

  @Override
  public T minimum() {
    T min = leftNode.minimum();
    if (min != null) {
      return min;
    }
    return this.object;
  }

  @Override
  public T maximum() {
    T max = rightNode.maximum();
    if (max != null) {
      return max;
    }
    return this.object;
  }

  @Override
  public String preOrder() {
    String orderString = this.object.toString();
    String left = this.leftNode.preOrder();
    if (left.length() > 0) {
      orderString = orderString + " " + left;
    }
    String right = this.rightNode.preOrder();
    if (right.length() > 0) {
      return orderString + " " + right;
    }

    return orderString;
  }

  @Override
  public String inOrder() {
    String orderString = "";
    String left = this.leftNode.inOrder();
    if (left.length() > 0) {
      orderString = orderString + left + " ";
    }
    orderString = orderString + this.object.toString();

    String right = this.rightNode.inOrder();
    if (right.length() > 0) {
      return orderString + " " + right;
    }

    return orderString;
  }

  @Override
  public String postOrder() {
    String orderString = "";
    String left = this.leftNode.postOrder();
    if (left.length() > 0) {
      orderString = orderString + left + " ";
    }

    String right = this.rightNode.postOrder();
    if (right.length() > 0) {
      orderString = orderString + right + " ";
    }

    orderString = orderString + this.object.toString();

    return orderString;
  }

  @Override
  public String toString() {
    return inOrder();
  }
}