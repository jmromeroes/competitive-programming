class Solution:
    
    def shift_everything_right(self, nums: List[int], index: int) -> None:
        tmp1 = nums[index]
        
        for i in range(index + 1, len(nums)):
            tmp2 = nums[i]
            nums[i] = tmp1
            tmp1 = tmp2
    
    def paste_rest(self, nums1: List[int], ptr1: int, nums2: List[int], ptr2: int) -> None:
        for i in range(ptr2, len(nums2)):
            nums1[ptr1] = nums2[i]
            ptr1 = ptr1 + 1
            
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        if m == 0:
            self.paste_rest(nums1, 0, nums2, 0)
            return
        
        ptr1: int = 0
        ptr2: int = 0
        
        while ptr1 < len(nums1) and ptr2 < len(nums2):
            if nums1[ptr1] < nums2[ptr2] and ptr1 < m:
                ptr1 += 1
            elif ptr1 == m:
                self.paste_rest(nums1, ptr1, nums2, ptr2)
                break
            else:
                self.shift_everything_right(nums1, ptr1)
                nums1[ptr1] = nums2[ptr2]
                ptr2 += 1
                m = m + 1
                if ptr1 > m:
                    ptr1 += 1
