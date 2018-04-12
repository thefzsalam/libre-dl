package in.fzs.libredl.common;

import java.util.Map;

public class Entry<T> {
    public final long id;
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
