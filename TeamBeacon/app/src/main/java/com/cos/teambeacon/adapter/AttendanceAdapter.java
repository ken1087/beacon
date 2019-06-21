package com.cos.teambeacon.adapter;

import android.graphics.Movie;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.cos.teambeacon.Beacon.Beacon;
import com.cos.teambeacon.R;
import com.cos.teambeacon.model.AttendanceCheck;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.ViewHolder>{
    private List<AttendanceCheck> items = new ArrayList<>();
    //뷰홀더 객체생성하거나 재사용해서 리턴해줌 = 인플레이트
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.beacon_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    //ViewHolder가 필요한 위치에 할당될 때 자동으로 onBindViewHolder() 호출됨


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        AttendanceCheck item = items.get(i);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<AttendanceCheck> items) {
        this.items = items;
    }
    public void addItem(AttendanceCheck item) {
        this.items.add(item) ;
    }

    //리사이클러뷰에 담기는 하나의 아이템 = 뷰홀더
    static class  ViewHolder extends RecyclerView.ViewHolder{

        TextView textCheck, textCreateDate;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //itemView => person_item을 인플레이트
            textCheck = itemView.findViewById(R.id.textCheck);
            textCreateDate = itemView.findViewById(R.id.textCreateDate);

        }
        public void setItem(AttendanceCheck item ){
            textCheck.setText("출석여부: "+item.getChecking());
            textCreateDate.setText("출석일: "+item.getCreateDate());

        }
    }
}
