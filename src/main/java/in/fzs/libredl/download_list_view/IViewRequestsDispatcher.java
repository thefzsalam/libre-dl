package in.fzs.libredl.download_list_view;

import in.fzs.libredl.Entry;

public interface IViewRequestsDispatcher {

    public void request_add();
    public void request_update(Entry<DownloadListViewData> entry_to_update);
    public void request_delete(Entry<DownloadListViewData> entry_to_delete);

}
