package bomberman.model.map;

/** File map tidak bisa dibaca / simbol tidak dikenal / baris tidak rata. */
public class MapFormatException extends MapException {
    public MapFormatException(String message) {
        super(message);
    }

    public MapFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
