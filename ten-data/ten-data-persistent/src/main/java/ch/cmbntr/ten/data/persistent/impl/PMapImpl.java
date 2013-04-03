package ch.cmbntr.ten.data.persistent.impl;

import java.util.Iterator;
import java.util.Map;

import ch.cmbntr.ten.data.persistent.PMap;
import ch.cmbntr.ten.data.persistent.PSequence;
import clojure.lang.APersistentMap;
import clojure.lang.ISeq;
import clojure.lang.Seqable;

import com.google.common.collect.ForwardingMap;

@SuppressWarnings("unchecked")
public class PMapImpl<K, V> extends ForwardingMap<K, V> implements PMap<K, V>, Seqable {

  private final APersistentMap delegate;

  public PMapImpl(final APersistentMap delegate) {
    super();
    this.delegate = delegate;
  }

  @Override
  protected Map<K, V> delegate() {
    return this.delegate;
  }

  @Override
  public ISeq seq() {
    return this.delegate.seq();
  }

  @Override
  public Iterator<Map.Entry<K, V>> iterator() {
    return this.delegate.iterator();
  }

  @Override
  public V apply(final K key) {
    return (V) this.delegate.invoke(key);
  }

  @Override
  public PSequence<Map.Entry<K, V>> sequence() {
    return PSequenceImpl.create(seq());
  }

}
