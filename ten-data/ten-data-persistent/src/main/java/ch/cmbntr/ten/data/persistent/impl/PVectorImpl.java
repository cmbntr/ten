package ch.cmbntr.ten.data.persistent.impl;

import java.util.List;

import ch.cmbntr.ten.data.persistent.PSequence;
import ch.cmbntr.ten.data.persistent.PVector;
import clojure.lang.APersistentVector;
import clojure.lang.ISeq;
import clojure.lang.Seqable;
import clojure.lang.Sequential;

import com.google.common.collect.ForwardingList;

@SuppressWarnings("unchecked")
public class PVectorImpl<T> extends ForwardingList<T> implements PVector<T>, Sequential, Seqable {

  private final APersistentVector delegate;

  public PVectorImpl(final APersistentVector data) {
    super();
    this.delegate = data;
  }

  @Override
  protected List<T> delegate() {
    return this.delegate;
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
  public PVector<T> pop() {
    return new PVectorImpl<T>((APersistentVector) this.delegate.pop());
  }

  @Override
  public T apply(final Integer idx) {
    return (T) this.delegate.invoke(idx);
  }

  @Override
  public PSequence<T> sequence() {
    return PSequenceImpl.create(this.delegate.seq());
  }

  @Override
  public PSequence<T> rsequence() {
    return PSequenceImpl.create(this.delegate.rseq());
  }

}
