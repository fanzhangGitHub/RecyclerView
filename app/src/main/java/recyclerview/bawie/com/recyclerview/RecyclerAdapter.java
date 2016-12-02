package recyclerview.bawie.com.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import java.util.Random;

/**
 * Created by ZhangFanfan on 2016/12/1.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<String>list;
    private Context context;
    Random r = new Random();
    public RecyclerAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.layout_item,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
     int i = r.nextInt(50)+400;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(i,i);
        holder.tv.setLayoutParams(params);
        holder.tv.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
         TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
           tv = (TextView) itemView.findViewById(R.id.tv_item);


        }
    }

}
