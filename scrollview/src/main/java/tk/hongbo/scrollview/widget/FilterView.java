package tk.hongbo.scrollview.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import butterknife.ButterKnife;
import tk.hongbo.scrollview.R;

/**
 * 筛选View
 * Created by HONGBO on 2017/12/8 10:23.
 */

public class FilterView extends FrameLayout {

    public FilterView(@NonNull Context context) {
        this(context, null);
    }

    public FilterView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = inflate(context, R.layout.filter_view_layout, this);
        ButterKnife.bind(this, view);
    }
}
