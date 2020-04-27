package exam.day03.view.selectview.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;


public class ExamAdapter extends ArrayAdapter<ActorItem> {
    private Context context;
    private int resId;
    private ArrayList<ActorItem> actorlist;
    HashMap<Integer, SaveCheckActorState> saveData1 = new HashMap<Integer,SaveCheckActorState>();

    public ExamAdapter(Context context, int resId, ArrayList<ActorItem> actorlist) {
        super(context, resId, actorlist);
        this.context = context;
        this.resId = resId;
        this.actorlist = actorlist;
    }

    @Override
    public int getCount() {
        return actorlist.size();
    }
    @Override
    public ActorItem getItem(int position) {
        return actorlist.get(position);
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resId,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        ActorItem actorItem = actorlist.get(position);
        if(actorItem!=null){
            ImageView imageView = holder.actorImgView;
            TextView nameView = holder.actorNameTxtView;
            TextView dateView = holder.actorDateTxtView;
            TextView chkboxView = holder.actorChkboxView;
            final CheckBox chkboxboxView = holder.actorChkboxboxView;

            imageView.setImageResource(actorItem.rImgID);
            nameView.setText(actorItem.txtName);
            dateView.setText(actorItem.txtDate);
            chkboxView.setText(actorItem.chkBoxTxt);
            chkboxboxView.setChecked(actorItem.chkBoxState);

            SaveCheckActorState state = saveData1.get(position);
            if(state==null) {//저장된 객체가 없으면

            }else {
                chkboxboxView.setChecked(state.isthisChecked);
            }
            chkboxboxView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean data = chkboxboxView.isChecked();
                    SaveCheckActorState objState = new SaveCheckActorState();
                    objState.isthisChecked = data;
                    saveData1.put(position, objState);
                }
            });
        }
        return convertView;
    }
}
