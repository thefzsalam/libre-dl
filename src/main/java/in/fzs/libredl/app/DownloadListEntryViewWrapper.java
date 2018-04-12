package in.fzs.libredl.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Locale;

import in.fzs.libredl.R;
import in.fzs.libredl.common.DownloadState;
import in.fzs.libredl.common.Entry;
import in.fzs.libredl.download_list_view.DownloadListViewData;
import in.fzs.libredl.download_list_view.IViewRequestHandler;

public class DownloadListEntryViewWrapper {

    private final View download_entry_view;
    private final TextView download_entry_name;
    private final TextView download_entry_progress;
    private final TextView download_entry_state;


    private final IViewRequestHandler view_request_handler;
    private Entry<DownloadListViewData> entry_data;

    public DownloadListEntryViewWrapper(ViewGroup parent,
                                        View convert_view,
                                        Entry<DownloadListViewData> data,
                                        IViewRequestHandler view_request_handler) {

        /* Initializing XML View variables */
        if(convert_view!=null)
            download_entry_view = convert_view;
        else
            download_entry_view = LayoutInflater.from(parent.getContext())
                                    .inflate(R.layout.download_entry,parent);
        download_entry_name = (TextView) download_entry_view.findViewById(R.id.download_entry_name);
        download_entry_progress = (TextView) download_entry_view.findViewById(R.id.download_entry_progress);
        download_entry_state = (TextView) download_entry_view.findViewById(R.id.download_entry_state);

        /* ------------------------------ */

        this.view_request_handler = view_request_handler;
        updateData(data);
    }

    protected void setActionHandlers() {
        download_entry_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(entry_data.item.state == DownloadState.RUNNING)
                    view_request_handler.request_pause_download(entry_data);
                else
                    view_request_handler.request_start_download(entry_data);
            }
        });

        download_entry_view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                view_request_handler.request_update_download(entry_data);
                return true; // yes, we consumed the long click.
            }
        });

        // TODO: Add on swipe listener for delete.
    }

    public void updateData(Entry<DownloadListViewData> data_entry) {
        this.entry_data = data_entry;
        DownloadListViewData data = data_entry.item;
        download_entry_name.setText(data.name);
        download_entry_progress.setText(String.format(Locale.US,
                "%.2f %%",data.progress*100));
        download_entry_state.setText(data.state.toString());
    }

    public View getDownloadEntryView() {
        return download_entry_view;
    }
}
