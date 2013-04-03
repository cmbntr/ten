package ch.cmbntr.ten.data.persistent;

import javax.annotation.CheckForNull;

public interface PSequencable<T> {

  @CheckForNull
  public PSequence<T> sequence();

}
