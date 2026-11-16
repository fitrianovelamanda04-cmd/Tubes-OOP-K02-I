package bomberman.model.map;

import bomberman.model.BombType;
import bomberman.model.Position;

/** F04.2.1: tidak dapat dihancurkan. */
public class IndestructibleBlock extends Block {
    public IndestructibleBlock(Position position) {
        super(position);
    }

    @Override public boolean isDestructibleBy(BombType type) { return false; }
    @Override public char symbol() { return '#'; }
}
