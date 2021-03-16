class Solution {
    public int majorityElement(int[] nums) {
        int freq = nums.length/2+1;
        Map<Integer, Integer> freqMap = new HashMap<>();
        int theOne = 0;
        for(int n = 0;n<nums.length;n++){            
            if(freqMap.keySet().contains(nums[n])){
                freqMap.put(nums[n], freqMap.get(nums[n])+1);
            }else{
                freqMap.put(nums[n], 1);
            }
            if(freqMap.get(nums[n])>=freq){
                theOne = nums[n];
            }
        }
        return theOne;
    }
}