import models.Cell;
import models.MazeResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MazeSolverRecursivo implements MazeSolver{
    public MazeResult getPath(boolean[][] grid, Cell star, Cell end) {
        List<Cell> path = new ArrayList();
        if (grid != null && grid.length != 0) {
            return this.findPath(grid, star, end, path) ? new MazeResult(path, (Set)null) : null;
        } else {
            return null;
        }
    }

    private boolean findPath(boolean[][] grid, Cell star, Cell end, List<Cell> path) {
        int row = star.row;
        int col = star.col;
        if (row < grid.length && col < grid[0].length && grid[row][col]) {
            if (row == end.row && col == end.col) {
                path.add(star);
                return true;
            } else if (!this.findPath(grid, new Cell(row + 1, col), end, path) && !this.findPath(grid, new Cell(row, col + 1), end, path)) {
                return false;
            } else {
                path.add(star);
                return true;
            }
        } else {
            return false;
        }
    }

    public List<Cell> getPath1(boolean[][] grid, Cell start, Cell end) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
