package in.fzs.libredl.download_list_view;


import in.fzs.libredl.common.Entry;

public interface IViewRequestHandler {

    void request_add();
    void request_update(Entry<DownloadListViewData> entry_to_update);
    void request_delete(Entry<DownloadListViewData> entry_to_delete);

}
