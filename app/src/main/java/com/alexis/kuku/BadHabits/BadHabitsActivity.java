package com.alexis.kuku.BadHabits;

import android.annotation.SuppressLint;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.LoaderManager;

import com.alexis.kuku.Database.DataBaseContract;
import com.alexis.kuku.Database.DataBaseOpenHelper;
import com.alexis.kuku.Database.DataManager;
import com.alexis.kuku.MainActivity.MainActivity;
import com.alexis.kuku.R;
import com.alexis.kuku.Utils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
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

import android.view.Menu;
import android.view.View;

import static com.alexis.kuku.Database.DataBaseContract.*;

public class BadHabitsActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    public static final int LOADER_BAD_HABITS = 0;
    private DataBaseOpenHelper mDbOpenHelper;
    private RecyclerView mRecyclerBadHabits;
    private LinearLayoutManager mLayoutManagerBadHabits;
    private BadHabitsRecyclerAdapter mBadHabitsRecyclerAdapter;
    private View mNoInternetConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_bad_habits);

        mNoInternetConnection = findViewById(R.id.no_internet);

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
        mBadHabitsRecyclerAdapter.notifyDataSetChanged();
        getLoaderManager().restartLoader(LOADER_BAD_HABITS, null, this);
    }

    private void initializeDisplayContent() {
        DataManager.loadFromDatabase(mDbOpenHelper);

        mRecyclerBadHabits = findViewById(R.id.rv_bad_habits);
        mLayoutManagerBadHabits = new LinearLayoutManager(this);
        mBadHabitsRecyclerAdapter = new BadHabitsRecyclerAdapter(this,null);

        displayBadHabits();
    }
    private void displayBadHabits() {
    mRecyclerBadHabits.setLayoutManager(mLayoutManagerBadHabits);
    mRecyclerBadHabits.setAdapter(mBadHabitsRecyclerAdapter);
    }

    private void checkInternet() {
        // Check the internet connect
        if (!Utils.checkAppConnectionStatus(BadHabitsActivity.this)){
            // If do not have internet connection, set layout visible
            Utils.setLayoutVisible(mNoInternetConnection);

        }else{
            // If have internet connection, set layout invisible
            Utils.setLayoutInvisible(mNoInternetConnection);

            initializeDisplayContent();
        }
    }

//    @Override
//    public void onBackPressed() {
//        checkInternet();
//    }

    @SuppressLint("StaticFieldLeak")
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle bundle) {
        CursorLoader loader = null;
        if (id == LOADER_BAD_HABITS) {
            loader = new CursorLoader(this) {
                @Override
                public Cursor loadInBackground() {
                    SQLiteDatabase db = mDbOpenHelper.getReadableDatabase();
                    final String[] Columns = {
                            BadHabitsEntry.getQName(BadHabitsEntry._ID),
                            BadHabitsEntry.COLUMN_HABIT,
                            BadHabitsEntry.COLUMN_IMAGE,
                            BadHabitsEntry.COLUMN_CAUSES,
                            BadHabitsEntry.COLUMN_DESCRIPTION,
                            BadHabitsEntry.COLUMN_PREVENTION};

                    final String OrderBy = BadHabitsEntry.COLUMN_HABIT;
                    return db.query(BadHabitsEntry.TABLE_NAME, Columns, null, null, null, null, OrderBy);
                }
            };
        }

        return loader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (loader.getId() == LOADER_BAD_HABITS) {
            mBadHabitsRecyclerAdapter.changeCursor(data);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        if (loader.getId() == LOADER_BAD_HABITS) {
            mBadHabitsRecyclerAdapter.changeCursor(null);
        }
    }
}