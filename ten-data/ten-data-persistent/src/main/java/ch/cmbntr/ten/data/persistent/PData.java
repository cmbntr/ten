package ch.cmbntr.ten.data.persistent;

import java.util.List;
import java.util.Map;

import javax.annotation.CheckForNull;
import javax.annotation.Nullable;

import ch.cmbntr.ten.data.persistent.impl.PListImpl;
import ch.cmbntr.ten.data.persistent.impl.PMapImpl;
import ch.cmbntr.ten.data.persistent.impl.PSequenceImpl;
import ch.cmbntr.ten.data.persistent.impl.PVectorImpl;
import clojure.lang.APersistentMap;
import clojure.lang.ArraySeq;
import clojure.lang.IPersistentMap;
import clojure.lang.ISeq;
import clojure.lang.IteratorSeq;
import clojure.lang.PersistentArrayMap;
import clojure.lang.PersistentHashMap;
import clojure.lang.PersistentList;
import clojure.lang.PersistentVector;
import clojure.lang.Seqable;

import com.google.common.collect.Lists;

@SuppressWarnings("unchecked")
public class PData {

  @CheckForNull
  public static <T> PSequence<T> sequence(final T... values) {
    return PSequenceImpl.create(ArraySeq.create(values));
  }

  @CheckForNull
  public static <T> PSequence<T> seq(final PSequencable<T> seq) {
    return seq.sequence();
  }

  @CheckForNull
  public static <T> PSequence<T> seq(final Iterable<? extends T> items) {
    if (items instanceof PSequencable) {
      return seq((PSequencable<T>) items);
    }
    return PSequenceImpl.create(items.iterator());
  }

  public static <T> PVector<T> vector(final Iterable<? extends T> items) {
    if (items instanceof List) {
      return new PVectorImpl<T>(PersistentVector.create((List<?>) items));
    }

    return new PVectorImpl<T>(PersistentVector.create((ISeq) IteratorSeq.create(items.iterator())));
  }

  public static <T> PList<T> list(final Iterable<? extends T> items) {
    return new PListImpl<T>(PersistentList.create(items instanceof List ? (List<?>) items : Lists.newArrayList(items)));
  }

  public static <K, V> PMap<K, V> map(@Nullable final PSequence<? extends Map.Entry<? extends K, ? extends V>> entries) {
    ISeq e = null;
    if (entries != null) {
      e = entries instanceof Seqable ? ((Seqable) entries).seq() : IteratorSeq.create(entries.iterator());
    }
    return new PMapImpl<K, V>(PersistentHashMap.create(e));
  }

  public static <K, V> PMap<K, V> map(final Map<? extends K, ? extends V> m) {
    final IPersistentMap pm = PersistentArrayMap.create(m);
    if (pm instanceof APersistentMap) {
      return new PMapImpl<K, V>((APersistentMap) pm);
    } else {
      return map(PSequenceImpl.<Map.Entry<K, V>> create(pm.seq()));
    }
  }

  public static <K, V> PMap<K, V> mapping() {
    return new PMapImpl<K, V>(PersistentArrayMap.EMPTY);
  }

  public static <K, V> PMap<K, V> mapping(final K k1, final V v1) {
    return new PMapImpl<K, V>(PersistentArrayMap.createAsIfByAssoc(new Object[] { k1, v1 }));
  }

  public static <K, V> PMap<K, V> mapping(final K k1, final V v1, final K k2, final V v2) {
    return new PMapImpl<K, V>(PersistentArrayMap.createAsIfByAssoc(new Object[] { k1, v1, k2, v2 }));
  }

  public static <K, V> PMap<K, V> mapping(final K k1, final V v1, final K k2, final V v2, final K k3, final V v3) {
    return new PMapImpl<K, V>(PersistentArrayMap.createAsIfByAssoc(new Object[] { k1, v1, k2, v2, k3, v3 }));
  }

  public static <K, V> PMap<K, V> mapping(final K k1, final V v1, final K k2, final V v2, final K k3, final V v3,
      final K k4, final V v4) {
    return new PMapImpl<K, V>(PersistentArrayMap.createAsIfByAssoc(new Object[] { k1, v1, k2, v2, k3, v3, k4, v4 }));
  }

  public static <K, V> PMap<K, V> mapping(final K k1, final V v1, final K k2, final V v2, final K k3, final V v3,
      final K k4, final V v4, final K k5, final V v5) {
    return new PMapImpl<K, V>(PersistentArrayMap.createAsIfByAssoc(new Object[] { k1, v1, k2, v2, k3, v3, k4, v4, k5,
        v5 }));
  }

}
