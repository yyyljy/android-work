package multi.android.material_design_pro2.recycler;

public class CardItem {
    int resId;
    String data;

    public CardItem(int resId, String data) {
        this.resId = resId;
        this.data = data;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
