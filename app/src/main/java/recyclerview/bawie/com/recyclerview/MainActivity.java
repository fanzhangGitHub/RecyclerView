package recyclerview.bawie.com.recyclerview;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String>items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        StaggeredGridLayoutManager layout = new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(layout);
        //设置item增加移除动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //添加分割线
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(20,20,20,20);
            }
        });
        mRecyclerView.setAdapter(new RecyclerAdapter(items,this));
    }
    private void initDatas() {
        items  = new ArrayList<>();
        for(int i = 'A';i< 'A'+26;i++){
            items.add((char)i+"");
        }
    }
}
