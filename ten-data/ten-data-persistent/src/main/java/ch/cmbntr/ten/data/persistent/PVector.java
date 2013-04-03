package ch.cmbntr.ten.data.persistent;

import java.util.List;
import java.util.RandomAccess;

import com.google.common.base.Function;

public interface PVector<T> extends List<T>, PStack<T, PVector<T>>, PSequencable<T>, PReversible<T>, RandomAccess,
    Function<Integer, T> {

}
