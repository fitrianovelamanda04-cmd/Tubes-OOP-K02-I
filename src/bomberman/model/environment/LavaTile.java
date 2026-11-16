package bomberman.model.environment;

import bomberman.model.Position;
import bomberman.model.map.Tile;

/**
 * Lava Tile (F07.3.3). Dapat dilalui; siklus DORMANT -> WARNING -> ERUPTING berulang.
 * DORMANT 3 detik dan WARNING 1 detik sesuai spesifikasi.
 * Durasi ERUPTING tidak ditetapkan spesifikasi: nilai default di bawah, perlu dikonfirmasi asisten.
 */
public class LavaTile extends Tile implements EnvironmentMechanic {
    public enum State { DORMANT, WARNING, ERUPTING }

    public static final double DORMANT_SECONDS = 3.0;
    public static final double WARNING_SECONDS = 1.0;
    public static final double ERUPTING_SECONDS = 1.0; // TODO: konfirmasi ke asisten

    private volatile State state = State.DORMANT;
    private volatile int eruptionCount = 0;
    private double elapsed = 0.0;

    public LavaTile(Position position) {
        super(position);
    }

    public State state() { return state; }

    /**
     * Nomor erupsi saat ini. Pemanggil (damage player) dapat mencatatnya agar player
     * hanya kehilangan satu nyawa per erupsi.
     */
    public int eruptionCount() { return eruptionCount; }

    @Override
    public void update(double dt) {
        elapsed += dt;
        boolean changed = true;
        while (changed) {
            changed = false;
            switch (state) {
                case DORMANT -> changed = advance(DORMANT_SECONDS, State.WARNING);
                case WARNING -> changed = advance(WARNING_SECONDS, State.ERUPTING);
                case ERUPTING -> changed = advance(ERUPTING_SECONDS, State.DORMANT);
            }
        }
    }

    private boolean advance(double duration, State next) {
        if (elapsed < duration) {
            return false;
        }
        elapsed -= duration;
        state = next;
        if (next == State.ERUPTING) {
            eruptionCount++;
        }
        return true;
    }

    @Override
    public void reset() {
        state = State.DORMANT;
        elapsed = 0.0;
        eruptionCount = 0;
    }

    @Override public boolean isHazardous() { return state == State.ERUPTING; }
    @Override public boolean isWalkable() { return true; }
    @Override public boolean blocksExplosion() { return false; }
    @Override public char symbol() { return 'H'; }
}
