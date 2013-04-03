package ch.cmbntr.ten.data.persistent;

public interface PStack<T, S extends PStack<T, S>> {

  public T peek();

  public S pop();

}
