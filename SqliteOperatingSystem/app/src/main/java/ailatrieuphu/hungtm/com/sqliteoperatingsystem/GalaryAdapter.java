package ailatrieuphu.hungtm.com.sqliteoperatingsystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

public class GalaryAdapter extends BaseAdapter {
    private IGalaryAdapter iGalaryAdapter;
    private List<ItemGalary> itemGalaries;

    public GalaryAdapter(IGalaryAdapter iGalaryAdapter, List<ItemGalary> itemGalaries) {
        this.iGalaryAdapter = iGalaryAdapter;
        this.itemGalaries = itemGalaries;
    }
    @Override
    public int getCount() {
        return itemGalaries.size();
    }

    @Override
    public Object getItem(int position) {
        return itemGalaries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_view,parent,false);
        }
        ItemGalary itemGalary=itemGalaries.get(position);
        ImageView ivImg=convertView.findViewById(R.id.iv_item);
        //cach dung picaso
        //placeholder khi dang load thi hien thi anh nay
        //error laf de hien thi anh mac dinh khi load bi loi
        Picasso.with(parent.getContext()).load(new File(itemGalary.getPath())).placeholder(R.drawable.avt_miu_le).error(R.drawable.avt_miu_le).into(ivImg);
                //neu link anh o tren internet thi truyen vao  link anh
        //neu link o trong dien thoai thi truyen vao file
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGalaryAdapter.clickItemGalary(position);
            }
        });
        return convertView;
    }
    public  interface IGalaryAdapter{
        void clickItemGalary(int position);
    }
}
