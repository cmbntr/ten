package ch.cmbntr.ten.data.persistent.impl;

import java.util.Iterator;

import javax.annotation.CheckForNull;
import javax.annotation.Nullable;

import ch.cmbntr.ten.data.persistent.PSequence;
import clojure.lang.ISeq;
import clojure.lang.IteratorSeq;
import clojure.lang.SeqIterator;
import clojure.lang.Seqable;
import clojure.lang.Sequential;

@SuppressWarnings("unchecked")
public class PSequenceImpl<T> implements PSequence<T>, Sequential, Seqable {

  private final ISeq seq;

  private PSequenceImpl(final ISeq seq) {
    super();
    this.seq = seq;
  }

  @CheckForNull
  public static <T> PSequence<T> create(@Nullable final ISeq seq) {
    return seq == null ? null : new PSequenceImpl<T>(seq);
  }

  @CheckForNull
  public static <T> PSequence<T> create(final Iterator<? extends T> items) {
    return create(IteratorSeq.create(items));
  }

  @Override
  public ISeq seq() {
    return this.seq;
  }

  @Override
  public boolean equals(@Nullable final Object object) {
    return object == this || this.seq.equals(object);
  }

  @Override
  public int hashCode() {
    return this.seq.hashCode();
  }

  @Override
  public String toString() {
    return this.seq.toString();
  }

  @Override
  public PSequence<T> sequence() {
    return this;
  }

  @Override
  public Iterator<T> iterator() {
    if (this.seq instanceof Iterable) {
      return ((Iterable<T>) this.seq).iterator();
    }
    return new SeqIterator(this.seq);
  }

}
