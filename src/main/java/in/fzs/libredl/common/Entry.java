package in.fzs.libredl.common;

public class Entry<T> {
    public final long id;
    public final T item;

    public Entry(long id, T item) {
        this.id = id;
        this.item = item;
    }
}
