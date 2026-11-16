package bomberman.model.environment;

import bomberman.model.map.TileFactory;

/** Mendaftarkan tile khusus Red Mountain (map tipe C) ke TileFactory. */
public final class RedMountainTiles {
    private RedMountainTiles() { }

    public static void registerOn(TileFactory factory) {
        factory.register('H', LavaTile::new);
    }
}
