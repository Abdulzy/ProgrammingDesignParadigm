*package bignumber;

/**
 * A class that implements a linkedList.
 */
public class Node implements ListOfNumbers {
  private int data;
  private ListOfNumbers next;

  public Node(int data, ListOfNumbers rest) {
    this.data = data;
    this.next = rest;
  }

  @Override
  public int count() {
    return countHelp(0);
  }

  @Override
  public int countHelp(int accumulator) {
    if (this.next == null) {
      return accumulator + 1;
    }
    return this.next.countHelp(1 + accumulator);
  }

  @Override
  public void addDataToEnd(int data) {
    ListOfNumbers tempNode = new Node(data, null);
    addHelper(tempNode);

  }

  @Override
  public void addHelper(ListOfNumbers toAdd) {
    if (this.getNext() == null) {
      this.setNext(toAdd);
    } else {
      this.getNext().addHelper(toAdd);
    }
  }

  @Override
  public void removeLastNode() {
    if (next == null) {
      this.data = 0;
      return;
    }
    if (next.getNext() == null) {
      next = null;
      return;
    }
    ListOfNumbers tempNode = next;
    ListOfNumbers tempNextNode = next.getNext();


    while (tempNextNode.getNext() != null) {
      tempNextNode = tempNextNode.getNext();
      tempNode = tempNode.getNext();
    }
    tempNode.setNext(null);

  }


  @Override
  public int getData(int index) {
    if (index < 0) {
      throw new IllegalArgumentException(" Value must be positive");
    }
    if (index >= this.count()) {
      throw new IllegalArgumentException(" Out of range");
    }
    return getDataHelp(0, index);
  }

  @Override
  public int getDataHelp(int accumulator, int index) {
    if (accumulator == index) {
      return data;
    }
    return this.next.getDataHelp(1 + accumulator, index);
  }

  @Override
  public int getIntData() {
    return data;
  }

  @Override
  public ListOfNumbers add(int number) {
    ListOfNumbers reversedNode = reverse(this);
    int carry = number;

    ListOfNumbers current = reversedNode;
    while (carry > 0) {
      int sum = current.getData(0) + carry;
      current.setData(sum % 10);
      carry = sum / 10;
      if (current.getNext() == null) {
        break;
      }
      current = current.getNext();
    }
    if (carry > 0) {
      current.addDataToEnd(carry);
    }
    reversedNode = reverse(reversedNode);
    return reversedNode;
  }

  @Override
  public void setData(int data) {
    this.data = data;
  }

  private ListOfNumbers reverse(ListOfNumbers head) {
    ListOfNumbers prev = null;
    ListOfNumbers current = head;
    ListOfNumbers nextNode;

    while (current != null) {
      nextNode = current.getNext();
      current.setNext(prev);

      prev = current;
      current = nextNode;
    }
    head = prev;
    return head;
  }


  @Override
  public ListOfNumbers getNext() {
    return next;
  }

  @Override
  public void setNext(ListOfNumbers nextNode) {
    next = nextNode;
  }

  @Override
  public String getStringOfData() {
    return String.valueOf(data);
  }


  @Override
  public String toString() {
    boolean firstString0 = false;
    StringBuilder builder = new StringBuilder();
    if (next == null) {
      return String.valueOf(data);
    }
    if (getStringOfData().equals("0")) {
      firstString0 = true;
    }
    if (!getStringOfData().equals("0")) {
      builder.append(getStringOfData());
    }
    ListOfNumbers nextNode = next;
    while (nextNode.getNext() != null) {
      if (firstString0 && nextNode.getStringOfData().equals("0")) {
        nextNode = nextNode.getNext();
        continue;
      }
      builder.append(nextNode.getStringOfData());
      nextNode = nextNode.getNext();
    }
    builder.append(nextNode.getStringOfData());
    return builder.toString();
  }
}