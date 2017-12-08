package tk.hongbo.scrollview.adapter;

import com.airbnb.epoxy.EpoxyAdapter;

import java.util.List;

import tk.hongbo.scrollview.data.NewVo;
import tk.hongbo.scrollview.model.FilterModel;
import tk.hongbo.scrollview.model.NewModel;

/**
 * Created by HONGBO on 2017/12/7 19:11.
 */

public class NewAdapter extends EpoxyAdapter {

    List<NewVo> data;

    public NewAdapter(List<NewVo> data) {
        this.data = data;
        addNewsModel();
    }

    private void addNewsModel() {
        if (data != null && data.size() > 0) {
            for (int i = 0; i < data.size(); i++) {
                NewVo vo = data.get(i);
                if (i == 5) {
                    //第5个增加过滤器
                    addModel(new FilterModel());
                }
                addModel(new NewModel(vo.title));
            }
        }
    }
}
