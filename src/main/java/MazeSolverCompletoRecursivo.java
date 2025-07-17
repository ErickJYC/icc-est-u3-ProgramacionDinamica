import models.Cell;
import models.MazeResult;

import java.util.ArrayList;
import java.util.List;

public class MazeSolverCompletoRecursivo implements MazeSolver{
    public List<Cell> getPath1(boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList();
        if (grid != null && grid.length != 0) {
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            if (!this.findPath(grid, start, end, path, visited)) {
                return new ArrayList();
            } else {
                List<Cell> correctPath = new ArrayList();

                for(int i = path.size() - 1; i >= 0; --i) {
                    correctPath.add((Cell)path.get(i));
                }

                return correctPath;
            }
        } else {
            return path;
        }
    }

    private boolean findPath(boolean[][] grid, Cell current, Cell end, List<Cell> path, boolean[][] visited) {
        int row = current.row;
        int col = current.col;
        if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] && !visited[row][col]) {
            visited[row][col] = true;
            if (row == end.row && col == end.col) {
                path.add(current);
                return true;
            } else if (!this.findPath(grid, new Cell(row + 1, col), end, path, visited) && !this.findPath(grid, new Cell(row, col + 1), end, path, visited) && !this.findPath(grid, new Cell(row - 1, col), end, path, visited) && !this.findPath(grid, new Cell(row, col - 1), end, path, visited)) {
                visited[row][col] = false;
                return false;
            } else {
                path.add(current);
                return true;
            }
        } else {
            return false;
        }
    }

    public MazeResult getPath(boolean[][] grid, Cell star, Cell end) {
        throw new UnsupportedOperationException("Unimplemented method 'getPath'");
    }
}
