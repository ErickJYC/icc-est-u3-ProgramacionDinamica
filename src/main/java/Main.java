import models.Cell;
import models.Maze;
import models.MazeResult;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        runMaze();
    }

    private static void runMaze() {
        boolean[][] predefinedMaze = new boolean[][]{{true, true, true, true}, {false, true, false, true}, {true, true, false, false}, {true, true, true, true}};
        Maze maze = new Maze(predefinedMaze);
        System.out.println("Laberinto Cargado");
        maze.printMaze();
        Cell start = new Cell(0, 0);
        Cell end = new Cell(3, 3);
        List<MazeSolver> solvers = Arrays.asList(new MazeSolverRecursivo(), new MazeSolverRecursivo(), new MazeSolverRecursivoCompletoBT());
        MazeSolver solver1 = (MazeSolver)solvers.get(0);
        MazeResult path1 = solver1.getPath(maze.maze, start, end);
        System.out.println("\nCamino encontrado con MazeSolverRecursivo:");
        System.out.println(path1.getPath());
        MazeSolver solver2 = (MazeSolver)solvers.get(1);
        MazeResult path2 = solver2.getPath(maze.maze, start, end);
        System.out.println("\nCamino encontrado con MazeSolverRecursivoFour:");
        System.out.println(path2.getPath());
        System.out.println("\nCamino encontrado con MazeSolverRecursivoCompletoBT:");
        MazeSolver solver3 = (MazeSolver)solvers.get(2);
        MazeResult path3 = solver3.getPath(maze.maze, start, end);
        System.out.println(path3.getPath());
        maze.printMazeVisited(path3.getPath());
    }

    private static void runEjerciciosPD() {
        EjerciciosPD ejerciciosPD = new EjerciciosPD();
        System.out.println("Ejercicio fibonacci recursivo");
        long start = System.nanoTime();
        long resultado = ejerciciosPD.getFibonaci(50L);
        long end = System.nanoTime();
        long duration = end - start;
        double durationSegundos = (double)duration / (double)1.0E9F;
        System.out.println("Resultado: " + resultado + " en tiempo = " + duration + " ns (" + durationSegundos + " segundos)");
        System.out.println("Ejercicio fibonacci recursivo con PD");
        start = System.nanoTime();
        resultado = ejerciciosPD.getFibonaciPD(50L);
        end = System.nanoTime();
        duration = end - start;
        durationSegundos = (double)duration / (double)1.0E9F;
        System.out.println("Resultado: " + resultado + " en tiempo = " + duration + " ns (" + durationSegundos + " segundos)");
    }
}
