package dsa.upc.edu.listapp;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import dsa.upc.edu.listapp.github.Contributor;
import dsa.upc.edu.listapp.github.Repos;

public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ViewHolder> {
    private List<Repos> values;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView icon;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            icon = (ImageView) v.findViewById(R.id.icon);
        }
    }

    public void setData(List<Repos> myDataset) {
        values = myDataset;
        notifyDataSetChanged();
    }

    public void add(int position, Repos item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public ReposAdapter() {
        values = new ArrayList<>();
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ReposAdapter(List<Repos> myDataset) {
        values = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ReposAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Repos c = values.get(position);
        final String name = c.name;
        final String description = c.description;
        holder.txtHeader.setText(name);
        holder.txtHeader.setText(description);
        holder.txtHeader.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(holder.getAdapterPosition());
            }
        });

        //holder.txtFooter.setText("Repos: " + c.repos);

        //GlideApp.with(holder.icon.getContext())
               // .load(c.avatar_url)
                //.into(holder.icon);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}