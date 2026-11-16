package bomberman.model.environment;

/** Mekanisme lingkungan map (F07.3). Diimplementasikan per tipe map (Strategy/polymorphism). */
public interface EnvironmentMechanic {
    /** Maju sebesar dt detik. Dipanggil dari Bomb and Map Loop; tidak dipanggil saat PAUSED. */
    void update(double dt);

    /** Kembali ke kondisi awal (restart, F00.4). */
    void reset();
}
