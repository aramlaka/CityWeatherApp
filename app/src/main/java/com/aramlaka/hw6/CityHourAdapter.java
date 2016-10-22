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
        public TextView conditionText;
        public ImageView forecastIcon;
        public RelativeLayout rl;

        public ViewHolder(View cityHourView) {
            super(cityHourView);

            temperatureText = (TextView) cityHourView.findViewById(R.id.tempText);
            dateText = (TextView) cityHourView.findViewById(R.id.dateText);
            forecastIcon = (ImageView) cityHourView.findViewById(R.id.favoriteButton);
            conditionText = (TextView) cityHourView.findViewById(R.id.conditionText);
            rl = (RelativeLayout) cityHourView.findViewById(R.id.rvDailyCity);
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
        Forecast forecast = mForecast;

        TextView tempText = holder.temperatureText;
        TextView conditionText = holder.conditionText;

        tempText.setText(forecast.getTemperature());
        conditionText.setText(forecast.getCondition());
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
