package bomberman.model.map;

import bomberman.model.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Map permainan (F07): grid tile + titik spawn dan exit. */
public class GameMap {
    private final String name;
    private final Grid<Tile> tiles;
    private final List<Position> playerSpawns = new ArrayList<>();
    private final List<Position> enemySpawns = new ArrayList<>();
    private final List<Position> bossSpawns = new ArrayList<>();
    private final List<Position> exits = new ArrayList<>();

    public GameMap(String name, int rows, int cols) {
        this.name = name;
        this.tiles = new Grid<>(rows, cols);
    }

    public String name() { return name; }
    public int rows() { return tiles.rows(); }
    public int cols() { return tiles.cols(); }
    public boolean inBounds(Position p) { return tiles.inBounds(p); }

    public Tile getTile(Position p) { return tiles.get(p); }
    public void setTile(Position p, Tile tile) { tiles.set(p, tile); }

    public boolean isWalkable(Position p) {
        return inBounds(p) && getTile(p).isWalkable();
    }

    public boolean blocksExplosion(Position p) {
        return !inBounds(p) || getTile(p).blocksExplosion();
    }

    /** Ganti tile (mis. block yang hancur) dengan lantai kosong. */
    public void removeBlock(Position p) {
        if (getTile(p) instanceof Block) {
            setTile(p, new FloorTile(p));
        }
    }

    public void addPlayerSpawn(Position p) { playerSpawns.add(p); }
    public void addEnemySpawn(Position p) { enemySpawns.add(p); }
    public void addBossSpawn(Position p) { bossSpawns.add(p); }
    public void addExit(Position p) { exits.add(p); }

    public List<Position> playerSpawns() { return Collections.unmodifiableList(playerSpawns); }
    public List<Position> enemySpawns() { return Collections.unmodifiableList(enemySpawns); }
    public List<Position> bossSpawns() { return Collections.unmodifiableList(bossSpawns); }
    public List<Position> exits() { return Collections.unmodifiableList(exits); }
}
