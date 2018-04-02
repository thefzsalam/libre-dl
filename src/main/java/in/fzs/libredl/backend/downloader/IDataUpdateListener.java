package in.fzs.libredl.backend.downloader;

import in.fzs.libredl.backend.persistence.DownloadInfo;
import in.fzs.libredl.common.Entry;

public interface IDataUpdateListener {

    public void acknowledge_update(Entry<DownloadInfo> download_info_entry);

}
