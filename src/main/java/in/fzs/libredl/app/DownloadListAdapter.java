package in.fzs.libredl.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.Iterator;
import java.util.Map;

import in.fzs.libredl.R;
import in.fzs.libredl.download_list_view.DownloadListViewData;

public class DownloadListAdapter extends BaseAdapter {

    private final Map<Long,DownloadListViewData> download_list_entries;

    public DownloadListAdapter(Map<Long, DownloadListViewData> download_list_entries) {
        this.download_list_entries = download_list_entries;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.download_entry,parent);
        }
        return convertView;
    }
}
