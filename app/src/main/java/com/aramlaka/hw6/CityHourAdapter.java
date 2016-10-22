package com.aramlaka.hw6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by akhil on 10/21/2016.
 */

public class CityHourAdapter extends RecyclerView.Adapter<CityHourAdapter.ViewHolder>{

    private Forecast mForecast;
    private Context mContext;

    public CityHourAdapter(Context context, Forecast forecast) {
        mContext = context;
        mForecast = forecast;
    }

    private Context getContext() {
        return mContext;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {
        public TextView temperatureText;
        public TextView dateText;
        public ImageView forecastIcon;
        public RelativeLayout rl;

        public ViewHolder(View cityDayView) {
            super(cityDayView);

            temperatureText = (TextView) cityDayView.findViewById(R.id.tempText);
            dateText = (TextView) cityDayView.findViewById(R.id.dateText);
            forecastIcon = (ImageView) cityDayView.findViewById(R.id.favoriteButton);
            rl = (RelativeLayout) cityDayView.findViewById(R.id.rvDailyCity);
        }
    }

    @Override
    public CityHourAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View cityHourView = inflater.inflate(R.layout.item_city_hour, parent, false);
        CityHourAdapter.ViewHolder viewHolder = new CityHourAdapter.ViewHolder(cityHourView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CityHourAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
