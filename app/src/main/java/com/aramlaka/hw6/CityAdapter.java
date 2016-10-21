package com.aramlaka.hw6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by akhil on 10/20/2016.
 */
public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {

    private List<City> mCities;
    private Context mContext;

    public CityAdapter(Context context, List<City> cities) {
        mContext = context;
        mCities = cities;
    }

    private Context getContext() {
        return mContext;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView cityNameText;
        public TextView temperatureText;
        public TextView updatedDateText;

        public ViewHolder(View cityView) {
            super(cityView);

            cityNameText = (TextView) cityView.findViewById(R.id.cityNameText);
            temperatureText = (TextView) cityView.findViewById(R.id.temperatureText);
            updatedDateText = (TextView) cityView.findViewById(R.id.updatedDateText);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View cityView = inflater.inflate(R.layout.item_city, parent, false);
        ViewHolder viewHolder = new ViewHolder(cityView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        City city = mCities.get(position);

        TextView cityNameText = holder.cityNameText;
        TextView tempText = holder.temperatureText;
        TextView updatedDateText = holder.updatedDateText;

        String cityCountryName = city.getCityName() + ", " + city.getCountry();

        cityNameText.setText(cityCountryName);
        //tempText.setText(city.getForecasts().get(0).getTemperature());
        tempText.setText("wowzers");
        updatedDateText.setText("wow");
    }

    @Override
    public int getItemCount() {
        return mCities.size();
    }
}
