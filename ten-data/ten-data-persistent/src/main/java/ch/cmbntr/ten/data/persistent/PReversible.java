package ch.cmbntr.ten.data.persistent;

import javax.annotation.CheckForNull;

public interface PReversible<T> {

  @CheckForNull
  public PSequence<T> rsequence();
}
