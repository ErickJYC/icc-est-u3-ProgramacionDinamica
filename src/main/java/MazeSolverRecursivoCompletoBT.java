import models.Cell;
import models.MazeResult;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MazeSolverRecursivoCompletoBT implements MazeSolver{
    private final List<Cell> path = new ArrayList();
    private final Set<Cell> visited = new LinkedHashSet();
    private boolean[][] grid;
    private Cell end;

    public MazeResult getPath(boolean[][] grid, Cell star, Cell end) {
        this.path.clear();
        this.visited.clear();
        this.grid = grid;
        this.end = end;
        if (grid != null && grid.length != 0) {
            if (this.findPath(star)) {
                System.out.println("CAMINO");
                System.out.println(this.path);
                System.out.println("Visitadas");
                System.out.println(this.visited);
                return new MazeResult(this.path, this.visited);
            } else {
                return new MazeResult(new ArrayList(), new LinkedHashSet());
            }
        } else {
            return new MazeResult(new ArrayList(), new LinkedHashSet());
        }
    }

    private boolean findPath(Cell current) {
        if (!this.isInMaze(current)) {
            return false;
        } else if (!this.isValid(current)) {
            return false;
        } else {
            this.visited.add(current);
            this.path.add(current);
            if (current.equals(this.end)) {
                return true;
            } else {
                return this.findPath(new Cell(current.row, current.col + 1)) || this.findPath(new Cell(current.row + 1, current.col)) || this.findPath(new Cell(current.row - 1, current.col)) || this.findPath(new Cell(current.row, current.col - 1));
            }
        }
    }

    private boolean isValid(Cell current) {
        return this.grid[current.row][current.col] && !this.visited.contains(current);
    }

    private boolean isInMaze(Cell current) {
        int row = current.row;
        int col = current.col;
        return row >= 0 && row < this.grid.length && col >= 0 && col < this.grid[0].length;
    }

    public List<Cell> getPath1(boolean[][] grid, Cell start, Cell end) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
