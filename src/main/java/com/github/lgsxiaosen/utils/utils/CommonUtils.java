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
 * @date 2019/6/4 14:24
 * @description
 */
public class CommonUtils {

    /**
     * @author xiaosen
     * @description 获取随机数方法
     * @date 2019/6/4
     * @param
     * @return
     */
    public static ThreadLocalRandom getLocalRandom(){
        return ThreadLocalRandom.current();
    }

    /**
     * @author xiaosen
     * @description 获取指定范围随机数
     * @date 2019/5/29
     * @param
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
     * @author xiaosen
     * @description 去重
     * @date 2019/8/13
     * @param
     * @return
     */
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}
