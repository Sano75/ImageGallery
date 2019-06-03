package com.example.imagegallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageListAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private ArrayList<Image> imageList;

    public ImageListAdapter(Context context, int layout, ArrayList<Image> imageList) {
        this.context = context;
        this.layout = layout;
        this.imageList = imageList;
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public Object getItem(int position) {
        return imageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtVDescrp;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtVDescrp = (TextView) row.findViewById(R.id.txtVDescrpItem);
            holder.imageView = (ImageView) row.findViewById(R.id.imgeViewItem);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }


        try{
            Image photo = imageList.get(position);

            holder.txtVDescrp.setText(photo.getDescribe());

            byte[] descImage = photo.getImage();
            Bitmap bitmap = BitmapFactory.decodeByteArray(descImage, 0, descImage.length);
            holder.imageView.setImageBitmap(bitmap);

        }catch (Exception e){

        }

        return row;
    }
}
