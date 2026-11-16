package bomberman.model.map;

import bomberman.model.Position;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Factory tile berdasarkan simbol legenda F07.2.
 * Tile lingkungan (W, S, G, H, I, L, ...) didaftarkan lewat register() sesuai tipe map,
 * sehingga loader tidak perlu diubah (Open/Closed Principle).
 */
public class TileFactory {
    private final Map<Character, Function<Position, Tile>> creators = new HashMap<>();

    public TileFactory() {
        register('#', IndestructibleBlock::new);
        register('D', DestructibleBlock::new);
        register('R', ReinforcedBlock::new);
        register('.', FloorTile::new);
        // Simbol spawn: tile dasarnya lantai biasa.
        register('P', FloorTile::new);
        register('E', FloorTile::new);
        register('B', FloorTile::new);
        register('X', FloorTile::new);
    }

    public void register(char symbol, Function<Position, Tile> creator) {
        creators.put(symbol, creator);
    }

    public Tile create(char symbol, Position position) throws MapFormatException {
        Function<Position, Tile> creator = creators.get(symbol);
        if (creator == null) {
            throw new MapFormatException(
                "Simbol tidak dikenal '" + symbol + "' di baris " + (position.row() + 1)
                + ", kolom " + (position.col() + 1));
        }
        return creator.apply(position);
    }
}
