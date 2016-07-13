package com.example.m.prarecyclenaviga;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by m on 2016-07-12.
 */
public class RecyclerVievAdapter extends RecyclerView.Adapter<RecyclerVievAdapter.RecyclerViewHolder> {

    ArrayList<String> arrayList;
    Context context;
    RecyclerVievAdapter(ArrayList<String> arrayList,Context context){




        this.arrayList = arrayList;
        this.context=context;

    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
                RecyclerViewHolder holder = new RecyclerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        String name = arrayList.get(position);
        holder.tekst.setText(name);

    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView tekst ;

    public RecyclerViewHolder(View itemView) {

        super(itemView);
        tekst = (TextView)itemView.findViewById(R.id.textView);

//        @Override
//        public void onClick(View v) {
//            if (v instanceof ImageView){
//                mListener.onTomato((ImageView)v);
//            } else {
//                mListener.onPotato(v);
//            }
//        }
//
//        public static interface IMyViewHolderClicks {
//            public void onPotato(View caller);
//            public void onTomato(ImageView callerImage);
//        }


    }



    }





}
