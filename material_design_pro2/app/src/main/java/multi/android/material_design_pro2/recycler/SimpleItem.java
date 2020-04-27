package multi.android.material_design_pro2.recycler;

public class SimpleItem {
    String data;

    public SimpleItem(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SimpleItem{" +
                "data='" + data + '\'' +
                '}';
    }
}
