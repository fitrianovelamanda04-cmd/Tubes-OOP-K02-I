package bomberman.model.map;

import bomberman.model.BombType;
import bomberman.model.Position;

/** F04.2.3: hanya hancur oleh Pumped Bomb. */
public class ReinforcedBlock extends Block {
    public ReinforcedBlock(Position position) {
        super(position);
    }

    @Override public boolean isDestructibleBy(BombType type) { return type == BombType.PUMPED; }
    @Override public char symbol() { return 'R'; }
}
