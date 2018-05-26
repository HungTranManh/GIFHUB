package circleindicator.hungtm.com.tablayoutdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentDetail extends Fragment implements View.OnClickListener {
private Button btnFontmin;
private  TextView tvDetail;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        TextView tvTitle = view.findViewById(R.id.tv_title);
         tvDetail = view.findViewById(R.id.tv_detail);
        Bundle bundle = getArguments();
        tvTitle.setText(bundle.getString("TITLE"));
        tvDetail.setText(bundle.getString("DETAIL"));
        btnFontmin = view.findViewById(R.id.btn_font_min);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btnFontmin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_font_min:
                tvDetail.setTextSize(tvDetail.getTextSize()-4);
                break;
            case R.id.btn_font_max:
                tvDetail.setTextSize(tvDetail.getTextSize()+4);
                break;
            case R.id.btn_favorite:

                default:
                    break;
        }
    }
}
