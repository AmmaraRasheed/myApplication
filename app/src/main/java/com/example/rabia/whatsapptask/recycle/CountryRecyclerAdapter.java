package com.example.rabia.whatsapptask.recycle;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.rabia.whatsapptask.R;

import java.util.ArrayList;
public class CountryRecyclerAdapter extends RecyclerView.Adapter<CountryRecyclerAdapter.ViewHolder> {

    public interface ChangeStatusListener{

        void onItemChangeListener(int postion, Country country);
    }

    public void setCountries(ArrayList<Country> countries) {
        this.countries = countries;
    }

    ArrayList<Country> countries;
    private Context mContext = null;
    private LayoutInflater mLayoutInflate;
    ChangeStatusListener changeStatusListener;

    public CountryRecyclerAdapter(Context mContext,ArrayList<Country> countries) {
        this.mContext = mContext;
        this.mLayoutInflate = LayoutInflater.from(mContext);
        this.countries = countries;
    }

    public CountryRecyclerAdapter(Context mContext,ArrayList<Country> countries, ChangeStatusListener changeStatusListener) {
        this.mContext = mContext;
        this.mLayoutInflate = LayoutInflater.from(mContext);
        this.countries = countries;
        this.changeStatusListener = changeStatusListener;
    }


    @Override
    public int getItemCount() {
        if(countries != null) return countries.size();
        return 0;
    }

    @Override
    public CountryRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = mLayoutInflate.inflate(R.layout.item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        Toast.makeText(mContext,"5",Toast.LENGTH_SHORT).show();
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(final CountryRecyclerAdapter.ViewHolder viewHolder, int position) {



        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Country country = countries.get(viewHolder.position);
                if(country.isSelect()){
                    Toast.makeText(mContext,"6",Toast.LENGTH_SHORT).show();
                    country.setSelect(false);
                } else {
                    Toast.makeText(mContext,"7",Toast.LENGTH_SHORT).show();
                    country.setSelect(true);
                }
                countries.set(viewHolder.position, country);
                if(changeStatusListener != null){
                    Toast.makeText(mContext,"8",Toast.LENGTH_SHORT).show();
                    changeStatusListener.onItemChangeListener(viewHolder.position, country);
                }
                notifyItemChanged(viewHolder.position);
            }
        });


        try {
            Country country = countries.get(position);
            if(country != null){
                viewHolder.name.setText(country.getName());
                viewHolder.capital.setText(country.getCapital());
                viewHolder.area.setText(country.getArea());
                viewHolder.imageView.setImageResource(country.getImage());
                viewHolder.position = position;

                if(country.isSelect()) viewHolder.view.setBackgroundColor(mContext.getResources().getColor(R.color.colorAccent));
                else viewHolder.view.setBackgroundResource(R.drawable.ic_launcher_background);
            }
        } catch (Exception e){

        }
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

        public TextView name;
        public TextView area;
        public TextView capital;
        public ImageView imageView;

        public View view;
        public int position;

        public ViewHolder(View v) {
            super(v);
            v.setClickable(true);
            this.view = v;
            this.name = (TextView) v.findViewById(R.id.name);
            this.area = (TextView) v.findViewById(R.id.area);
            this.capital = (TextView) v.findViewById(R.id.capital);
            this.imageView = (ImageView) v.findViewById(R.id.flag);
        }
    }

}
