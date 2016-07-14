package com.github.s0nerik.rxlist;

import android.support.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Event<E> {

  @IntDef({ ITEM_ADDED, ITEM_REMOVED, ITEM_CHANGED, ITEMS_CLEARED })
  @Retention(RetentionPolicy.SOURCE)
  public @interface Type {
  }

  public static final int ITEM_ADDED = 0;
  public static final int ITEM_REMOVED = 1;
  public static final int ITEM_CHANGED = 2;
  public static final int ITEMS_CLEARED = 3;

  public final @Type int type;
  public final int index;
  public final E item;

  private Event(@Type int type, int index, E item) {
    this.type = type;
    this.index = index;
    this.item = item;
  }

  public static <E> Event<E> create(@Type int type, int index, E item) {
    return new Event<>(type, index, item);
  }
}