package tk.hongbo.scrollview.model;

import com.airbnb.epoxy.EpoxyModel;

import tk.hongbo.scrollview.R;
import tk.hongbo.scrollview.widget.FilterView;

/**
 * Created by HONGBO on 2017/12/8 10:28.
 */

public class FilterModel extends EpoxyModel<FilterView> {
    @Override
    protected int getDefaultLayout() {
        return R.layout.filter_model_layout;
    }
}
