import models.Cell;
import models.MazeResult;

import java.util.List;

public interface MazeSolver {
    List<Cell> getPath1(boolean[][] var1, Cell var2, Cell var3);

    MazeResult getPath(boolean[][] var1, Cell var2, Cell var3);
}
