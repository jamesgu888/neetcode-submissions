class Solution:
    def shortestPath(self, grid: List[List[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0]);

        if grid[0][0] == 1:
            return -1
        
        queue = deque();
        visited = set();
        
        queue.append((0, 0));
        visited.add((0, 0));

        res = 0
        while queue:
            for i in range(len(queue)):
                r, c = queue.popleft()

                if r == ROWS - 1 and c == COLS - 1:
                    return res
                
                neighbors = ((1, 0), (-1, 0), (0, 1), (0, -1))

                for dr, dc in neighbors:
                    newR = r + dr
                    newC = c + dc

                    if min(newR, newC) < 0 or newR > ROWS - 1 or newC > COLS - 1 or (newR, newC) in visited or grid[newR][newC] == 1:
                        continue

                    visited.add((newR, newC));
                    queue.append((newR, newC));
            
            res += 1
        
        return -1