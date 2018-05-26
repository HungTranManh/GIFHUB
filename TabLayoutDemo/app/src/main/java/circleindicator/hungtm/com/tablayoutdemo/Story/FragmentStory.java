package circleindicator.hungtm.com.tablayoutdemo.Story;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import circleindicator.hungtm.com.tablayoutdemo.MainActivity;
import circleindicator.hungtm.com.tablayoutdemo.R;

public class FragmentStory extends Fragment implements AdapterStory.IStoreAdapter
{

    private String nameTopic;
    private ListView lvItemstory;
    List<ItemStory> lsvitemStory;
    private AdapterStory adapterStory;
    private Button btnBack;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_story, container, false);

        Bundle bundle=getArguments();
        nameTopic=bundle.getString("NAME");
        inits(view,nameTopic);
        btnBack=view.findViewById(R.id.btn_back);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        super.onActivityCreated(savedInstanceState);
    }

    private void inits(View view, String name) {

        lsvitemStory = new ArrayList<>();
        switch (name) {
            case "Vova":
                addStoreVova();
                break;
            case "Dân gian":
                addStoreDanGian();
                break;
            case "Gia đình":
                addStoreGiaDinh();
            default:
                break;


        }
        adapterStory =new AdapterStory(lsvitemStory,this);
        lvItemstory=view.findViewById(R.id.lv_store);
        lvItemstory.setAdapter(adapterStory);



    }


    private void addStoreVova() {
        lsvitemStory.add(new ItemStory(R.drawable.smile, "Vova đi thi học kỳ","Ngày thi học kỳ môn vấn đáp, thầy giáo kiểm tra vova:\n" +
                "\n" +
                "Em có biết trong phòng mình có bao nhiêu chiếc đèn không?\n" +
                "\n" +
                "Vova nhìn khắp nhà và nói :\n" +
                "\n" +
                "Thưa thầy có 4 chiếc bóng ạ!!!\n" +
                "\n" +
                "Thầy giáo rút ra trong túi 1 chiếc bóng đèn và nói: có 5 cái nhé, em sai rồi.\n" +
                "\n" +
                "Kỳ thì sau đó, Vova tiếp tục gặp lại ông thầy nọ, lần này thầy vẫn hỏi lại câu hỏi cũ, thầy hỏi: đố em trong phòng có bao nhiêu chiếc bóng đèn?\n" +
                "\n" +
                "Vova đáp: thưa thầy có 5 cái!\n" +
                "\n" +
                "Cậu lại sai rồi nhé, hôm nay tôi không mang theo chiếc bóng nào cả!!!\n" +
                "\n" +
                "Vova lôi trong túi quần ra 1 chiếc bóng và nói: hôm nay em đã mang sẵn một cái vì biết sẽ gặp lại thầy :))"));
        lsvitemStory.add(new ItemStory(R.drawable.smile, "Quà tặng âm nhạc Vova",""));
        lsvitemStory.add(new ItemStory(R.drawable.smile, "Vova đi giảng đạo",""));
        lsvitemStory.add(new ItemStory(R.drawable.smile, "Xác nhận vấn đề",""));
        lsvitemStory.add(new ItemStory(R.drawable.smile, "Bạn gái Vova",""));
        lsvitemStory.add(new ItemStory(R.drawable.smile, "Vinh danh cho đất nước",""));
        lsvitemStory.add(new ItemStory(R.drawable.smile, "Vova và 1 giấc mơ",""));
        lsvitemStory.add(new ItemStory(R.drawable.smile, "Vova khó ngủ",""));

    }

    private void addStoreDanGian() {
        lsvitemStory.add(new ItemStory(R.drawable.smile,
                "Truyện cười: Ba trọc",""));
        lsvitemStory.add(new ItemStory(R.drawable.smile,
                "Uống thuốc độc vẫn chưa chết",""));
        lsvitemStory.add(new ItemStory(R.drawable.smile,
                "Lý do chồng ngoại tình",""));
        lsvitemStory.add(new ItemStory(R.drawable.smile,
                "Không cần mặc quần",""));
        lsvitemStory.add(new ItemStory(R.drawable.smile,
                "Cụ chó.",""));
        lsvitemStory.add(new ItemStory(R.drawable.smile,
                "Bố và rượu, vẹt.",""));
        lsvitemStory.add(new ItemStory(R.drawable.smile,
                "không đội trời chung. :))",""));
    }
    private void addStoreGiaDinh() {
        lsvitemStory.add(new ItemStory(R.drawable.smile,
                "Thay Thế",""));
        lsvitemStory.add(new ItemStory(R.drawable.smile,
                "Ai Giỏi Hơn",""));
        lsvitemStory.add(new ItemStory(R.drawable.smile,
                "Đi đâu vậy",""));
        lsvitemStory.add(new ItemStory(R.drawable.smile,
                "Mèo mùa hạ",""));
        lsvitemStory.add(new ItemStory(R.drawable.smile,
                "Lần sau",""));
        lsvitemStory.add(new ItemStory(R.drawable.smile,
                "trắc nghiệm tâm lý",""));
        lsvitemStory.add(new ItemStory(R.drawable.smile,
                "Định nghĩa chồng :))",""));
    }


    @Override
    public void openDetail(int position) {
        ((MainActivity)getActivity()).openDetail(lsvitemStory.get(position).getTvStory(),lsvitemStory.get(position).getContent());


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
