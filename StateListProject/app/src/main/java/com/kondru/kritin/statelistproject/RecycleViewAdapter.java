package com.kondru.kritin.statelistproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

 public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

        private ArrayList<String> statesList;
        private Context contex;

        public RecycleViewAdapter(ArrayList<String> statesList, Context contex) {
            this.statesList = statesList;
            this.contex = contex;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitemlayout,parent,false);
            ViewHolder holder = new ViewHolder(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder,final int position) {
            Log.d("TAG","called");
            holder.stateName.setText(statesList.get(position));

            holder.stateName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(holder.stateName.getText()=="Kansas") {
                        String uri = "https://www.google.com/maps/place/Topeka,+KS/@39.0129707,-95.8481152,11z/data=!3m1!4b1!4m5!3m4!1s0x87bf02e4daec7a29:0xbe2be7d06ae3a7f0!8m2!3d39.0473451!4d-95.6751576" ;
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                        intent.setPackage("com.google.android.apps.maps");
                        contex.startActivity(intent);

                    }


                    Toast.makeText(contex, holder.stateName.getText(), Toast.LENGTH_LONG).show();

                }
            });
        }

        @Override
        public int getItemCount() {
            return statesList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            TextView stateName;
            LinearLayout linearlayout;

            public ViewHolder(View itemView) {
                super(itemView);
                stateName = itemView.findViewById(R.id.textView);
                linearlayout = itemView.findViewById(R.id.linear_layout);

            }
        }
    }
