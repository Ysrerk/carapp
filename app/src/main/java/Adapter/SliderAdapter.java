package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.carapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import Models.SliderImage;

public class SliderAdapter extends PagerAdapter {
    List<SliderImage> list;
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(List<SliderImage> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(RelativeLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.sliderlayout,container,false);
        ImageView imageView=view.findViewById(R.id.sliderimageview);
        Picasso.get().load("https://carappyasar.000webhostapp.com/"+list.get(position).getImage()).resize(1050,550).into(imageView);
        container.addView(view);
        return view;
    }
}
