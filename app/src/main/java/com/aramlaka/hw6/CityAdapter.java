package com.aramlaka.hw6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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

    public static class ViewHolder extends RecyclerView.ViewHolder  {
        public TextView cityNameText;
        public TextView temperatureText;
        public TextView updatedDateText;
        public ImageView favoriteButton;
        public RelativeLayout rl;

        public ViewHolder(View cityView) {
            super(cityView);

            cityNameText = (TextView) cityView.findViewById(R.id.cityNameText);
            temperatureText = (TextView) cityView.findViewById(R.id.temperatureText);
            updatedDateText = (TextView) cityView.findViewById(R.id.updatedDateText);
            favoriteButton = (ImageView) cityView.findViewById(R.id.favoriteButton);
            rl = (RelativeLayout) cityView.findViewById(R.id.rCity);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View cityView = inflater.inflate(R.layout.item_city, parent, false);

        return new ViewHolder(cityView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        City city = mCities.get(position);

        TextView cityNameText = holder.cityNameText;
        TextView tempText = holder.temperatureText;
        TextView updatedDateText = holder.updatedDateText;
        ImageView favoriteButton = holder.favoriteButton;
        RelativeLayout rl = holder.rl;

        String cityCountryName = city.getCityName() + ", " + city.getCountry();

        cityNameText.setText(cityCountryName);
        tempText.setText(city.getTemperature());
        updatedDateText.setText(city.getTemperature());

        if (city.getFavorite() == 1) {
            favoriteButton.setImageResource(android.R.drawable.star_big_on);
        }

        rl.setOnLongClickListener(new CityOnLongClick(city, mContext));
        favoriteButton.setOnClickListener(new FavoriteButtonOnClick(city));
    }

    @Override
    public int getItemCount() {
        return mCities.size();
    }

    public class CityOnLongClick implements View.OnLongClickListener {
        private City city;
        private Context context;

        public CityOnLongClick(City city, Context context) {
            this.city = city;
            this.context = context;
        }

        @Override
        public boolean onLongClick(View view) {
            removeAt(city);

            Toast.makeText(context, city.getCityName() + " has been deleted.", Toast.LENGTH_SHORT).show();

            ((ViewGroup) view.getParent()).removeView(view);

            return true;
        }
    }

    public class CityOnClickOnClick implements View.OnClickListener {
        private City city;
        private Context context;

        public CityOnClickOnClick(City city, Context context) {
            this.city = city;
            this.context = context;
        }

        @Override
        public void onClick(View view) {
            //remove
        }
    }

    public class FavoriteButtonOnClick implements View.OnClickListener {
        private City city;

        public FavoriteButtonOnClick(City city) {
            this.city = city;
        }

        @Override
        public void onClick(View view) {
            ImageView favoriteButton = (ImageView) view;

            if (city.getFavorite() == 0) {
                favoriteButton.setImageResource(android.R.drawable.star_big_on);
                city.setFavorite(1);
            } else {
                favoriteButton.setImageResource(android.R.drawable.star_off);
                city.setFavorite(0);
            }

            MainActivity.dm.updateCity(city);
        }
    }

    public void removeAt(City city) {
        MainActivity.dm.deleteCity(city);
        int index = mCities.indexOf(city);
        mCities.remove(index);
        notifyItemRemoved(index);
        notifyItemRangeChanged(index, mCities.size());
    }
}
