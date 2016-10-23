package com.aramlaka.hw6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by akhil on 10/21/2016.
 */

public class CityDayAdapter extends RecyclerView.Adapter<CityDayAdapter.ViewHolder>{

    private ArrayList<DailyForecast> mForecasts;
    private Context mContext;
    private CityHourSet mCs;

    public CityDayAdapter(Context context, ArrayList<DailyForecast> forecasts, CityHourSet cs) {
        mContext = context;
        mForecasts = forecasts;
        mCs = cs;
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
            forecastIcon = (ImageView) cityDayView.findViewById(R.id.forecastIcon);
            rl = (RelativeLayout) cityDayView.findViewById(R.id.rlDailyCity);
        }
    }

    @Override
    public CityDayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View cityView = inflater.inflate(R.layout.item_city_day, parent, false);

        return new CityDayAdapter.ViewHolder(cityView);
    }

    @Override
    public void onBindViewHolder(CityDayAdapter.ViewHolder holder, int position) {
        DailyForecast dailyForecast = mForecasts.get(position);

        TextView tempText = holder.temperatureText;
        TextView dateText = holder.dateText;
        ImageView forecastIcon = holder.forecastIcon;
        RelativeLayout rl = holder.rl;

        tempText.setText(dailyForecast.getTemp() + (char) 0x00B0 + " C");
        dateText.setText(dailyForecast.getDate());
        Picasso.with(mContext).load(dailyForecast.getIconUrl()).into(forecastIcon);

        rl.setOnClickListener(new DayCityOnClick(dailyForecast.getForecasts(), mCs));
    }

    @Override
    public int getItemCount() {
        return mForecasts.size();
    }

    public class DayCityOnClick implements View.OnClickListener {
        private ArrayList<Forecast> forecasts;
        private CityHourSet cs;

        public DayCityOnClick(ArrayList<Forecast> forecasts, CityHourSet cs) {
            this.forecasts = forecasts;
            this.cs = cs;
        }

        @Override
        public void onClick(View view) {
            cs.setHourAdapter(forecasts);
        }
    }

    public interface CityHourSet {
        public void setHourAdapter(ArrayList<Forecast> forecasts);
    }
}
