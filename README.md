# Nangor Blast

Game Bomberman berbasis CLI dengan Java. Dibuat untuk Tugas Besar IF2010 Pemrograman Berorientasi Objek 2026/2027 (Kelompok K02-I).

Pemain mengendalikan Deeper untuk menjelajahi lorong bawah tanah Nangor Falls: menghancurkan block, mengalahkan 5 Normal Enemy dan Boss, lalu mencapai pintu keluar sebelum waktu (300 detik) atau nyawa habis.

Map kelompok kami: **Tipe C, Red Mountain** (kawasan vulkanik dengan Lava Tile yang erupsi berkala, boss Hades).

> Status: Milestone 1 (struktur repo, pembagian tugas, class diagram). Game belum dapat dimainkan.

## Kebutuhan

- JDK 17 atau lebih baru
- `make`

## Kompilasi dan menjalankan

```bash
make build   # kompilasi seluruh kode di src/ ke folder out/
make run     # menjalankan game
make clean   # menghapus folder out/
```


## Struktur repository

| Folder / file | Isi |
|---|---|
| `src/` | Kode program Java |
| `config/` | File map yang dimuat program (`red-mountain.txt`, satu karakter per tile sesuai legenda spesifikasi F07.2) |
| `doc/` | Dokumen PDF (pembagian tugas, class diagram, buklet) |
| `Makefile` | Otomasi build, run, clean |
| `README.md` | Dokumen ini |

## Pembagian tugas

| Peran | Anggota | NIM | Tanggung jawab |
|---|---|---|---|
| A | Khallisa Nadya Alqahtani | 18225046 | Core and Game Flow: setup repo, game loop dan thread, input keyboard, menu, game state, score dan timer, logging |
| B | Abraham Handoko | 18225068 | Player, Bomb, Explosion, Power-Up |
| C | Vandega Arozan Musholine | 18223010 | Enemy dan Boss (Hades) |
| D | Fitria Novel Amanda | 18225088 | Map, Block, Environment: block 3 jenis, loader dan validator map, mekanisme lingkungan (Lava Tile), renderer CLI dan HUD, README |

Rincian per task ada di `doc/K2_I_PembagianTugas.pdf`.

## Status fitur

| Fitur | Spek | Status |
|---|---|---|
| Inisialisasi dan validasi map | F00 | Dalam pengerjaan (loader dan validator sudah ada) |
| Player | F01 | Belum |
| Bomb | F02 | Belum |
| Explosion | F03 | Belum |
| Block | F04 | Selesai kerangka (3 jenis block) |
| Enemy dan Boss | F05 | Belum |
| Power-Up | F06 | Belum |
| Map dan mekanisme lingkungan | F07 | Dalam pengerjaan (map Red Mountain dan Lava Tile sudah ada) |
| Score | F08 | Belum |
| Game Flow (menu, pause, game over) | F09 | Belum |