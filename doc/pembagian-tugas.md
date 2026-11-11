# Pembagian Tugas Kelompok _nomor_ - Nangor Blast

**Map:** _tipe map_ · **Asisten:** _nama_ · **Tanggal disepakati:** _tanggal_

## 1. Anggota dan peran

| Nama | NIM | Peran | Reviewer kode (rotasi) |
|---|---|---|---|
| _nama_ | _NIM_ | A: Core & Game Flow | direview oleh _D_ |
| _nama_ | _NIM_ | B: Player, Bomb, Explosion, Power-Up | direview oleh _A_ |
| _nama_ | _NIM_ | C: Enemy & Boss | direview oleh _B_ |
| _nama_ | _NIM_ | D: Map, Block, Environment | direview oleh _C_ |

## 2. Rincian tanggung jawab

### A: Core & Game Flow

| Task | Spek | Target | Status |
|---|---|---|---|
| Setup repo, build tool, Makefile | - | | ⬜ |
| Game loop dan model thread | F09 | | ⬜ |
| Input keyboard real-time | F01 | | ⬜ |
| Menu utama dan How to Play | F09.1 | | ⬜ |
| Game state, pause, game over | F09.2-F09.5 | | ⬜ |
| Inisialisasi dan restart | F00 | | ⬜ |
| Score dan timer | F08 | | ⬜ |
| Logging (SLF4J) | - | | ⬜ |

### B: Player, Bomb, Explosion, Power-Up

| Task | Spek | Target | Status |
|---|---|---|---|
| Player: gerak, nyawa, respawn, invulnerable | F01 | | ⬜ |
| Bomb: Normal, Pumped, Remote | F02 | | ⬜ |
| Pemilihan jenis bomb dan detonasi | F02.3 | | ⬜ |
| Explosion dan penyebarannya | F03 | | ⬜ |
| Chain explosion (dibatasi) | F03 | | ⬜ |
| Power-Up dan peluang drop | F06 | | ⬜ |

### C: Enemy & Boss

| Task | Spek | Target | Status |
|---|---|---|---|
| Enemy dasar dan kontak damage | F05.1 | | ⬜ |
| Patrol Enemy | F05.2 | | ⬜ |
| Chase Enemy (PATROL/CHASE) | F05.2 | | ⬜ |
| Mekanisme serangan boss (warning, cooldown, rentan) | F05.3.1 | | ⬜ |
| Boss map: pola serangan fase 1 dan 2 | F05.3.x | | ⬜ |

### D: Map, Block, Environment

| Task | Spek | Target | Status |
|---|---|---|---|
| Block: 3 jenis | F04 | | ⬜ |
| Loader map dari `config/` | F07 | | ⬜ |
| Validator map (termasuk cek jalur) | F00.3 | | ⬜ |
| Mekanisme lingkungan map | F07.3.x | | ⬜ |
| Renderer CLI dan HUD | - | | ⬜ |

## 3. Tugas bersama

| Tugas | Penanggung jawab | Target |
|---|---|---|
| README | D | |
| Buklet: cover, user manual | _nama_ | |
| Buklet: struktur objek, design pattern | _nama_ | |
| Buklet: cerita proses pengembangan | _nama_ | |
| Log activity (digabung jadi satu dokumen) | _nama_ (pengumpul), semua mengisi sendiri | |
| Integration test tiap sprint | semua | |
| Persiapan demo | semua | |

## 4. Riwayat perubahan pembagian

| Tanggal | Perubahan | Alasan |
|---|---|---|
| | | |
