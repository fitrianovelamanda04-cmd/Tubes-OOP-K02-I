package bomberman.model;

/**
 * Posisi pada grid (0-based). Placeholder: koordinasikan dengan peran A/B
 * bila kelas Position bersama sudah dibuat, lalu hapus salah satunya.
 */
public record Position(int row, int col) {
    public Position plus(int dRow, int dCol) {
        return new Position(row + dRow, col + dCol);
    }
}
