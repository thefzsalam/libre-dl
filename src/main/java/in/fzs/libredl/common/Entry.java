package in.fzs.libredl.common;

import android.support.annotation.NonNull;

import java.util.Map;

public class Entry<T> {
    @NonNull
    public final long id;
    @NonNull
    public final T item;

    public Entry(long id, T item) {
        this.id = id;
        this.item = item;
    }

    public Entry(Map.Entry<Long,T> entry) {
        this.id = entry.getKey();
        this.item = entry.getValue();
    }
}
