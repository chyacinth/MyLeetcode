class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        sorted_nums = nums[:]
        sorted_nums.sort()
        i, j = 0, len(sorted_nums)-1
        while i < j:
            if sorted_nums[i] + sorted_nums[j] < target:
                i += 1
            elif sorted_nums[i] + sorted_nums[j] > target:
                j -= 1
            else:
                break
        
        for k in range(len(nums)):
            if (nums[k] == sorted_nums[i]):
                outi = k
                break
        for k in reversed(range(len(nums))):
            if (nums[k] == sorted_nums[j]):
                outj = k
                break
                
        return [outi, outj]