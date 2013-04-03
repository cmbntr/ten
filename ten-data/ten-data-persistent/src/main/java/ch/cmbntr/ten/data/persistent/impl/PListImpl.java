package ch.cmbntr.ten.data.persistent.impl;

import java.util.List;

import ch.cmbntr.ten.data.persistent.PList;
import ch.cmbntr.ten.data.persistent.PSequence;
import clojure.lang.IPersistentList;
import clojure.lang.ISeq;
import clojure.lang.Seqable;
import clojure.lang.Sequential;

import com.google.common.collect.ForwardingList;

@SuppressWarnings("unchecked")
public class PListImpl<T> extends ForwardingList<T> implements PList<T>, Sequential, Seqable {

  private final IPersistentList delegate;

  public PListImpl(final IPersistentList data) {
    super();
    this.delegate = data;
  }

  @Override
  protected List<T> delegate() {
    return (List<T>) this.delegate;
  }

  @Override
  public ISeq seq() {
    return this.delegate.seq();
  }

  @Override
  public T peek() {
    return (T) this.delegate.peek();
  }

  @Override
  public PList<T> pop() {
    return new PListImpl<T>((IPersistentList) this.delegate.pop());
  }

  @Override
  public PSequence<T> sequence() {
    return PSequenceImpl.create(this.delegate.seq());
  }

}
