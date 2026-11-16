package bomberman.model.map;

import bomberman.model.BombType;
import bomberman.model.Position;

/** Block (F04). Selama aktif: menghalangi gerak dan menghentikan Explosion. */
public abstract class Block extends Tile {
    protected boolean active = true;

    protected Block(Position position) {
        super(position);
    }

    public boolean isActive() { return active; }

    /** Apakah block ini dapat dihancurkan oleh jenis bomb tertentu. */
    public abstract boolean isDestructibleBy(BombType type);

    /**
     * Dipanggil ketika Explosion mengenai block.
     * @return true jika block hancur oleh ledakan ini
     */
    public boolean onExplosion(BombType type) {
        if (active && isDestructibleBy(type)) {
            active = false;
            return true;
        }
        return false;
    }

    @Override public boolean isWalkable() { return !active; }
    @Override public boolean blocksExplosion() { return active; }
}
