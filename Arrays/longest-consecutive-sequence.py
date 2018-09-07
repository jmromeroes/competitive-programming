class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        d = {}
        
        for n in nums:
            d[n] = False
        
        maxLength = 0
        for n in nums:
            if d[n] != True:
                print(str(n) + " N")
                foundAll = False
                d[n] = True
                l = 1
                i1 = 1
                i2 = 1
                
                f1 = False
                f2 = False
                while not foundAll:
                    if n + i1 in d and d[n + i1] != True:
                        l = l + 1
                        d[n + i1] = True
                        i1 = i1 + 1
                        f1 = True
                    
                    if n - i2 in d and d[n - i2] != True:
                        l = l + 1
                        d[n - i2] = True
                        i2 = i2 + 1
                        f2 = True
                        
                    if not f1 and not f2:
                        foundAll = True
                        if maxLength < l:
                            maxLength = l
                    
                    f1 = False
                    f2 = False
        return maxLength
                
