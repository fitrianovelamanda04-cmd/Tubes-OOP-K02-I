package bomberman.model.map;

import bomberman.model.BombType;
import bomberman.model.Position;
import bomberman.model.PowerUpType;

import java.util.Optional;

/** F04.2.2: hancur oleh semua jenis bomb, dapat menyimpan Power-Up. */
public class DestructibleBlock extends Block {
    private PowerUpType hiddenPowerUp; // null bila tidak ada

    public DestructibleBlock(Position position) {
        super(position);
    }

    public Optional<PowerUpType> hiddenPowerUp() { return Optional.ofNullable(hiddenPowerUp); }
    public void setHiddenPowerUp(PowerUpType type) { this.hiddenPowerUp = type; }

    @Override public boolean isDestructibleBy(BombType type) { return true; }
    @Override public char symbol() { return 'D'; }
}
