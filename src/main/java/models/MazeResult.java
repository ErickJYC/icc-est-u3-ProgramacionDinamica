package models;

import java.util.List;
import java.util.Set;

public class MazeResult {
    private List<Cell> path;
    private Set<Cell> visited;

    public MazeResult(List<Cell> path, Set<Cell> visited) {
        this.path = path;
        this.visited = visited;
    }

    public List<Cell> getPath() {
        return this.path;
    }

    public Set<Cell> getVisited() {
        return this.visited;
    }
}
