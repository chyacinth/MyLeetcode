class Solution:
    def median(self, num):
        length = len(num)
        # even
        if length % 2 == 0:
            return (num[length // 2 - 1] + num[length//2]) / 2
        # odd
        elif length % 2 == 1:
            return (num[length // 2])
    
    def slice_from_middle(self, nums):
        middle = (len(nums) - 1) // 2
        if len(nums) % 2 == 0:
            nums = nums[middle - 4:middle + 6]
        else:
            nums = nums[middle - 5:middle + 6]
        return nums

    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        toal_len = len(nums1) + len(nums2)
        while True:
            if len(nums1) == 0:
                return self.median(nums2)
            elif len(nums2) == 0:
                return self.median(nums1)
            # make sure len(nums1) < len(nums2)                             
            if len(nums1) > len(nums2):
                nums1, nums2 = nums2, nums1                
        
            # special case
            if len(nums1) <= 2:
                left_pad = [min(nums1[0], nums2[0]) - 1] * 7
                right_pad = [max(nums1[-1], nums2[-1]) + 1] * 7
                ret_nums = self.slice_from_middle(left_pad + nums2 + right_pad) + nums1
                ret_nums.sort()
                return self.median(ret_nums)

            # reduce numbers
            if (toal_len % 2 == 1):
                remove_num = min(len(nums1),len(nums2)) // 2
            else:
                remove_num = (min(len(nums1),len(nums2)) - 1) // 2


            if self.median(nums1) > self.median(nums2):
                nums1, nums2 = nums2, nums1

            nums1 = nums1[remove_num:]
            nums2 = nums2[:-remove_num]