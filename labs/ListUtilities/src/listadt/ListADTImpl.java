package listadt;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * This is the implementation of a generic list. Specifically it implements the
 * listadt.ListADT interface
 * 
 * @param <T> the type of element in this list
 */
public class ListADTImpl<T> implements ListADT<T> {
  private GenericListAdtNode<T> head;

  /** Default constructor. */
  public ListADTImpl() {
    head = new GenericEmptyNode<>();
  }

  /**
   * A private constructor that is used internally (see map).
   * 
   * @param head the head of this list
   */
  private ListADTImpl(GenericListAdtNode<T> head) {
    this.head = head;
  }

  @Override
  public void addFront(T b) {
    head = head.addFront(b);
  }

  @Override
  public void addBack(T b) {
    head = head.addBack(b);
  }

  @Override
  public void add(int index, T b) {
    head = head.add(index, b);
  }

  @Override
  public int getSize() {
    return head.count();
  }

  @Override
  public void remove(T b) {
    head = head.remove(b);
  }

  @Override
  public T get(int index) throws IllegalArgumentException {
    if ((index >= 0) && (index < getSize())) {
      return head.get(index);
    } else {
      throw new IllegalArgumentException("Invalid index");
    }
  }

  @Override
  public <R> ListADT<R> map(Function<T, R> converter) {
    return new ListADTImpl<>(head.map(converter));
  }

  @Override
  public ListADT<T> filter(Predicate predicate) {
    return new ListADTImpl<>(head.filter(predicate));
  }

  @Override
  public T fold(T identity, BinaryOperator<T> accumulator) {
    return head.fold(identity,accumulator);
  }

  GenericListAdtNode<T> getHead() {
    return head;
  }

  void setHead(GenericListAdtNode<T> head) {
    this.head = head;
  }

  @Override
  public String toString() {
    return "(" + head.toString() + ")";
  }
}
