public class SortedLinkedList
{
  private Node head;
  private int length;
  
  /**
   * Create an empty list.
   */
  public SortedLinkedList()
  {
    head = null;
    length = 0;
  }
  
  /**
   * Print all the elements of the list to the console.  Each element will have
   * the form "name:quantity" and the entries will be separated by a single
   * space.
   */
  public void print()
  {
    Node temp = head;
    while(temp != null)
    {
      System.out.print(temp.getName() + ":" + temp.getQuantity() + " ");
      temp = temp.getNext();
    }
    
    System.out.println();
  }
  
  /**
   * This method will return the name at the specified index.  Similar to an
   * array, the index of the first entry is zero.  If the index is invalid,
   * this method will return null.
   */
  public String getName(int index)
  {
    if (index >= length)
      return null;
    Node temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.getNext();
    }
    return temp.getName();
  }
  
  /**
   * This method will return the quantity at the specified index.  Similar to
   * an array, the index of the first entry is zero.  If the index is invalid,
   * this method will return -1.
   */
  public int getQuantity(int index)
  {
    if (index >= length)
      return -1;
    Node temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.getNext();
    }
    return temp.getQuantity();
  }
  
  /**
   * This method will return the number of elements currently held in the list.
   */
  public int getLength()
  {
    return length;
  }
  
  /**
   * This method will return whether or not the specified name is contained in
   * the list.
   */
  public boolean isMember(String name)
  {
    if (length > 0){
      Node temp = head;
      while (temp != null){
        if (temp.getName() == name)
          return true;
        temp = temp.getNext();
      }
    }
    return false;
  }
  
  /**
   * This method will add the specified name/quantity to the list in sorted
   * order.  This order is specified by the quantity from low to high.
   */
  public void insert(String name, int quantity)
  {
    Node newNode = new Node(name, quantity);
    
    length += 1;
    
    if (head == null) {
      head = newNode;
      return;
    }
    
    if (newNode.getQuantity() < head.getQuantity()){
      newNode.setNext(head);
      head = newNode;
    }
    
    else {
      Node curr = head.getNext();
      Node prev = head;
      boolean inserted = false;
      
      while (curr != null) {
        if (newNode.getQuantity() >= prev.getQuantity() && newNode.getQuantity() < curr.getQuantity()) {
          prev.setNext(newNode);
          newNode.setNext(curr);
          curr = null;
          inserted = true;
        }
        else {
          prev = curr;
          curr = curr.getNext();
        }
      }
      if (inserted == false) {
        prev.setNext(newNode);
      }
    }
  }
}