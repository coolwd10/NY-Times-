package info.com.NyTimes.android.mvp.main.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import info.com.NyTimes.android.mvp.main.home.model.Result;
import info.com.NyTimes.R;

public class NyAdapter extends RecyclerView.Adapter<NyAdapter.MyViewHolder>
        implements Filterable {
    private Context context;
    private List<Result> resultList;
    private List<Result> resultListFiltered;
    private ContactsAdapterListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, phone, date;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            phone = view.findViewById(R.id.phone);
            date = view.findViewById(R.id.tv_date);
            thumbnail = view.findViewById(R.id.thumbnail);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // send selected contact in callback
                    listener.onContactSelected(resultListFiltered.get(getAdapterPosition()));
                }
            });
        }
    }


    public NyAdapter(Context context, List<Result> contactList, ContactsAdapterListener listener) {
        this.context = context;
        this.listener = listener;
        this.resultList = contactList;
        this.resultListFiltered = contactList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_row_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Result contact = resultListFiltered.get(position);
        holder.name.setText(contact.getTitle());
        holder.phone.setText(contact.getAbstract());
        holder.date.setText(contact.getPublishedDate());
        String url = contact.getMedia().get(0).getMediaMetadata().get(0).getUrl();
        if (url != null) {
            Glide.with(context)
                    .load(url)
                    .apply(RequestOptions.circleCropTransform())
                    .into(holder.thumbnail);
        }
    }

    @Override
    public int getItemCount() {
        return resultListFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    resultListFiltered = resultList;
                } else {
                    List<Result> filteredList = new ArrayList<>();
                    for (Result row : resultList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getTitle().toLowerCase().contains(charString.toLowerCase()) || row.getAbstract().contains(charSequence)) {
                            filteredList.add(row);
                        }
                    }

                    resultListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = resultListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                resultListFiltered = (ArrayList<Result>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface ContactsAdapterListener {
        void onContactSelected(Result contact);
    }
}
