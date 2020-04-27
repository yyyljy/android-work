package exam.day03.view.selectview.view.adapter;

public class ActorItem {
    int rImgID;
    String txtName;
    String txtDate;
    String chkBoxTxt;
    boolean chkBoxState;

    public ActorItem(int rImgID, String txtName, String txtDate, String chkBoxTxt) {
        this.rImgID = rImgID;
        this.txtName = txtName;
        this.txtDate = txtDate;
        this.chkBoxTxt = chkBoxTxt;
    }
}
