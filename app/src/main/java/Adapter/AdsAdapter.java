package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import Models.Ads;


public class AdsAdapter extends BaseAdapter {
    List<Ads> adsList;
    Context context;

    public AdsAdapter(List<Ads> adsList, Context context) {
        this.adsList = adsList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return adsList.size();
    }

    @Override
    public Object getItem(int position) {
        return adsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView= LayoutInflater.from(context).inflate(R.layout.adslayout,parent,false);
        TextView  id,title,price,make,model;
        ImageView imageView;
        id=convertView.findViewById(R.id.adsid);
        title=convertView.findViewById(R.id.adstitle);
        price=convertView.findViewById(R.id.adsprice);
        make=convertView.findViewById(R.id.adsmake);
        model=convertView.findViewById(R.id.adsmodel);
        imageView=convertView.findViewById(R.id.imageviewadsimage);

        id.setText(adsList.get(position).getAdvid());
        title.setText(adsList.get(position).getTitle());
        price.setText(adsList.get(position).getPrice());
        make.setText(adsList.get(position).getMake());
        model.setText(adsList.get(position).getModel());

        Picasso.get().load("https://carappyasar.000webhostapp.com/"+adsList.get(position).getImage()).resize(100,100).into(imageView);
        return convertView;


    }
}
