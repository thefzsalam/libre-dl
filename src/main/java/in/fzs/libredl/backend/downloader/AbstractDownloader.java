package in.fzs.libredl.backend.downloader;

import in.fzs.libredl.backend.persistence.DownloadInfo;
import in.fzs.libredl.common.Entry;

public abstract class AbstractDownloader {

    protected IDataUpdateListener data_update_listener;

    public AbstractDownloader(IDataUpdateListener data_update_listener) {
        this.data_update_listener = data_update_listener;
    }

    public abstract Entry<DownloadInfo> add_download(DownloadInfo download_info);
    public abstract void                update_download(Entry<DownloadInfo> download_info_entry);
    public abstract void                delete_download(Entry<DownloadInfo> download_info_entry);
};
