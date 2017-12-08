package tk.hongbo.scrollview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tk.hongbo.scrollview.adapter.NewAdapter;
import tk.hongbo.scrollview.data.NewVo;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    NewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new NewAdapter(getData());
        recyclerView.setAdapter(adapter);
    }

    public List<NewVo> getData() {
        List<NewVo> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            NewVo vo = new NewVo();
            vo.title = "中华人民共和国" + i;
            vo.name = "我们是伟大的劳动人民建立起来的和谐家园" + i;
            data.add(vo);
        }
        return data;
    }
}
