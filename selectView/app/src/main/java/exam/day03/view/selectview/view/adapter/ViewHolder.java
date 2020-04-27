package exam.day03.view.selectview.view.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import exam.day03.view.selectview.R;

public class ViewHolder {
    ImageView actorImgView;
    TextView actorNameTxtView;
    TextView actorDateTxtView;
    TextView actorChkboxView;
    CheckBox actorChkboxboxView;

    public ViewHolder(View parentView) {
        this.actorImgView = parentView.findViewById(R.id.myImg);
        this.actorNameTxtView = parentView.findViewById(R.id.name);
        this.actorDateTxtView = parentView.findViewById(R.id.date);
        this.actorChkboxView = parentView.findViewById(R.id.resultinfo);
        this.actorChkboxboxView = parentView.findViewById(R.id.exam_chk);
    }
}
