package com.ghanshyam.ilovezappos.adapters;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ghanshyam.ilovezappos.R;
import com.ghanshyam.ilovezappos.databinding.ListItemBinding;
import com.ghanshyam.ilovezappos.models.Result;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by GHANSHYAM on 05-Feb-17.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>
{
    private final View empty;
    private List<Result> results = new ArrayList<>();

    public ProductAdapter(View empty) {
        this.empty = empty;
    }

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final ListItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.list_item, parent, false);

        return new ViewHolder(binding.getRoot(), binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        final Result result = this.results.get(position);
       // holder.binding.setResult(result);
        holder.bind(result);
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
    }


    @Override
    public int getItemCount() {
        return results.size();
    }

    private void dataSetChanged() {
        this.notifyDataSetChanged();
        this.empty.setVisibility( View.GONE);
    }

    @UiThread
    public void addItem(final Result result) {
        this.results.add(result);
        this.dataSetChanged();
    }

    @UiThread
    public void addItems(final Result[] results) {
        this.results.addAll(Arrays.asList(results));
        this.dataSetChanged();
    }

    @UiThread
    public void clearItems() {
        this.results.clear();
        this.dataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ListItemBinding binding;

        public ViewHolder(final View view, final ListItemBinding binding) {
            super(view);
            this.binding = binding;
        }

        @UiThread
        public void bind(final Result result) {
            this.binding.setResult(result);
        }
    }

    @BindingAdapter("bind:imageUrl")

    public static void loadImage(ImageView imageView, String v)
    {

        Picasso.with(imageView.getContext()).load(v).into(imageView);
    }
}
