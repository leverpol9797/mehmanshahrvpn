# MehmanshahrVpn

**MehmanshahrVpn** is an independent Android VPN client for the official
[CluvexStudio/Aether](https://github.com/CluvexStudio/Aether) networking core.

The application interface was originally developed as **AetherGUI** and is
rebranded here as **MehmanshahrVpn** by **Hossein Akhlaghi**. It is not part of
the upstream Aether project, which remains the networking engine distributed
under GPL-3.0.

Version 2.2.1 bundles official, unmodified Aether Core v2.3.0, the verified
Psiphon helper, Lyrebird, and the Xray routing engine, and provides system-wide
VPN routing (TUN) or local SOCKS5/HTTP proxies.

[Releases](https://github.com/leverpol9797/mehmanshahrvpn/releases) · [Security policy](SECURITY.md) · [Contributing](CONTRIBUTING.md)

## Downloads

Download the [v2.2.1](https://github.com/leverpol9797/mehmanshahrvpn/releases/tag/v2.2.1) Android release:

- [`MehmanshahrVpn-v2.2.1-Android-ARM64.apk`](https://github.com/leverpol9797/mehmanshahrvpn/releases/download/v2.2.1/MehmanshahrVpn-v2.2.1-Android-ARM64.apk) — 64-bit ARM APK (recommended).
- [`MehmanshahrVpn-v2.2.1-Android-ARMv7.apk`](https://github.com/leverpol9797/mehmanshahrvpn/releases/download/v2.2.1/MehmanshahrVpn-v2.2.1-Android-ARMv7.apk) — 32-bit ARM APK.
- [`SHA256SUMS.txt`](https://github.com/leverpol9797/mehmanshahrvpn/releases/download/v2.2.1/SHA256SUMS.txt) — release checksums.

Android release packages are signed with the MehmanshahrVpn release key. Android 8.0
(API 26) or newer is supported; only ARMv7 and ARM64 ABIs are distributed.

## Update source configuration

The app checks the latest GitHub Release endpoint:

```text
https://api.github.com/repos/leverpol9797/mehmanshahrvpn/releases/latest
```

Future Android releases must include:

- `MehmanshahrVpn-v<version>-Android-ARM64.apk`
- `MehmanshahrVpn-v<version>-Android-ARMv7.apk`
- SHA-256 asset digests supplied by GitHub or a `SHA256SUMS.txt` asset
- Release notes in the GitHub release body
- Android APKs signed with the same established signing key

## Android usage

1. Install the APK matching the device architecture.
2. Approve the Android VPN permission on first connection.
3. Select the desired mode and protocol.
4. Press **Connect**.
5. Optionally add the **MehmanshahrVpn** Quick Settings tile.

The Android application ID is `io.github.hamvex.mehmanshahrvpn`.

## Building

### Prerequisites

- Node.js 22
- Rust stable
- Java 17
- Android SDK and NDK `27.2.12479018`

### Android

Release signing credentials are required for distributable Android builds:

```powershell
$env:ANDROID_KEYSTORE_PATH = ".android-signing/mehmanshahrvpn.jks"
$env:ANDROID_KEYSTORE_PASSWORD = "<password>"
$env:ANDROID_KEY_ALIAS = "mehmanshahrvpn"
$env:ANDROID_KEY_PASSWORD = "<password>"
npm run fetch:android
Set-Location android
./gradlew.bat assembleRelease bundleRelease lintRelease
```

Android output is written under `android/app/build/outputs`.

### Universal release archive

After the Android build completes:

```powershell
npm run package:release
```

This creates the architecture-specific Android packages and `SHA256SUMS.txt` under
`release`.

## Verification

```powershell
npm test
cargo test --manifest-path src-tauri/Cargo.toml --locked
Set-Location android
./gradlew.bat testDebugUnitTest lintDebug lintRelease
```

## Attribution

MehmanshahrVpn is an independent frontend and is not the upstream Aether project. Aether remains the networking engine and is distributed under GPL-3.0. See [NOTICE.md](NOTICE.md), [TRADEMARK.md](TRADEMARK.md), and [LICENSE](LICENSE).
