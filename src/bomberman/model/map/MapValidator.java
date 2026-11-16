package bomberman.model.map;

import bomberman.model.Position;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/** Validasi map sesuai F00.3. */
public class MapValidator {
    public static final int EXPECTED_ROWS = 10;
    public static final int EXPECTED_COLS = 14;
    public static final int EXPECTED_ENEMY_SPAWNS = 5;

    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void validate(GameMap map) throws InvalidMapException {
        checkSize(map);
        checkSpawnCounts(map);
        checkPath(map);
    }

    private void checkSize(GameMap map) throws InvalidMapException {
        if (map.rows() != EXPECTED_ROWS || map.cols() != EXPECTED_COLS) {
            throw new InvalidMapException("Ukuran map harus " + EXPECTED_COLS + " x " + EXPECTED_ROWS
                + " tile, ditemukan " + map.cols() + " x " + map.rows());
        }
    }

    private void checkSpawnCounts(GameMap map) throws InvalidMapException {
        expectCount("titik spawn Player", map.playerSpawns().size(), 1);
        expectCount("titik spawn Normal Enemy", map.enemySpawns().size(), EXPECTED_ENEMY_SPAWNS);
        expectCount("titik spawn Boss", map.bossSpawns().size(), 1);
        expectCount("pintu keluar", map.exits().size(), 1);
        // Spawn selalu berada di FloorTile dan tiap sel hanya berisi satu simbol,
        // sehingga spawn tidak bisa menempati block maupun saling bertumpuk.
    }

    private void expectCount(String label, int actual, int expected) throws InvalidMapException {
        if (actual != expected) {
            throw new InvalidMapException("Map harus memiliki tepat " + expected + " " + label
                + ", ditemukan " + actual);
        }
    }

    /**
     * Pemeriksaan jalur (BFS dari Player). Block yang dapat dihancurkan dianggap bisa dilewati;
     * hanya IndestructibleBlock yang benar-benar menutup jalan.
     * TODO: pertimbangkan mekanisme lingkungan (Gate/Switch) setelah tipe map dipastikan.
     */
    private void checkPath(GameMap map) throws InvalidMapException {
        Position start = map.playerSpawns().get(0);
        Set<Position> reachable = bfs(map, start);
        Position boss = map.bossSpawns().get(0);
        Position exit = map.exits().get(0);
        if (!reachable.contains(boss)) {
            throw new InvalidMapException("Area Boss tidak dapat dicapai dari titik spawn Player");
        }
        if (!reachable.contains(exit)) {
            throw new InvalidMapException("Pintu keluar tidak dapat dicapai dari titik spawn Player");
        }
    }

    private Set<Position> bfs(GameMap map, Position start) {
        Set<Position> visited = new HashSet<>();
        Deque<Position> queue = new ArrayDeque<>();
        visited.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            Position cur = queue.poll();
            for (int[] d : DIRS) {
                Position next = cur.plus(d[0], d[1]);
                if (map.inBounds(next) && !visited.contains(next) && isPassableForPath(map.getTile(next))) {
                    visited.add(next);
                    queue.add(next);
                }
            }
        }
        return visited;
    }

    private boolean isPassableForPath(Tile tile) {
        return !(tile instanceof IndestructibleBlock);
    }
}
