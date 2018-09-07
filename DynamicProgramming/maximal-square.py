class Solution(object):
        
    def maximalSquareHelper(self, matrix, x, y, auxMatrix):
        rightValue = 0
        downValue = 0
        diagonalValue = 0
        
        if x + 1 < len(matrix[0]):
            if not auxMatrix[y][x + 1]:
                matrix = self.maximalSquareHelper(matrix, x + 1, y, auxMatrix)
            rightValue = int(matrix[y][x + 1])
            
        if y + 1 < len(matrix):
            if not auxMatrix[y + 1][x]:
                matrix = self.maximalSquareHelper(matrix, x, y + 1, auxMatrix)
            downValue = int(matrix[y + 1][x])
        
        if y + 1 < len(matrix) and x + 1 < len(matrix[0]):
            if not auxMatrix[y + 1][x + 1]:
                matrix = self.maximalSquareHelper(matrix, x + 1, y + 1, auxMatrix)    
            
            diagonalValue = int(matrix[y + 1][x + 1])

            
            
        auxMatrix[y][x] = True
        if matrix[y][x] == "1":
            matrix[y][x] = (1 + min([rightValue, downValue, diagonalValue]))
        else:
            matrix[y][x] = 0

        return matrix
        
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return 0
        
        auxMatrix = self.maximalSquareHelper(matrix, 0, 0, [[False]*len(matrix[0])]*len(matrix))
        m = 0
        
        for l in matrix:
            for v in l:
                if v > m:
                    m = v
                
        return m*m
                
            
        
        
