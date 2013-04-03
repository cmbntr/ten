package ch.cmbntr.ten.data.persistent;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.Map.Entry;

import org.junit.Test;

public class PDataTest {

  @Test
  public void testVector() {
    final PVector<Integer> v1 = PData.vector(asList(1, 2, 3));
    System.out.println(v1);

    assertEquals(Integer.valueOf(3), v1.peek());
    assertEquals(Integer.valueOf(2), v1.pop().peek());

    assertEquals(PData.sequence(3, 2, 1), v1.rsequence());
    assertEquals(PData.sequence(3, 2, 1), v1.rsequence());
    assertEquals(PData.vector(PData.sequence(3, 2, 1)), v1.rsequence());
  }

  @Test
  public void testList() {
    final PList<Integer> l1 = PData.list(asList(1, 2, 3));
    System.out.println(l1);

    assertEquals(Integer.valueOf(1), l1.peek());
    assertEquals(Integer.valueOf(2), l1.pop().peek());
  }

  @Test
  public void testMap() {
    final PMap<Integer, Character> m1 = PData.mapping(1, 'a', 2, 'b', 3, 'c');
    System.out.println(m1);
    System.out.println(m1.sequence());

    for (final Entry<Integer, Character> e : m1) {
      System.out.println(e);
    }

  }
}
