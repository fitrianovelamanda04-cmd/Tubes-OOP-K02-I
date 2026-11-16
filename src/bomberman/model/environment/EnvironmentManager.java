package bomberman.model.environment;

import bomberman.model.Position;
import bomberman.model.map.GameMap;
import bomberman.model.map.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Mengumpulkan dan menjalankan seluruh mekanisme lingkungan pada satu map. */
public class EnvironmentManager {
    private final List<EnvironmentMechanic> mechanics;

    public EnvironmentManager(List<EnvironmentMechanic> mechanics) {
        this.mechanics = Collections.unmodifiableList(new ArrayList<>(mechanics));
    }

    /** Memindai map dan mengambil semua tile yang merupakan EnvironmentMechanic. */
    public static EnvironmentManager fromMap(GameMap map) {
        List<EnvironmentMechanic> found = new ArrayList<>();
        for (int r = 0; r < map.rows(); r++) {
            for (int c = 0; c < map.cols(); c++) {
                Tile tile = map.getTile(new Position(r, c));
                if (tile instanceof EnvironmentMechanic mechanic) {
                    found.add(mechanic);
                }
            }
        }
        return new EnvironmentManager(found);
    }

    public void updateAll(double dt) {
        for (EnvironmentMechanic m : mechanics) {
            m.update(dt);
        }
    }

    public void resetAll() {
        for (EnvironmentMechanic m : mechanics) {
            m.reset();
        }
    }

    public int size() { return mechanics.size(); }
}
