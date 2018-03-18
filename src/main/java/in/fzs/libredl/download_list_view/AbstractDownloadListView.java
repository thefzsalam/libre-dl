package in.fzs.libredl.download_list_view;

public abstract class AbstractDownloadListView {

    protected final IViewRequestsDispatcher view_request_dispatcher;

    public AbstractDownloadListView(IViewRequestsDispatcher view_request_dispatcher) {
        this.view_request_dispatcher = view_request_dispatcher;
    }

    public abstract Entry<DownloadListViewData> add_to_view(DownloadListViewData data);
    public abstract void update_view(Entry<DownloadListViewData> entry);
    public abstract void delete_from_view(Entry<DownloadListViewData> entry);

}
