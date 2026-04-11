class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length<2 || nums.length>10000){ //edge  case
            System.out.println("Invalid input");

        }else{
            int arr[]=new int[2];
            for(int i=0;i<nums.length;i++){ //bruteforce logic
                for(int j=i+1;j<nums.length;j++){
                    if(nums[i]+nums[j]==target){
                        arr[0]=i;
                        arr[1]=j;
                         return arr;
                    }
                }
            }
           
        }
        return null;
    }
}