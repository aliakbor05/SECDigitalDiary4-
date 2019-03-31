
package com.example.android.secdigitaldiary.teachersInfo;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.secdigitaldiary.R;

import java.util.List;

import static com.example.android.secdigitaldiary.R.id.designation;
import static com.example.android.secdigitaldiary.R.id.name;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

   private List<Info> infos;

   public RecyclerAdapter (List<Info> infos){

       this.infos = infos;
   }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

       holder.Name.setText(infos.get(position).getName());
       holder.Designation.setText(infos.get(position).getDesignation());
    }

    @Override
    public int getItemCount() {
        return infos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

       TextView Name,Designation;

        public MyViewHolder(View itemView) {
            super(itemView);

            Name = (TextView) itemView.findViewById(name);
            Designation = (TextView) itemView.findViewById(designation);
        }
    }
}