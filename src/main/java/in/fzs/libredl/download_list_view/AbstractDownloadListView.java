package in.fzs.libredl.download_list_view;

import in.fzs.libredl.common.Entry;

public abstract class AbstractDownloadListView {

    /**
     * Architecture:
     * Pressing buttons in the DownloadListView will send respective
     * requests to IViewRequestHandler registered.
     * If those requests succeed, it is the responsibility of whoever handles that request
     * to let the main controller know about its success or failure and thus
     * call AbstractDownloadListView's respective methods to reflect the change in dataset.
     */
    protected final IViewRequestHandler view_request_handler;

    public AbstractDownloadListView(IViewRequestHandler view_request_handler) {
        this.view_request_handler = view_request_handler;
    }

    public abstract void add_to_view(Entry<DownloadListViewData> data);
    public abstract void update_view(Entry<DownloadListViewData> entry);
    public abstract void delete_from_view(Entry<DownloadListViewData> entry);

}
