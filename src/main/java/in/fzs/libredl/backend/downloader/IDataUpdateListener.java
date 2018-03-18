package in.fzs.libredl.downloader;

public interface IDataUpdateListener {

    public void acknowledge_update(Entry<DownloadInfo> download_info_entry);

}
