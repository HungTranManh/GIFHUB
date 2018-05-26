package circleindicator.hungtm.com.tablayoutdemo.Topic;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import circleindicator.hungtm.com.tablayoutdemo.R;

public class AdapterTopic extends BaseAdapter {
    private List<ItemTopic> itemTopics;
    private ITopicAdapte iTopicAdapte;

    public AdapterTopic(List<ItemTopic> itemTopics, ITopicAdapte iTopicAdapte) {
        this.itemTopics = itemTopics;
        this.iTopicAdapte = iTopicAdapte;
    }

    @Override
    public int getCount() {
        return itemTopics.size();
    }

    @Override
    public Object getItem(int position) {
        return itemTopics.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        if(convertView==null){
            LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
            convertView=inflater.inflate(R.layout.item_topic,viewGroup,false);
        }
        ImageView imageView=convertView.findViewById(R.id.iv_icon_topic);
        TextView textView=convertView.findViewById(R.id.tv_icon_topic);
        ItemTopic itemTopic=itemTopics.get(position);
        imageView.setImageResource(itemTopic.getIdImageTopic());
        textView.setText(itemTopic.getTvTopic());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iTopicAdapte.openTopic(position);
            }
        });
        return convertView;
    }
    public interface ITopicAdapte{
        void openTopic(int position);
    }
}
