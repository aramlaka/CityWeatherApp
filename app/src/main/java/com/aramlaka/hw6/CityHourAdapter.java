package com.aramlaka.hw6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by akhil on 10/21/2016.
 */

public class CityHourAdapter extends RecyclerView.Adapter<CityHourAdapter.ViewHolder>{
    private ArrayList<Forecast> mForecasts;
    private Context mContext;

    public CityHourAdapter(Context context, ArrayList<Forecast> forecast) {
        mContext = context;
        mForecasts = forecast;
    }

    private Context getContext() {
        return mContext;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {
        public TextView temperatureText;
        public TextView cityHourText;
        public TextView conditionText;
        public TextView pressureText;
        public TextView humidityText;
        public TextView windText;
        public ImageView forecastIcon;

        public ViewHolder(View cityHourView) {
            super(cityHourView);

            cityHourText = (TextView) cityHourView.findViewById(R.id.cityHourText);
            temperatureText = (TextView) cityHourView.findViewById(R.id.tempText);
            conditionText = (TextView) cityHourView.findViewById(R.id.conditionText);
            pressureText = (TextView) cityHourView.findViewById(R.id.pressureText);
            humidityText = (TextView) cityHourView.findViewById(R.id.humidityText);
            windText = (TextView) cityHourView.findViewById(R.id.windText);
            forecastIcon = (ImageView) cityHourView.findViewById(R.id.forecastIcon);
        }
    }

    @Override
    public CityHourAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View cityHourView = inflater.inflate(R.layout.item_city_hour, parent, false);

        return new CityHourAdapter.ViewHolder(cityHourView);
    }

    @Override
    public void onBindViewHolder(CityHourAdapter.ViewHolder holder, int position) {
        Forecast forecast = mForecasts.get(position);

        TextView cityHourText = holder.cityHourText;
        TextView tempText = holder.temperatureText;
        TextView conditionText = holder.conditionText;
        TextView pressureText = holder.pressureText;
        TextView humidityText = holder.humidityText;
        TextView windText = holder.windText;
        ImageView forecastIcon = holder.forecastIcon;

        cityHourText.setText(forecast.getTime());
        tempText.setText(forecast.getTemperature() + (char) 0x00B0 + " C");
        conditionText.setText(forecast.getCondition());
        pressureText.setText(forecast.getPressure() + " hPa");
        humidityText.setText(forecast.getHumidity() + "%");
        windText.setText(forecast.getWindDirection() + " ESE");
        Picasso.with(mContext).load(forecast.getIconUrl()).into(forecastIcon);
    }

    @Override
    public int getItemCount() {
        return mForecasts.size();
    }
}
