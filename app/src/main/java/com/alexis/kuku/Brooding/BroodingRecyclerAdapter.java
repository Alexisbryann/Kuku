package com.alexis.kuku.Brooding;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alexis.kuku.Database.DataBaseContract;
import com.alexis.kuku.R;

public class BroodingRecyclerAdapter extends RecyclerView.Adapter<BroodingRecyclerAdapter.ViewHolder> {

    private static Context mContext;
    private Cursor mCursor;
    private final LayoutInflater mLayoutInflater;
    private int mDefinitionPos;
    private int mTypePos;
    private int mImgPos;
    private int mDescriptionPos;
    private int mIdPos;

    public BroodingRecyclerAdapter(Context context, Cursor cursor){
        mContext = context;
        mCursor = cursor;
        mLayoutInflater = LayoutInflater.from(mContext);
        populateColumnPositions();
    }

    private void populateColumnPositions() {
        if (mCursor == null)
            return;
        mDefinitionPos = mCursor.getColumnIndex(DataBaseContract.BroodingEntry.COLUMN_DEFINITION);
        mTypePos = mCursor.getColumnIndex(DataBaseContract.BroodingEntry.COLUMN_TYPE);
        mImgPos = mCursor.getColumnIndex(DataBaseContract.BroodingEntry.COLUMN_IMAGE);
        mDescriptionPos = mCursor.getColumnIndex(DataBaseContract.BroodingEntry.COLUMN_DESCRIPTION);
        mIdPos = mCursor.getColumnIndex(DataBaseContract.BroodingEntry._ID);
    }
    public void changeCursor(Cursor cursor){
        if (mCursor != null)
            mCursor.close();
        mCursor = cursor;
        populateColumnPositions();
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public BroodingRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = mLayoutInflater.inflate(R.layout.item_brooding,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BroodingRecyclerAdapter.ViewHolder holder, int position) {
        mCursor.moveToPosition(position);

        String definitionPos = mCursor.getString(this.mDefinitionPos);
        String typePos = mCursor.getString(this.mTypePos);
        String imagePos = mCursor.getString(this.mImgPos);
        String descriptionPos = mCursor.getString(this.mDescriptionPos);
        int id = mCursor.getInt(mIdPos);

        holder.mTv_definition.setText(definitionPos);
        holder.mTv_type.setText(typePos);
        holder.mImg_type.setImageResource(Integer.parseInt(imagePos));
        holder.mTv_description.setText(descriptionPos);
        holder.mId = id;
    }
    @Override
        public int getItemCount() {
        return mCursor == null ? 0 : mCursor.getCount();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTv_definition;
        private final TextView mTv_type;
        private final ImageView mImg_type;
        private final TextView mTv_description;
        public int mId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTv_definition = itemView.findViewById(R.id.text_view_what_is_brooding);
            mTv_type = itemView.findViewById(R.id.text_view_natural_brooding);
            mImg_type = itemView.findViewById(R.id.imageView_natural);
            mTv_description = itemView.findViewById(R.id.text_view_natural_brooding_desc);

        }
    }
}
