package ch.cmbntr.ten.data.persistent;

import java.util.Map;

import com.google.common.base.Function;

public interface PMap<K, V> extends Map<K, V>, PSequencable<Map.Entry<K, V>>, Iterable<Map.Entry<K, V>>, Function<K, V> {

}
