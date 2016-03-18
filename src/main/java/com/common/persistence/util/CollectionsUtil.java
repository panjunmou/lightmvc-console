package com.common.persistence.util;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by PanJM on 2016/3/16.
 */
public final class CollectionsUtil {

    /**
     * 返回不同对象的HashMap
     *
     * @return
     */
    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<K, V>();
    }

    /**
     * 返回不同对象的ArrayList
     *
     * @return
     */
    public static <T> ArrayList<T> newArrayList() {
        return new ArrayList<T>();
    }
}
