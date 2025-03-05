package com.bks.lzl.service;

import com.bks.lzl.utils.AlgorithmUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class AlgorithmUtilsTest {

    @Test
    void test() {
        String str1 = "[1,2,3,4,5,6]";
        String str2 = "[1,2,3,4]";
        String str3 = "[1,2,3,4,5,6,7]";
        int score1 = AlgorithmUtils.minDistance(str1, str2);
        int score2 = AlgorithmUtils.minDistance(str1, str3);
        System.out.println(score1);
        System.out.println(score2);
    }

    @Test
    void testCompareTags() {
        List<String> tagList1 = Arrays.asList("1", "2", "3");
        List<String> tagList2 = Arrays.asList("1", "2", "3", "4", "5");
        List<String> tagList3 = Arrays.asList("1","2");
        int score1 = AlgorithmUtils.minDistance(tagList1, tagList2);
        int score2 = AlgorithmUtils.minDistance(tagList1, tagList3);
        System.out.println(score1);
        System.out.println(score2);
    }

}
