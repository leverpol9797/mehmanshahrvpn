package com.firstham.aethergui;

final class UpdateConfig {
    static final String API_URL = "https://api.github.com/repos/leverpol9797/mehmanshahrvpn/releases?per_page=30";
    static final String LATEST_API_URL = "https://api.github.com/repos/leverpol9797/mehmanshahrvpn/releases/latest";
    static final String CHECKSUM_ASSET = "SHA256SUMS.txt";
    static final String RELEASE_DOWNLOAD_PREFIX = "https://github.com/leverpol9797/mehmanshahrvpn/releases/download/";
    static final String PREFS = "app_updates";
    static final String KEY_LATEST_VERSION = "latest_version";
    static final String KEY_RELEASE_NOTES = "release_notes";
    static final String KEY_DOWNLOAD_URL = "download_url";
    static final String KEY_CHECKSUM = "checksum";
    static final String KEY_DOWNLOAD_ID = "download_id";
    static final String KEY_APK_PATH = "apk_path";
    static final String KEY_NOTIFIED_VERSION = "notified_version";
    static final String KEY_AUTO_DOWNLOAD = "auto_download";
    static final String KEY_LAST_CHECKED_AT = "last_checked_at";
    static final String ACTION_STATE = "com.firstham.aethergui.UPDATE_STATE";
    static final String ACTION_DOWNLOAD = "com.firstham.aethergui.DOWNLOAD_UPDATE";
    static final String ACTION_INSTALL = "com.firstham.aethergui.INSTALL_UPDATE";

    static String releaseAsset(String version) {
        String[] abis = android.os.Build.SUPPORTED_ABIS;
        String abi = abis != null && abis.length > 0 ? abis[0] : "";
        String arch = abi.startsWith("arm64") ? "ARM64" : abi.startsWith("x86_64") ? "x86_64" : "ARMv7";
        return "MehmanshahrVpn-v" + version + "-Android-" + arch + ".apk";
    }

    private UpdateConfig() { }
}
