package fr.mylocalphone.sanbot.activities.hotelservices;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import fr.mylocalphone.sanbot.activities.R;
import fr.mylocalphone.sanbot.activities.hotelservices.HotelServicesFragment.OnListFragmentInteractionListener;
import fr.mylocalphone.sanbot.model.HotelServices;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link HotelServices.HotelService} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyHotelServicesRecyclerViewAdapter extends RecyclerView.Adapter<MyHotelServicesRecyclerViewAdapter.ViewHolder> {

    private final List<HotelServices.HotelService> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyHotelServicesRecyclerViewAdapter(List<HotelServices.HotelService> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_hotelservice, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        //holder.mIdView.setText(mValues.get(position).id);
        TextView hotelServiceTitle = holder.mContentView.findViewById(R.id.tvHotelService);
        hotelServiceTitle.setText(mValues.get(position).name);
        ImageView hotelServicePicture = holder.mContentView.findViewById(R.id.ivHotelService);
        hotelServicePicture.setImageDrawable(mValues.get(position).picture);
        //holder.mContentView.setText(mValues.get(position).name);
        //holder.mContentView
        //holder.mContentView.setBackground(mValues.get(position).picture);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final CardView mContentView;
        //public final ImageView mImageView;

        public HotelServices.HotelService mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            //mContentView = view.findViewById(R.id.tvHotelService);
            mContentView = view.findViewById(R.id.cvHotelService);
            //mImageView = view.findViewById(R.id.ivHotelService);
        }

        @Override
        public String toString() {
            TextView hotelSeviceTitle = mContentView.findViewById(R.id.tvHotelService);
            return super.toString() + " '" + hotelSeviceTitle.getText() + "'";
        }
    }
}
