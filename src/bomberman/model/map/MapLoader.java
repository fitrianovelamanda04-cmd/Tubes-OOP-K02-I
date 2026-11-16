package bomberman.model.map;

import bomberman.model.Position;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Memuat map dari file teks: satu karakter per tile, simbol sesuai legenda F07.2.
 * Baris kosong diabaikan. Loader hanya memeriksa format; aturan permainan
 * (ukuran 14x10, jumlah spawn, jalur) diperiksa oleh MapValidator.
 */
public class MapLoader {
    private final TileFactory factory;

    public MapLoader(TileFactory factory) {
        this.factory = factory;
    }

    public GameMap load(Path path) throws MapException {
        List<String> lines = readLines(path);
        if (lines.isEmpty()) {
            throw new MapFormatException("File map kosong: " + path);
        }

        int cols = lines.get(0).length();
        for (int r = 0; r < lines.size(); r++) {
            if (lines.get(r).length() != cols) {
                throw new MapFormatException("Panjang baris " + (r + 1) + " ("
                    + lines.get(r).length() + ") berbeda dari baris pertama (" + cols + ")");
            }
        }

        GameMap map = new GameMap(path.getFileName().toString(), lines.size(), cols);
        for (int r = 0; r < lines.size(); r++) {
            for (int c = 0; c < cols; c++) {
                char symbol = lines.get(r).charAt(c);
                Position p = new Position(r, c);
                map.setTile(p, factory.create(symbol, p));
                switch (symbol) {
                    case 'P' -> map.addPlayerSpawn(p);
                    case 'E' -> map.addEnemySpawn(p);
                    case 'B' -> map.addBossSpawn(p);
                    case 'X' -> map.addExit(p);
                    default -> { }
                }
            }
        }
        return map;
    }

    private List<String> readLines(Path path) throws MapFormatException {
        try {
            List<String> result = new ArrayList<>();
            for (String line : Files.readAllLines(path)) {
                String trimmed = line.strip();
                if (!trimmed.isEmpty()) {
                    result.add(trimmed);
                }
            }
            return result;
        } catch (IOException e) {
            throw new MapFormatException("Gagal membaca file map: " + path, e);
        }
    }
}
