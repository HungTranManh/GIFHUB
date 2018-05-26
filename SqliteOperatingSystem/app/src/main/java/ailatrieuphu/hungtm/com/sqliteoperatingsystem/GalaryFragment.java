package ailatrieuphu.hungtm.com.sqliteoperatingsystem;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GalaryFragment extends Fragment implements GalaryAdapter.IGalaryAdapter{
    private GridView gv_Image;
    private  static  final  String TAG=GalaryFragment.class.getSimpleName();
    private List<ItemGalary> itemGalaries;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_choose_image,container,false);
        loadGalary();
        initView(view);
        return view;
    }
   private void initView(View view){
        gv_Image=view.findViewById(R.id.gv_image);
       GalaryAdapter adapter=new GalaryAdapter(this,itemGalaries);
       gv_Image.setAdapter(adapter);
   }

    @Override
    public void onHiddenChanged(boolean hidden) {
    }

    private void loadGalary(){
        itemGalaries=new ArrayList<>();
        //lay dia chi cua co so du lieu
        //MediaStore.Images.Media.EXTERNAL_CONTENT_URI la dia chi cua bang
        Cursor c=getContext().getContentResolver().query( MediaStore.Images.Media.EXTERNAL_CONTENT_URI,new String[]{"_data"}
        ,null,null,"date_modified DESC limit 20 offset 1"
        );
        if(c!=null) {
            c.moveToFirst();
            int col = c.getColumnIndex("_data");
            while (!c.isAfterLast()) {
                ItemGalary itemGalary = new ItemGalary();
                itemGalary.setPath(c.getString(col));
                itemGalaries.add(itemGalary);
                Log.d(TAG, "path:"+c.getString(col));
                c.moveToNext();
            }

            c.close();
        }
    }

    @Override
    public void clickItemGalary(int position) {
    ItemGalary itemGalary=itemGalaries.get(position);
        ((MainActivity)getActivity()).chooseImage(itemGalary);
        getActivity().onBackPressed();
    }
}
