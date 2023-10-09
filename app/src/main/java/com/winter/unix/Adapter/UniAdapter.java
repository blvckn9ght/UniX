package com.winter.unix.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.winter.unix.Objects.UniData;
import com.winter.unix.R;

public class UniAdapter extends FirestoreRecyclerAdapter<UniData, UniAdapter.UniHolder> {
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public UniAdapter(@NonNull FirestoreRecyclerOptions options) {
        super(options);
    }


    @NonNull
    @Override
    public UniHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.univiews,
                parent, false);

        return new UniHolder(v);
    }

    @Override
    protected void onBindViewHolder(@NonNull UniHolder holder, int position, @NonNull UniData model) {

        holder.uniName.setText(model.getUni_Name());
        holder.uniCountry.setText("🏳️‍⚧️Country: "+model.getUni_Country());
        holder.uniOffer.setText("🙌Offer:  "+model.getWhat_they_offer());


    }

    class UniHolder extends RecyclerView.ViewHolder {


        TextView uniName;
        TextView uniCountry;
        TextView uniOffer;

            public UniHolder(View v) {
            super(v);

                uniName = v.findViewById(R.id.UniView_UniName);
                uniCountry = v.findViewById(R.id.UniView_UniCountry);
                uniOffer = v.findViewById(R.id.UniView_UniOffered);

        }


    }
}
