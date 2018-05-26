package circleindicator.hungtm.com.tablayoutdemo.Topic;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import circleindicator.hungtm.com.tablayoutdemo.MainActivity;
import circleindicator.hungtm.com.tablayoutdemo.R;

public class FragmentTopic extends Fragment implements AdapterTopic.ITopicAdapte {
    private List<ItemTopic> lsvItemTopic;
    private AdapterTopic adapter;
    ListView lvTopic;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_topic, container, false);
        inits(view);
        return view;
    }

    private void inits(View view) {
        lsvItemTopic = new ArrayList<>();
        lsvItemTopic.add(new ItemTopic(R.drawable.im_1,
                "Vova"));
        lsvItemTopic.add(new ItemTopic(R.drawable.im_2,
                "Dân gian"));
        lsvItemTopic.add(new ItemTopic(R.drawable.im_3,
                "Gia đình"));
        lsvItemTopic.add(new ItemTopic(R.drawable.im_4,
                "Tình yêu"));
        lsvItemTopic.add(new ItemTopic(R.drawable.im_5,
                "Tiếu lâm"));
        lsvItemTopic.add(new ItemTopic(R.drawable.im_6,
                "Công Sở"));
        lsvItemTopic.add(new ItemTopic(R.drawable.im_7,
                "Học Sinh"));
        lsvItemTopic.add(new ItemTopic(R.drawable.im_10,
                "Truyện ngắn"));
        lsvItemTopic.add(new ItemTopic(R.drawable.im_12,
                "Cười 18+"));
        lsvItemTopic.add(new ItemTopic(R.drawable.im_13,
                "Y Học"));
        lsvItemTopic.add(new ItemTopic(R.drawable.im_15,
                "thế Giới"));
        lsvItemTopic.add(new ItemTopic(R.drawable.im_22,
                "Tây Du Kí Chế"));

        lvTopic = (ListView) view.findViewById(R.id.lv_topic);
        adapter = new AdapterTopic(lsvItemTopic, this);
        lvTopic.setAdapter(adapter);
    }

    @Override
    public void openTopic(int position) {
        ((MainActivity) getActivity()).openStore(lsvItemTopic.get(position).getTvTopic());
    }
}
