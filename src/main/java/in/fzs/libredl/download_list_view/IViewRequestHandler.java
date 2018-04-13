package in.fzs.libredl.download_list_view;


import in.fzs.libredl.common.Entry;

public interface IViewRequestHandler {

    void request_add_download();
    void request_update_download(Entry<DownloadListViewData> entry_to_update);
    void request_delete_download(Entry<DownloadListViewData> entry_to_delete);
    void request_pause_download(Entry<DownloadListViewData> entry_to_pause);
    void request_start_download(Entry<DownloadListViewData> entry_to_pause);
}
