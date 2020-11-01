class Solution:
    def grayCodeRec(self, binary_start: List[str], s: Set[int]) -> List[int]:
        
        binary_start_as_int = int("".join(binary_start), 2)
        if binary_start_as_int in self.dp:
            return self.dp[binary_start_as_int]
        
        binary_start_copy = binary_start.copy()
        _max: List[int] = [binary_start_as_int]
        
        for i in range(0, len(binary_start)):
            
            if binary_start[i] == "0":
                binary_start_copy[i] = "1"
                
                if int("".join(binary_start_copy), 2) not in s:
                    res = [binary_start_as_int] + self.grayCodeRec(binary_start_copy, s | {binary_start_as_int})
                    
                    if len(res) > len(_max):
                        _max = res
                        
                binary_start_copy[i] = "0"
            
            if binary_start[i] == "1":
                binary_start_copy[i] = "0"
                
                if int("".join(binary_start_copy), 2) not in s:
                    res = [binary_start_as_int] + self.grayCodeRec(binary_start_copy, s | {binary_start_as_int})

                    if len(res) > len(_max):
                        _max = res
                        
                binary_start_copy[i] = "1"
                
        self.dp[binary_start_as_int] = _max 
        return _max
    
    def grayCode(self, n: int) -> List[int]:
        if n == 0: return [0]
        
        self.dp = {}
        res = self.grayCodeRec(["0"]*n, set())

        return res
