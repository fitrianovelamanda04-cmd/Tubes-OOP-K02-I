package bomberman.model.map;

import bomberman.model.Position;

/** Walkable Space ('.'). Tile spawn (P, E, B, X) juga berdiri di atas FloorTile. */
public class FloorTile extends Tile {
    public FloorTile(Position position) {
        super(position);
    }

    @Override public boolean isWalkable() { return true; }
    @Override public boolean blocksExplosion() { return false; }
    @Override public char symbol() { return '.'; }
}
