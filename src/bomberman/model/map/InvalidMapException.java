package bomberman.model.map;

/** Map melanggar aturan validasi F00.3. */
public class InvalidMapException extends MapException {
    public InvalidMapException(String message) {
        super(message);
    }
}
