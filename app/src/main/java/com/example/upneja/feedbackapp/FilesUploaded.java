package com.example.upneja.feedbackapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

public class FilesUploaded extends AppCompatActivity {
    RecyclerView myrecyclerview ;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    String[] mDataSet={"the","app ","with ","recycler ","view"," :P"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files_uploaded);
        myrecyclerview =(RecyclerView)findViewById(R.id.recyclerView);

        myrecyclerview.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        myrecyclerview.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(mDataSet);
        myrecyclerview.setAdapter(mAdapter);
    }
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
    {
        String[] mDataset;

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView mTextView;
            public ViewHolder(View itemView) {
                super(itemView);
                mTextView = (TextView) itemView;
            }
        }
        public MyAdapter(String[] mDataset) {
            this.mDataset = mDataset;
        }

        @Override
        public  MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.files,parent,false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }



        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.mTextView.setText(mDataset[position]);
        }

        @Override
        public int getItemCount() {
            return mDataset.length;
        }
    }
}
