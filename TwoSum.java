/*
 * THE PROBLEM:
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * 
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

/*
 * My stupid solution that doesn't works, I received an ArrayIndexOutOfBoundsException
 * 
 * class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];
        for(int i = 0; i <= nums.length; i++){
            if(i == nums.length){
                continue;
            }
            if((nums[i] + nums[i+1]) == target){
                output[0] = nums[i];
                output[1] = nums[i+1];
            }
        }
        return output;
    }
}
 */

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Map to store the complement of each number and its index
        Map<Integer, Integer> complementMap = new HashMap<>(); // O(1)

        for(int i = 0; i < nums.length; i++){ // O(n)
            int complement = target - nums[i];
            if(complementMap.containsKey(complement)){
                // Return the indices of the two numbers that add up to the target
                return new int[]{complementMap.get(complement), i};
            }
            // Add the current number and its index to the map
            complementMap.put(nums[i], i);
        }
        // No solution found, return an empty array
        return new int[0];
    }
    
}

/**
 * In this program, we define a class TwoSum with a method twoSum that takes an array of integers nums and an integer target. 
 * It returns an array of two indices representing the indices of the two numbers in the input array that add up to the target.
 *
 * To solve the problem, we iterate through the input array nums. 
 * For each number, we calculate its complement (i.e., the target minus the current number). 
 * We check if the complement exists in the complementMap. 
 * If it does, we have found the two numbers that add up to the target, and we return their indices. 
 * If the complement does not exist in the map, we add the current number and its index to the map.
 */
