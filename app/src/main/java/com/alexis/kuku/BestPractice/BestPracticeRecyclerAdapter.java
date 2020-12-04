package com.alexis.kuku.BestPractice;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alexis.kuku.Database.DataBaseContract;
import com.alexis.kuku.R;

public class BestPracticeRecyclerAdapter extends RecyclerView.Adapter<BestPracticeRecyclerAdapter.ViewHolder> {
    private static Context mContext;
    private Cursor mCursor;
    private final LayoutInflater mLayoutInflater;
    private int mTitlePos;
    private int mMeasuresPos;
    private int mIdPos;

    public BestPracticeRecyclerAdapter(Context context, Cursor cursor) {

        mContext = context;
        mCursor = cursor;
        mLayoutInflater = LayoutInflater.from(mContext);
        populateColumnPositions();
    }

    private void populateColumnPositions() {
        if (mCursor == null)
            return;

        mTitlePos = mCursor.getColumnIndex(DataBaseContract.BestPracticeEntry.COLUMN_TITLE);
        mMeasuresPos = mCursor.getColumnIndex(DataBaseContract.BestPracticeEntry.COLUMN_MEASURES);
        mIdPos = mCursor.getColumnIndex(DataBaseContract.BestPracticeEntry._ID);
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
    public BestPracticeRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_best_practice,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BestPracticeRecyclerAdapter.ViewHolder holder, int position) {
        mCursor.moveToPosition(position);

        String TitlePos = mCursor.getString(this.mTitlePos);
        String MeasuresPos = mCursor.getString(this.mMeasuresPos);

        int id = mCursor.getInt(mIdPos);

        holder.mTitle.setText(TitlePos);
        holder.mMeasures.setText(MeasuresPos);
        holder.mId = id;

    }
    @Override
    public int getItemCount() {
        return mCursor == null ? 0 : mCursor.getCount();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTitle;
        private final TextView mMeasures;
        public int mId;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            mTitle = itemView.findViewById(R.id.text_view_title);
            mMeasures = itemView.findViewById(R.id.text_view_measures);
        }
    }
}
