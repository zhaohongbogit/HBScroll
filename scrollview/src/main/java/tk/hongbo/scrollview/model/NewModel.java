package tk.hongbo.scrollview.model;

import android.view.View;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyHolder;
import com.airbnb.epoxy.EpoxyModelWithHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import tk.hongbo.scrollview.R;

/**
 * Created by HONGBO on 2017/12/7 19:15.
 */

public class NewModel extends EpoxyModelWithHolder<NewModel.NewHolder> {

    String title;

    public NewModel(String title) {
        this.title = title;
    }

    @Override
    protected NewHolder createNewHolder() {
        return new NewHolder();
    }

    @Override
    protected int getDefaultLayout() {
        return R.layout.new_item;
    }

    @Override
    public void bind(NewHolder holder) {
        super.bind(holder);
        holder.new_item_title.setText(title);
    }

    class NewHolder extends EpoxyHolder {

        @BindView(R.id.new_item_title)
        TextView new_item_title;

        @Override
        protected void bindView(View itemView) {
            ButterKnife.bind(this, itemView);
        }
    }
}
