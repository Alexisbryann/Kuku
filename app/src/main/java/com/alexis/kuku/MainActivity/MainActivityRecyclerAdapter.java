package com.alexis.kuku.MainActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alexis.kuku.BadHabits.BadHabitsActivity;
import com.alexis.kuku.BestPractice.BestPracticeActivity;
import com.alexis.kuku.Breeds.BreedsExamplesActivity;
import com.alexis.kuku.Brooding.BroodingActivity;
import com.alexis.kuku.Database.DataBaseContract;
import com.alexis.kuku.HousingAndEquipment.HousingAndEquipmentActivity;
import com.alexis.kuku.PoultryHealthManagement.PoultryHealthManagementActivity;
import com.alexis.kuku.PoultryManagement.PoultryManagementActivity;
import com.alexis.kuku.R;

public class MainActivityRecyclerAdapter extends RecyclerView.Adapter<MainActivityRecyclerAdapter.ViewHolder> {

    private static Context mContext;
    private Cursor mCursor;
    private final LayoutInflater mLayoutInflater;
    private int mTitlePos;
    private int mTitleDesc;
    private int mIdPos;
    private int mImgMainPos;

    public MainActivityRecyclerAdapter(Context context, Cursor cursor) {
        mContext = context;
        mCursor = cursor;
        mLayoutInflater = LayoutInflater.from(mContext);
        populateColumnPositions();
    }

    private void populateColumnPositions() {
        if (mCursor == null)
            return;

        mTitlePos = mCursor.getColumnIndex(DataBaseContract.MainEntry.COLUMN_TITLE);
        mTitleDesc = mCursor.getColumnIndex(DataBaseContract.MainEntry.COLUMN_DESCRIPTION);
        mImgMainPos = mCursor.getColumnIndex(DataBaseContract.MainEntry.COLUMN_IMG);
        mIdPos = mCursor.getColumnIndex(DataBaseContract.MainEntry._ID);

    }

    public void changeCursor(Cursor cursor) {
        if (mCursor != null)
            mCursor.close();
        mCursor = cursor;
        populateColumnPositions();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainActivityRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = mLayoutInflater.inflate(R.layout.items_main, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainActivityRecyclerAdapter.ViewHolder holder, int position) {
        mCursor.moveToPosition(position);

        String TitlePos = mCursor.getString(this.mTitlePos);
        String TitleDesc = mCursor.getString(mTitleDesc);
        String ImageMainPos = mCursor.getString(mImgMainPos);
        int id = mCursor.getInt(mIdPos);

        holder.mTextTitle.setText(TitlePos);
        holder.mTextDescription.setText(TitleDesc);
        holder.mImg_main.setImageResource(Integer.parseInt(ImageMainPos));
        holder.mId = id;
    }

    @Override
    public int getItemCount() {
        return mCursor == null ? 0 : mCursor.getCount();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView mTextTitle;
        private final TextView mTextDescription;
        public int mId;
        private final ImageView mImg_main;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            mTextTitle = itemView.findViewById(R.id.text_view_title_main);
            mTextDescription = itemView.findViewById(R.id.text_view_main_description);
            mImg_main = itemView.findViewById(R.id.img_main);

        }

        @Override
        public void onClick(View view) {
            int pos = getLayoutPosition();

            switch (pos) {
                case 0:
                    mContext.startActivity(new Intent(mContext, BadHabitsActivity.class));
                    break;
                case 1:
                    mContext.startActivity(new Intent(mContext, BestPracticeActivity.class));
                    break;
                case 2:
                    mContext.startActivity(new Intent(mContext, BreedsExamplesActivity.class));
                    break;
                case 3:
                    mContext.startActivity(new Intent(mContext, BroodingActivity.class));
                    break;
                case 4:
                    mContext.startActivity(new Intent(mContext, HousingAndEquipmentActivity.class));
                    break;
                case 5:
                    mContext.startActivity(new Intent(mContext, PoultryHealthManagementActivity.class));
                    break;
                case 6:
                    mContext.startActivity(new Intent(mContext, PoultryManagementActivity.class));
                    break;
            }
        }
    }
}
