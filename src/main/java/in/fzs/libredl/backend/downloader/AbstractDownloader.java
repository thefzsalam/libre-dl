package in.fzs.libredl.backend.downloader;

import in.fzs.libredl.backend.persistence.DownloadInfo;
import in.fzs.libredl.common.Entry;

public abstract class AbstractDownloader {

    protected IDataUpdateListener data_update_listener;

    public AbstractDownloader(IDataUpdateListener data_update_listener) {
        this.data_update_listener = data_update_listener;
    }

    /* The Main class is responsible for assigning `id`s to download_info_entry. */
    public abstract void add_download(Entry<DownloadInfo> download_info_entry);
    public abstract void update_download(Entry<DownloadInfo> download_info_entry);
    public abstract void delete_download(Entry<DownloadInfo> download_info_entry);
};
