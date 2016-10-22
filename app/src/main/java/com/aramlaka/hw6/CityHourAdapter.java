package com.aramlaka.hw6;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by akhil on 10/21/2016.
 */

public class CityHourAdapter extends RecyclerView.Adapter<CityHourAdapter.ViewHolder> {

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
    public CityHourAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(CityHourAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
