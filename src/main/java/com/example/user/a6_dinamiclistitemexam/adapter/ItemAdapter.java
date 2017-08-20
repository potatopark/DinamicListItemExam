package com.example.user.a6_dinamiclistitemexam.adapter;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.a6_dinamiclistitemexam.MainActivity;
import com.example.user.a6_dinamiclistitemexam.R;
import com.example.user.a6_dinamiclistitemexam.model.Item;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by user on 2017-08-20.
 */

public class ItemAdapter extends ArrayAdapter<Item> {
    Activity activity;
    int resource;

    public ItemAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Item> objects) {

        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;

        if(itemView == null){
            itemView = this.activity.getLayoutInflater().inflate(this.resource,null);
        }
        final Item item = getItem(position);

        if(item != null){
            TextView textView = (TextView) itemView.findViewById(R.id.textView);
            textView.setText(item.getNum() + ">>" + item.getName());

            Button button = (Button) itemView.findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    remove(item);
                }
            });
        }
        return itemView;
    }
}
