package in.fzs.libredl.app.download_list_view;

import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.HashMap;
import java.util.Map;

import in.fzs.libredl.common.Entry;
import in.fzs.libredl.download_list_view.AbstractDownloadListView;
import in.fzs.libredl.download_list_view.DownloadListViewData;
import in.fzs.libredl.download_list_view.IViewRequestHandler;

public class DownloadListView extends AbstractDownloadListView {

    private class Widgets {
        ListView download_list;
        View add_btn;
    }

    private final Widgets widgets;
    private final Map<Long,DownloadListViewData> download_list_entries;
    private final BaseAdapter download_list_adapter;

    private long id_of_last_download_list_entry = 0;


    public DownloadListView(IViewRequestHandler view_request_handler, Widgets widgets) {
        super(view_request_handler);
        this.widgets = widgets;
        download_list_entries = new HashMap<>();
        initializeWidgets();
        download_list_adapter = new DownloadListAdapter(download_list_entries, view_request_handler);
    }

    @Override
    public Entry<DownloadListViewData> add_to_view(DownloadListViewData data) {
        id_of_last_download_list_entry += 1;
        download_list_entries.put(id_of_last_download_list_entry, data);
        notifyListViewOfDataChange();
        return new Entry<>(id_of_last_download_list_entry, data);
    }

    @Override
    public void update_view(Entry<DownloadListViewData> entry) {
        download_list_entries.put(entry.id, entry.item);
        notifyListViewOfDataChange();
    }

    @Override
    public void delete_from_view(Entry<DownloadListViewData> entry) {
        download_list_entries.remove(entry.id);
        notifyListViewOfDataChange();
    }

    private void initializeWidgets() {
        widgets.download_list.setAdapter(download_list_adapter);
        widgets.add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view_request_handler.request_add_download();
            }
        });
        /** TODO:
         *  - Add delete and update button.
         *      In download_entry.xml or the action bar of list view.
         *  TODO: More info
         *  Tell DownloadListAdapter how to handle edit, delete, pause/start actions.
         */
    }

    private void notifyListViewOfDataChange() {
        download_list_adapter.notifyDataSetChanged();
    }
}
