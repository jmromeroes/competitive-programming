class Solution:
    def numTrees(self, n: int) -> int:
        d = {}
        
        if n <= 1:
            return n
        
        def num_trees_recursion(pending_nodes: List[int]) -> int:
            if len(pending_nodes) == 1:
                return 1
            
            hash_pn = str(sorted(pending_nodes))
            
            if hash_pn in d:
                return d[hash_pn]
            
            result = 0
            for current_node in pending_nodes:
                greater_results = 0
                greater_values = list(filter(lambda x: x > current_node, pending_nodes))
                
                lower_results = 0
                lower_values = list(filter(lambda x: x < current_node, pending_nodes))
                
                lower_possibilities = num_trees_recursion(lower_values)
                greater_possibilities = num_trees_recursion(greater_values)
                
                if lower_possibilities and greater_possibilities:
                    result += lower_possibilities * greater_possibilities
                elif lower_possibilities:
                    result += lower_possibilities
                else:
                    result += greater_possibilities
                    
            d[hash_pn] = result   
            return d[hash_pn]
        
        return num_trees_recursion(list(range(1, n+1)))
        
