# TLE SCHEDULE App Package

Web App URL:
https://script.google.com/macros/s/AKfycbxzlIS5-PrPukc5DuIVRPoBtg0nT9rDfjF-27E50IC5qfveW6skVZ9eAUgZ0VS9ReA8/exec

## Isi paket

- `android/` — Android Studio/Gradle project. Membuka TLE SCHEDULE melalui Chrome Custom Tab agar login Google memakai browser system.
- `windows/` — .NET 8 Windows launcher. Membuka Microsoft Edge dengan `--app=URL`; fallback ke browser default.
- `download-page/` — halaman download yang dapat dihosting melalui GitHub Pages, Google Sites (dengan link file), hosting biasa, atau server perusahaan.
- `.github/workflows/release.yml` — GitHub Actions untuk build APK + Windows Setup otomatis.

## Cara tercepat menghasilkan APK + Setup.exe tanpa install Android Studio

1. Buat repository GitHub baru, misalnya `tle-schedule-app`.
2. Upload seluruh isi folder paket ini ke repository tersebut.
3. Buka tab **Actions** > **Build TLE SCHEDULE Apps** > **Run workflow** untuk pengujian build.
4. Untuk membuat file Release yang bisa didownload melalui link, buat tag seperti `v1.0.0` lalu push tag tersebut.
5. Workflow akan membuat:
   - `TLE-SCHEDULE-Android.apk`
   - `TLE-SCHEDULE-Windows-Setup.exe`
6. Kedua file akan muncul pada halaman GitHub Release.

## Halaman download

Setelah binary selesai dibuat, copy kedua file berikut ke folder yang sama dengan `download-page/index.html`:

- `TLE-SCHEDULE-Android.apk`
- `TLE-SCHEDULE-Windows-Setup.exe`

Lalu host folder `download-page` melalui layanan hosting pilihan Anda.

## Catatan keamanan

Android sengaja memakai Chrome Custom Tab, bukan WebView login Google. Windows memakai browser Microsoft Edge dalam mode app. Ini menjaga kompatibilitas login Google pada Web App Apps Script yang berjalan sebagai user.

## Release signing Android

Workflow default menghasilkan APK debug-signed yang cocok untuk distribusi internal/testing. Jika nantinya akan dipublikasikan ke Google Play atau distribusi produksi resmi, tambahkan release keystore dan signing secrets.
