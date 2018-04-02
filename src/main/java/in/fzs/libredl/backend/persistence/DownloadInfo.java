package in.fzs.libredl.backend.persistence;


import in.fzs.libredl.common.DownloadState;

public class DownloadInfo {
    String url;
    String file_path;
    DownloadState state;
    long total_bytes;
    long received_bytes;
}
