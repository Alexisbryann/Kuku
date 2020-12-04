package com.alexis.kuku.BadHabits;

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

public class BadHabitsRecyclerAdapter extends RecyclerView.Adapter<BadHabitsRecyclerAdapter.ViewHolder> {
    private static Context mContext;
    private Cursor mCursor;
    private final LayoutInflater mLayoutInflater;
    private int mImagePos;
    private int mHabitPos;
    private int mDescriptionPos;
    private int mCausesPos;
    private int mPreventionPos;
    private int mIdPos;

    @NonNull
    @Override
    public BadHabitsRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_bad_habits,parent,false);
        return new ViewHolder(itemView);
    }
public BadHabitsRecyclerAdapter(Context context, Cursor cursor){
    mContext = context;
    mCursor = cursor;
    mLayoutInflater = LayoutInflater.from(mContext);
    populateColumnPositions();

}

    private void populateColumnPositions() {

        if (mCursor == null)
            return;

        mImagePos = mCursor.getColumnIndex(DataBaseContract.BadHabitsEntry.COLUMN_IMAGE);
        mHabitPos = mCursor.getColumnIndex(DataBaseContract.BadHabitsEntry.COLUMN_HABIT);
        mDescriptionPos = mCursor.getColumnIndex(DataBaseContract.BadHabitsEntry.COLUMN_DESCRIPTION);
        mCausesPos = mCursor.getColumnIndex(DataBaseContract.BadHabitsEntry.COLUMN_CAUSES);
        mPreventionPos = mCursor.getColumnIndex(DataBaseContract.BadHabitsEntry.COLUMN_PREVENTION);
        mIdPos = mCursor.getColumnIndex(DataBaseContract.BadHabitsEntry._ID);
    }

    public void changeCursor(Cursor cursor){
        if (mCursor != null)
            mCursor.close();
        mCursor = cursor;
        populateColumnPositions();
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull BadHabitsRecyclerAdapter.ViewHolder holder, int position) {

        mCursor.moveToPosition(position);

        String ImagePos = mCursor.getString(this.mImagePos);
        String HabitPos = mCursor.getString(this.mHabitPos);
        String CausesPos = mCursor.getString(this.mCausesPos);
        String DescriptionPos = mCursor.getString(this.mDescriptionPos);
        String PreventionPos = mCursor.getString(this.mPreventionPos);
        int id = mCursor.getInt(mIdPos);

        holder.mImage.setImageResource(Integer.parseInt(ImagePos));
        holder.mHabit.setText(HabitPos);
        holder.mCause.setText(CausesPos);
        holder.mDescription.setText(DescriptionPos);
        holder.mPrevention.setText(PreventionPos);
        holder.mId=id;

    }

    @Override
    public int getItemCount() {
        return mCursor == null ? 0 : mCursor.getCount();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mImage;
        private final TextView mHabit;
        private final TextView mDescription;
        private final TextView mCause;
        private final TextView mPrevention;
        public int mId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImage = itemView.findViewById(R.id.image_view_habit);
            mHabit = itemView.findViewById(R.id.text_view_habit);
            mDescription = itemView.findViewById(R.id.text_view_description);
            mCause = itemView.findViewById(R.id.text_view_causes);
            mPrevention = itemView.findViewById(R.id.text_view_prevention);
        }
    }
}
