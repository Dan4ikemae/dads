import java.util.List;

public abstract class Search {
    protected final Vertex start;

    public Search(Vertex start) {
        this.start = start;
    }

    public abstract boolean hasPathTo(Vertex destination);

    public abstract List<Vertex> pathTo(Vertex destination);
}
