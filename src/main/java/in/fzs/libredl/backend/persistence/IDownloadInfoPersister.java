package in.fzs.libredl;

public interface IDownloadInfoPersister {

    Iterator<DownloadInfo> retrieve();
    void persist(Iterator<DownloadInfo> download_info_iterator);

}
