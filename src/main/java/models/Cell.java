package models;

public class Cell {
    public int row;
    public int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return this.col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String toString() {
        return "[row=" + this.row + ", col=" + this.col + "]";
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = 31 * result + this.row;
        result = 31 * result + this.col;
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            Cell other = (Cell)obj;
            if (this.row != other.row) {
                return false;
            } else {
                return this.col == other.col;
            }
        }
    }
}
