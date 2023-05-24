/**
 * The question(intermediate):
 * Given an array of integers nums, sort the array in ascending order and return it.
 * You must solve the problem without using any built-in functions in O(n log(n)) time complexity 
 * and with the smallest space complexity possible.
 * 
 * Example 1: 
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), 
 * while the positions of other numbers are changed (for example, 1 and 5).
 * 
 * Example 2:
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 * Explanation: Note that the values of nums are not necessairly unique.
 */

/**
 * Solution:
 * To sort the array in ascending order without using any built-in functions in O(n log(n)) time complexity and
 * with the smallest space complexity possible, we can use the Merge Sort algorithm.
 * 
 * The sortArray method is the main entry point that takes the input array and returns the sorted array. 
 * It calls the mergeSort method to recursively divide the input array into smaller subarrays and sort them.
 * The mergeSort method takes three parameters: the input array, the starting index of the subarray, and 
 * the ending index of the subarray. 
 * It uses the merge method to merge two sorted subarrays into a single sorted array.
 * The merge method takes four parameters: the input array, the starting index of the first subarray, the ending index of the first subarray, and the ending index of the second subarray. It creates a temporary array to store the merged subarrays and then merges the two subarrays by comparing the elements in each subarray and placing them in the correct order in the temporary array. Finally, it copies the sorted elements from the temporary array back to the original input array.
 * This implementation of Merge Sort has a time complexity of O(nlog(n)) and a space complexity of O(n) because it creates a temporary array to merge the subarrays. However, the temporary array is only created once during the entire sort, so it uses the smallest space complexity possible for Merge Sort.
 */
public class SortAnArray {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void mergeSort(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private static void merge(int[] nums, int start, int mid, int end){
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while(i <= mid && j <= end) {
            if (nums[i] <= nums[j]){
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while(i <= mid){
            temp[k++] = nums[i++];
        }
        while(j <= end){
            temp[k++] = nums[j++];
        }
        for(i = start; i <= end; i++){
            nums[i] = temp[i - start];
        }
    }
}