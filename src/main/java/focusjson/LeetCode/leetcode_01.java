package focusjson.LeetCode;

public class leetcode_01 {
    /*
    *   Two Sum
    *   Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    *
    *   You may assume that each input would have exactly one solution, and you may not use the same element twice.
    *
    *   Example:
    *
    *   Given nums = [2, 7, 11, 15], target = 9,
    *
    *   Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].
    * */
    public static void main(String[] args) {
        int[] arry ={1,2,3,4,5,6,7};
        int target =8;
        int[] ints = twoSum(arry, target);
        System.out.println(ints.length);
    }


    /**
     * 遍历数组，寻找复合目标值的数据
     *
     * @param nums 目标数组
     * @param target 目标值
     * @return 数据下表列表
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
    }

}
