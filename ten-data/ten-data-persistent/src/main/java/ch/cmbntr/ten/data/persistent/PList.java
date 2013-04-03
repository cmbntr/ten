package ch.cmbntr.ten.data.persistent;

import java.util.List;

public interface PList<T> extends List<T>, PSequencable<T>, PStack<T, PList<T>> {

}
