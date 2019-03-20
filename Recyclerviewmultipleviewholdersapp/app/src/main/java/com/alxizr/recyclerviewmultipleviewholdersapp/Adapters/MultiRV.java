package com.alxizr.recyclerviewmultipleviewholdersapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alxizr.recyclerviewmultipleviewholdersapp.Adapters.DataObjects.SingleItem1;
import com.alxizr.recyclerviewmultipleviewholdersapp.Adapters.DataObjects.SingleItem2;
import com.alxizr.recyclerviewmultipleviewholdersapp.Adapters.DataObjects.SingleItem3;
import com.alxizr.recyclerviewmultipleviewholdersapp.R;

import java.util.ArrayList;

public class MultiRV extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView) {
            //this is the base class that all viewholders will inherit to supprot dynamic DTOs
            super(itemView);
        }
    }//RV Viewholder


    public class ViewHolder1 extends ViewHolder {
        TextView n, s;

        public ViewHolder1(View v){
            super(v);
            n = v.findViewById(R.id.myNumber);
            s = v.findViewById(R.id.myString);
        }
    }//constructor for 1st vh


    public class ViewHolder2 extends ViewHolder {
        TextView s;

        public ViewHolder2(View v){
            super(v);
            s = v.findViewById(R.id.myStringOnly);
        }
    }//constructor for 2nd vh


    public class ViewHolder3 extends ViewHolder {
        TextView n;

        public ViewHolder3(View v){
            super(v);
            n = v.findViewById(R.id.myNumberOnly);
        }
    }//constructor for 3rd vh


    private Context ctx;
    private ArrayList list; //this list will contain all types of DTOs - Singleitem1 + Singleitem2 + ...


    public MultiRV(@NonNull Context context, ArrayList _arrayList) {
        this.ctx = context;
        this.list = new ArrayList();
        this.list.addAll(_arrayList);
    }//constructor

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        int layout;
        View view;
        RecyclerView.ViewHolder viewHolder = null;

        switch(viewType){
            case R.layout.single_item2:
                layout = viewType;
                view = LayoutInflater
                        .from(viewGroup.getContext())
                        .inflate(layout, viewGroup, false);
                viewHolder = new ViewHolder2(view);
                break;

            case R.layout.single_item3:
                layout = viewType;
                view = LayoutInflater
                        .from(viewGroup.getContext())
                        .inflate(layout, viewGroup, false);
                viewHolder = new ViewHolder3(view);
                break;

            case R.layout.single_item1:
            default:
                layout = viewType;
                view = LayoutInflater
                        .from(viewGroup.getContext())
                        .inflate(layout, viewGroup, false);
                viewHolder = new ViewHolder1(view);
                break;
        }//switch

        Log.d("oncreate", "onBindViewHolder: ");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof ViewHolder1){
            SingleItem1 si1 = (SingleItem1) list.get(position);
            ((ViewHolder1)viewHolder).n.setText(si1.getNumber().toString());
            ((ViewHolder1)viewHolder).s.setText(si1.getString());
        }
        else if (viewHolder instanceof ViewHolder2) {
            SingleItem2 si2 = (SingleItem2) list.get(position);
            ((ViewHolder2)viewHolder).s.setText(si2.getString());
        }
        else if(viewHolder instanceof ViewHolder3) {
            SingleItem3 si3 = (SingleItem3) list.get(position);
            ((ViewHolder3)viewHolder).n.setText(si3.getNumber().toString());
        }

        //open LOGCAT (ALT+6) or RUN (ALT+4) to see the rows get rendered in real time
        Log.d("onbind", "onBindViewHolder: " + position);
    }//onbindviewholder


    @Override
    public int getItemViewType(int position) {
        //return super.getItemViewType(position);

        if(list.get(position) instanceof SingleItem1){
            return R.layout.single_item1;
        }
        else if(list.get(position) instanceof SingleItem2){
            return R.layout.single_item2;
        }
        else if(list.get(position) instanceof SingleItem3){
            return R.layout.single_item3;
        }

        return -1;
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
}//multi recycler view
