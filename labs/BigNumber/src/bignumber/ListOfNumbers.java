package bignumber;

/**
 * An interface that is used for implementing a linkedList.
 */
public interface ListOfNumbers {
  /**
   * Return the number of books in this list.
   *
   * @return the size of this list
   */
  int count();

  /**
   * Helper for the count method.
   *
   * @param acc the accumulator
   * @return the count from here
   */
  int countHelp(int acc);

  /**
   * Adding a value to the end of the linkedList.
   * @param data int
   */
  void addDataToEnd(int data);

  /**
   * Returns the next value of the linkedList.
   * @return list of numbers
   */
  ListOfNumbers getNext();

  /**
   * Sets the parameter value as the next node.
   * @param nextNode a list
   */
  void setNext(ListOfNumbers nextNode);

  /**
   * Returns the string of all the data in the object.
   * @return string of values
   */
  String getStringOfData();

  /**
   * Removes the last value of the list.
   */
  void removeLastNode();

  /**
   * Returns the int of the head of the list.
   * @return The first int of the list
   */
  int getIntData();

  /**
   * Returns the value of a list at a specific index.
   * @param index the index of the list
   * @return value
   */
  int getData(int index);

  /**
   * A helper method of the getData method which recursively calls
   * itself to get the value at teh specific index.
   * @param accumulator iterating index
   * @param index index of wanted value
   * @return value
   */
  int getDataHelp(int accumulator, int index);

  /**
   * Adds a single digit to the this object.
   * @param number the int being added to this object
   * @return a listOfNumbers
   */
  ListOfNumbers add(int number);

  /**
   * Sets the data to the int parameter.
   * @param data int
   */
  void setData(int data);

  /**
   * A helper method that adds a value to the end of the LinkedList.
   * @param toAdd value that would be added to the end of the linkedList
   */
  void addHelper(ListOfNumbers toAdd);
}