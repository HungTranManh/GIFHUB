package ailatrieuphu.hungtm.com.sqliteoperatingsystem;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;

public class RegisterFragment extends Fragment implements View.OnClickListener {
    private  ImageView iv_avt;
    private Button btnRegister;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_profile,container,false);
        initView(view);
        iv_avt.setOnClickListener(this);
        return view;
    }
    private void initView(View view){
        iv_avt=view.findViewById(R.id.iv_avt);
        btnRegister=view.findViewById(R.id.btn_register);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_avt:
                ((MainActivity)getActivity()).openGalaryFragment();
        }

    }
    public void chooseImage(ItemGalary itemGalary){
        Picasso.with(getContext()).load(new File(itemGalary.getPath())).placeholder(R.drawable.avt_miu_le).error(R.drawable.avt_miu_le).into(iv_avt);
    }
}
