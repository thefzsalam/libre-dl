package in.fzs.libredl.app.download_list_view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.Iterator;
import java.util.Map;

import in.fzs.libredl.common.Entry;
import in.fzs.libredl.download_list_view.DownloadListViewData;
import in.fzs.libredl.download_list_view.IViewRequestHandler;

public class DownloadListAdapter extends BaseAdapter {

    private final Map<Long,DownloadListViewData> download_list_entries;
    private final IViewRequestHandler view_request_handler;

    public DownloadListAdapter(Map<Long, DownloadListViewData> download_list_entries, IViewRequestHandler view_request_handler) {
        this.download_list_entries = download_list_entries;
        this.view_request_handler = view_request_handler;
    }

    @Override
    public int getCount() {
        return download_list_entries.size();
    }

    @Override
    public DownloadListViewData getItem(int position) {
        Iterator<Map.Entry<Long, DownloadListViewData>> itr = download_list_entries.entrySet().iterator();
        for(int i=0;i<position;i++)
            itr.next();
        return itr.next().getValue();
    }

    @Override
    public long getItemId(int position) {
        Iterator<Map.Entry<Long, DownloadListViewData>> itr = download_list_entries.entrySet().iterator();
        for(int i=0;i<position;i++)
            itr.next();
        return itr.next().getKey();
    }

    private Entry<DownloadListViewData> getEntry(int position) {
        Iterator<Map.Entry<Long, DownloadListViewData>> itr = download_list_entries.entrySet().iterator();
        for(int i=0;i<position;i++)
            itr.next();
        return new Entry<>(itr.next());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DownloadListEntryViewWrapper entry_view_wrapper =
                new DownloadListEntryViewWrapper(parent, convertView,
                                                 getEntry(position), view_request_handler);
        return entry_view_wrapper.getDownloadEntryView();
    }
}
