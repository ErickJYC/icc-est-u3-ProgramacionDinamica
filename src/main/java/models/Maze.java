package models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Maze {
    public boolean[][] maze;

    public Maze(boolean[][] maze) {
        this.maze = maze;
    }

    public void printMaze() {
        for(int i = 0; i < this.maze.length; ++i) {
            for(int j = 0; j < this.maze[0].length; ++j) {
                System.out.print(this.maze[i][j] ? " - " : " * ");
            }

            System.out.println();
        }

    }

    public void printMazeVisited(List<Cell> path3) {
        Set<Cell> visited = new HashSet(path3);

        for(int i = 0; i < this.maze.length; ++i) {
            for(int j = 0; j < this.maze[0].length; ++j) {
                Cell current = new Cell(i, j);
                if (visited.contains(current)) {
                    System.out.print(" o ");
                } else if (this.maze[i][j]) {
                    System.out.print(" - ");
                } else {
                    System.out.print(" * ");
                }
            }

            System.out.println();
        }

    }
}
