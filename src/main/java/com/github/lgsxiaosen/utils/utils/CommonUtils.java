package com.github.lgsxiaosen.utils.utils;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author xiaosen
 */
public class CommonUtils {

    /**
     * 获取随机数方法
     * @return
     */
    public static ThreadLocalRandom getLocalRandom(){
        return ThreadLocalRandom.current();
    }

    /**
     * 获取指定范围随机数
     * @param min
     * @param max
     * @return
     */
    public static int getRandomIndex(int min, int max){
        int index = 0;
        if (min>=max){
            return index;
        }
        index = getLocalRandom().nextInt(max - min) + min;
        return index;
    }

    /**
     * 去重
     * @param list
     * @param <T>
     * @return
     */
    public static<T> List<T> removeDuplicate(List<T> list){
        if (list.size()>1){
            Set<T> set = new LinkedHashSet<>(list.size());
            set.addAll(list);
            list.clear();
            list.addAll(set);
        }
        return list;
    }

    /**
     * 去重
     * @param keyExtractor
     * @param <T>
     * @return
     */
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
