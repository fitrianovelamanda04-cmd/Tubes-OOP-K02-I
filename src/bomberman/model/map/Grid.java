package bomberman.model.map;

import bomberman.model.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/** Grid generik berukuran tetap (Generics + Collections). */
public class Grid<T> {
    private final int rows;
    private final int cols;
    private final List<List<T>> cells;

    public Grid(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Ukuran grid harus positif");
        }
        this.rows = rows;
        this.cols = cols;
        this.cells = new ArrayList<>(rows);
        for (int r = 0; r < rows; r++) {
            List<T> row = new ArrayList<>(cols);
            for (int c = 0; c < cols; c++) {
                row.add(null);
            }
            cells.add(row);
        }
    }

    public int rows() { return rows; }
    public int cols() { return cols; }

    public boolean inBounds(Position p) {
        return p.row() >= 0 && p.row() < rows && p.col() >= 0 && p.col() < cols;
    }

    public T get(Position p) {
        checkBounds(p);
        return cells.get(p.row()).get(p.col());
    }

    public void set(Position p, T value) {
        checkBounds(p);
        cells.get(p.row()).set(p.col(), value);
    }

    public void forEach(BiConsumer<Position, T> action) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Position p = new Position(r, c);
                action.accept(p, get(p));
            }
        }
    }

    private void checkBounds(Position p) {
        if (!inBounds(p)) {
            throw new IndexOutOfBoundsException("Di luar grid: " + p);
        }
    }
}
