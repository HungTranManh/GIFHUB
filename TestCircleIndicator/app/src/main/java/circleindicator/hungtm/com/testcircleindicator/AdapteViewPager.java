package circleindicator.hungtm.com.testcircleindicator;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapteViewPager extends PagerAdapter {
    List<ItemFaceData> itemFaceDatas;

    public AdapteViewPager(List<ItemFaceData> itemFaceDatas) {
        this.itemFaceDatas = itemFaceDatas;
    }

    @Override
    public int getCount() {
        return itemFaceDatas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater=LayoutInflater.from(container.getContext());
        View view=inflater.inflate(R.layout.item_face,container,false);
        ImageView ivIcon=view.findViewById(R.id.iv_face_icon);
        TextView tvIcon=view.findViewById(R.id.tv_face_icon);
        ivIcon.setImageResource(itemFaceDatas.get(position).getIdImageItem());
        tvIcon.setText(itemFaceDatas.get(position).getTvItem());
        container.addView(view);
        return view;
    }
}
