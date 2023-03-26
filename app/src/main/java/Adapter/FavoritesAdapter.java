package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carapp.R;

import java.util.List;

import Models.Favorite;

public class FavoritesAdapter extends BaseAdapter {
    List<Favorite> fadsList;
    Context context;

    public FavoritesAdapter(List<Favorite> adsList, Context context) {
        this.fadsList = adsList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return fadsList.size();
    }

    @Override
    public Object getItem(int position) {
        return fadsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView= LayoutInflater.from(context).inflate(R.layout.favoriteslayout,parent,false);
        TextView id,title,price,make,model;
        ImageView imageView;
        id=convertView.findViewById(R.id.fadsid);
        title=convertView.findViewById(R.id.fadstitle);
        price=convertView.findViewById(R.id.fadsprice);
        make=convertView.findViewById(R.id.fadsmake);
        model=convertView.findViewById(R.id.fadsmodel);


        id.setText(fadsList.get(position).getAdvid());
        title.setText(fadsList.get(position).getTitle());
        price.setText(fadsList.get(position).getPrice());
        make.setText(fadsList.get(position).getMake());
        model.setText(fadsList.get(position).getModel());


        return convertView;


    }
}
