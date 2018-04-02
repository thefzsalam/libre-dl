package in.fzs.libredl.backend.persistence;

import java.util.Iterator;

public interface IDownloadInfoPersister {

    Iterator<DownloadInfo> retrieve();
    void persist(Iterator<DownloadInfo> download_info_iterator);

}
