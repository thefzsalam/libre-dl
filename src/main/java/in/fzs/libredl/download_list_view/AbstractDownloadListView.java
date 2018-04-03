package in.fzs.libredl.download_list_view;

import in.fzs.libredl.common.Entry;

public abstract class AbstractDownloadListView {

    protected final IViewRequestHandler view_request_dispatcher;

    public AbstractDownloadListView(IViewRequestHandler view_request_dispatcher) {
        this.view_request_dispatcher = view_request_dispatcher;
    }

    public abstract Entry<DownloadListViewData> add_to_view(DownloadListViewData data);
    public abstract void update_view(Entry<DownloadListViewData> entry);
    public abstract void delete_from_view(Entry<DownloadListViewData> entry);

}
