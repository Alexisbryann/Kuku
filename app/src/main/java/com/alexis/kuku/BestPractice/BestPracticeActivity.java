package com.alexis.kuku.BestPractice;

import android.annotation.SuppressLint;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.alexis.kuku.BadHabits.BadHabitsActivity;
import com.alexis.kuku.BadHabits.BadHabitsRecyclerAdapter;
import com.alexis.kuku.Brooding.BroodingActivity;
import com.alexis.kuku.Database.DataBaseContract;
import com.alexis.kuku.Database.DataBaseOpenHelper;
import com.alexis.kuku.Database.DataManager;
import com.alexis.kuku.HousingAndEquipment.HousingAndEquipmentActivity;
import com.alexis.kuku.PoultryHealthManagement.PoultryHealthManagementActivity;
import com.alexis.kuku.PoultryManagement.PoultryManagementActivity;
import com.alexis.kuku.R;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class BestPracticeActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    public static final int LOADER_BEST_PRACTICE = 0;
    private DataBaseOpenHelper mDbOpenHelper;
    private RecyclerView mRecyclerBestPractice;
    private LinearLayoutManager mBestPracticeLinearLayoutManager;
    private BestPracticeRecyclerAdapter mBestPracticeRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_best_practice);

        mDbOpenHelper = new DataBaseOpenHelper(this);
        initializeDisplayContent();
    }

    @Override
    protected void onDestroy() {
        mDbOpenHelper.close();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBestPracticeRecyclerAdapter.notifyDataSetChanged();
        getLoaderManager().restartLoader(LOADER_BEST_PRACTICE, null, this);
    }

    private void initializeDisplayContent() {
        DataManager.loadFromDatabase(mDbOpenHelper);

        mRecyclerBestPractice = findViewById(R.id.rv_best_practice);
        mBestPracticeLinearLayoutManager = new LinearLayoutManager(this);
        mBestPracticeRecyclerAdapter = new BestPracticeRecyclerAdapter(this,null);

        displayBestPractice();

    }

    private void displayBestPractice() {
        mRecyclerBestPractice.setLayoutManager(mBestPracticeLinearLayoutManager);
        mRecyclerBestPractice.setAdapter(mBestPracticeRecyclerAdapter);
    }

    @SuppressLint("StaticFieldLeak")
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle bundle) {
        CursorLoader loader = null;
        if (id == LOADER_BEST_PRACTICE) {
            loader = new CursorLoader(this) {
                @Override
                public Cursor loadInBackground() {
                    SQLiteDatabase db = mDbOpenHelper.getReadableDatabase();
                    final String[] Columns = {
                            DataBaseContract.BestPracticeEntry.getQName(DataBaseContract.BestPracticeEntry._ID),
                            DataBaseContract.BestPracticeEntry.COLUMN_TITLE,
                            DataBaseContract.BestPracticeEntry.COLUMN_MEASURES};

                    final String OrderBy = DataBaseContract.BestPracticeEntry.COLUMN_TITLE;
                    return db.query(DataBaseContract.BestPracticeEntry.TABLE_NAME, Columns, null, null, null, null, OrderBy);
                }
            };
        }

        return loader;
    }
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

        if (loader.getId() == LOADER_BEST_PRACTICE) {
            mBestPracticeRecyclerAdapter.changeCursor(data);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        if (loader.getId() == LOADER_BEST_PRACTICE) {
            mBestPracticeRecyclerAdapter.changeCursor(null);
        }
    }
}