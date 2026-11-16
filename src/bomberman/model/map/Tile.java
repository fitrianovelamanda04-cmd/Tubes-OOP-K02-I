package bomberman.model.map;

import bomberman.model.Position;

/** Dasar semua isi sel map (abstract class + polymorphism). */
public abstract class Tile {
    protected final Position position;

    protected Tile(Position position) {
        this.position = position;
    }

    public Position position() { return position; }

    /** Apakah entity (player/enemy) dapat melewati tile ini. */
    public abstract boolean isWalkable();

    /** Apakah Explosion berhenti pada tile ini. */
    public abstract boolean blocksExplosion();

    /** Apakah tile sedang berbahaya bagi player (mis. Lava Tile saat ERUPTING). */
    public boolean isHazardous() { return false; }

    /** Simbol sesuai legenda F07.2. */
    public abstract char symbol();
}
