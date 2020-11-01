from collections import deque

class Solution:
    
    def subsetsWithDupRec(self, nums) -> List[List[str]]:
        if len(nums) == 0: return [[]]
        
        first = nums.pop()
        l: List[List[str]] = [[first]]
        
        result_next = self.subsetsWithDupRec(nums)
        
        for res in result_next:
            new_res = [first] + res
            new_res.sort()
            
            l.append(new_res)
            l.append(res)

        return l
    
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        q = deque(list(map(lambda v: str(v), nums)))
        res = self.subsetsWithDupRec(q)
        res_as_string = set(map(lambda v: ",".join(v), res))
        res_as_list = list(map(lambda v: v.split(","), res_as_string))
        return list(map(lambda v: list(map(lambda x: int(x), filter(lambda x: x != '', v))), res_as_list))
