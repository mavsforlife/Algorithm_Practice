package com.victor.algorithmpractice.chapter3;

/**
 * @author victor
 * @Description Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * <p>
 * No.33
 * @since 2020-03-11
 */
public class SearchRotatedSortedArray {

    private static int findRotatedIndex(int left, int right, int[] nums) {
        if (nums[left] < nums[right]) {
            return 0;
        }
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1]) {
                return pivot + 1;
            } else {
                if (nums[pivot] < nums[pivot + 1]) {
                    right = pivot - 1;
                } else {
                    left = left + 1;
                }
            }
        }
        return 0;
    }

    private static int search(int left, int right, int[] nums, int target) {
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] == target) {
                return pivot;
            }

            if (target < nums[pivot]) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return -1;
    }

    private static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int rotateIndex = findRotatedIndex(0, nums.length - 1, nums);


        if (nums[rotateIndex] == target) {
            return rotateIndex;
        }

        if (rotateIndex == 0) {
            return search(0, nums.length - 1, nums, target);
        }

        if (target < nums[0]) {
            return search(rotateIndex, rotateIndex - 1, nums, target);
        }

        return search(0, rotateIndex, nums, target);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 5, 6, 7, 0, 1, 2};

        int target1 = 0;
        int target2 = 3;

        int index1 = search(nums1, target1);
        System.out.println("target is: " + target1 + ", index is -> " + index1);

        int index2 = search(nums1, target2);
        System.out.println("target is: " + target1 + ", index is -> " + index2);
    }
}
