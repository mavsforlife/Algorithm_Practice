package com.victor.algorithmpractice.chapter1;

import android.annotation.SuppressLint;

import java.util.HashMap;

/**
 * @author victor
 * @Description Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.*
 * @since 2020-03-06
 */
public class TwoSum {

    /**
     * 暴力法
     * 时间复杂度 O(n2)
     * 空间复杂度 O(1)
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; i++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("no two sum solution!");
    }

    /**
     * 一遍哈希表
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public int[] twoSum(int[] nums, int target) {
        @SuppressLint("UseSparseArrays")
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int completement = target - nums[i];
            if (map.containsKey(completement)) {
                return new int[]{map.get(completement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
