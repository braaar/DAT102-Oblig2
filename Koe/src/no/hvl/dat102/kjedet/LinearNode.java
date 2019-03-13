package no.hvl.dat102.kjedet;

public class LinearNode<T> {
  private LinearNode<T> next;
  private boolean last = true;
  private T element;
  
  public LinearNode (T elem) {
    next = null;
    element = elem;
  }
  
  public T getElement() {
    return element;
  }

  public void setElement(T elem) {
    element = elem;
  }

  public void setNext(LinearNode<T> node) {
    last = false;
    next = node;
  }
  public LinearNode<T> getNext() {
    return next;
  }
  public boolean isLast() {
    return last;
  }
}
