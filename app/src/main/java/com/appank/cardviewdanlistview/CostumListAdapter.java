package com.appank.cardviewdanlistview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;

public class CostumListAdapter extends ArrayAdapter<cards> {

    private static final String TAG = "PersonListAdapter";

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    public CostumListAdapter(Context context, int resource, ArrayList<cards> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    /**
     * Holds variables in a View
     */
    private static class ViewHolder {

        TextView name,rating,type;
        ImageView image;
    }



    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        setupImageLoader();

        String name = (String) getItem(position).getTitle1();
        String rating = (String) getItem(position).getTitle2();
        String type = (String) getItem(position).getTitle3();
        String imgUrl = getItem(position).getImgUrl();
        try {

            final View result;

            ViewHolder holder;

            if(convertView == null){
                LayoutInflater inflater = LayoutInflater.from(mContext);
                convertView = inflater.inflate(mResource, parent, false);
                holder= new ViewHolder();
                holder.name = (TextView) convertView.findViewById(R.id.cardTitle1);
                holder.rating = (TextView) convertView.findViewById(R.id.cardTitle2);
                holder.type = (TextView) convertView.findViewById(R.id.cardTitle3);
                holder.image = (ImageView) convertView.findViewById(R.id.carImage);

                result = convertView;

                convertView.setTag(holder);
            }
            else{
                holder = (ViewHolder) convertView.getTag();
                result = convertView;
            }


            Animation animation = AnimationUtils.loadAnimation(mContext,
                    (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
            result.startAnimation(animation);
            lastPosition = position;


            holder.name.setText(name);
            holder.rating.setText(rating);
            holder.type.setText(type);


            ImageLoader imageLoader = ImageLoader.getInstance();
            ;
            int defaultImage = mContext.getResources().getIdentifier("@drawable/ic_action_name",null,mContext.getPackageName());


            DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                    .cacheOnDisc(true).resetViewBeforeLoading(true)
                    .showImageForEmptyUri(defaultImage)
                    .showImageOnFail(defaultImage)
                    .showImageOnLoading(defaultImage).build();


            imageLoader.displayImage(imgUrl, holder.image, options);

            return convertView;
        }catch (IllegalArgumentException e){
            Log.e(TAG, "getView: IllegalArgumentException:" + e.getMessage());
            return convertView;
        }
    }

    /**
     * Required for setting up the Universal Image loader Library
     */
    private void setupImageLoader(){
        // UNIVERSAL IMAGE LOADER SETUP
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                mContext)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();
        ImageLoader.getInstance().init(config);
    }
}