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

    private ArrayList<Forecast> mForecasts;
    private Context mContext;
    private CityHourSet mCs;

    public CityDayAdapter(Context context, ArrayList<Forecast> forecasts, CityHourSet cs) {
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
        CityDayAdapter.ViewHolder viewHolder = new CityDayAdapter.ViewHolder(cityView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CityDayAdapter.ViewHolder holder, int position) {
        Forecast forecast = mForecasts.get(position);
;
        TextView tempText = holder.temperatureText;
        TextView dateText = holder.dateText;
        ImageView forecastIcon = holder.forecastIcon;
        RelativeLayout rl = holder.rl;

        tempText.setText(forecast.getTemperature() + (char) 0x00B0 + " C");
        dateText.setText(forecast.getTime());
        Picasso.with(mContext).load(forecast.getIconUrl()).into(forecastIcon);

        rl.setOnClickListener(new DayCityOnClick(forecast, mCs));
    }

    @Override
    public int getItemCount() {
        return mForecasts.size();
    }

    public class DayCityOnClick implements View.OnClickListener {
        private Forecast forecast;
        private CityHourSet cs;

        public DayCityOnClick(Forecast forecast, CityHourSet cs) {
            this.forecast = forecast;
            this.cs = cs;
        }

        @Override
        public void onClick(View view) {
            cs.setHourAdapter(forecast);
        }
    }

    public interface CityHourSet {
        public void setHourAdapter(Forecast forecast);
    }
}
