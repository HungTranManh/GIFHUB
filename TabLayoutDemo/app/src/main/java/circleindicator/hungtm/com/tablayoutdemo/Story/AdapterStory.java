package circleindicator.hungtm.com.tablayoutdemo.Story;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import circleindicator.hungtm.com.tablayoutdemo.R;

public class AdapterStory extends BaseAdapter {
    private List<ItemStory> lsvItemStory;
    private IStoreAdapter iStoreAdapter;

    public AdapterStory(List<ItemStory> lsvItemStory, IStoreAdapter iStoreAdapter) {
        this.lsvItemStory = lsvItemStory;
        this.iStoreAdapter = iStoreAdapter;
    }

    @Override
    public int getCount() {
        return  lsvItemStory.size();
    }

    @Override
    public Object getItem(int position) {
        return lsvItemStory.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        if(convertView==null){
            LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
            convertView=inflater.inflate(R.layout.item_story,viewGroup,false);
        }
        ImageView ivIconStore=convertView.findViewById(R.id.iv_icon_store);
        TextView tvStore=convertView.findViewById(R.id.tv_icon_store);
        ItemStory itemStore=lsvItemStory.get(position);
        ivIconStore.setImageResource(itemStore.getIdImageStory());
        tvStore.setText(itemStore.getTvStory());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iStoreAdapter.openDetail(position);

            }
        });
        return convertView;
    }
    public interface IStoreAdapter{
        void openDetail(int position);
    }
}
