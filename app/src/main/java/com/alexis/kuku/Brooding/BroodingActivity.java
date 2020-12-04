package com.alexis.kuku.Brooding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.alexis.kuku.Database.DataBaseContract;
import com.alexis.kuku.Database.DataBaseContract.BroodingEntry;
import com.alexis.kuku.Database.DataBaseOpenHelper;
import com.alexis.kuku.Database.DataManager;
import com.alexis.kuku.R;

public class BroodingActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    public static final int LOADER_BROODING = 0;
    private DataBaseOpenHelper mDbOpenHelper;
    private RecyclerView mBrooding;
    private LinearLayoutManager mBroodingManager;
    private BroodingRecyclerAdapter mBroodingRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brooding);

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
        mBroodingRecyclerAdapter.notifyDataSetChanged();
        getLoaderManager().restartLoader(LOADER_BROODING, null,this);
    }

    private void initializeDisplayContent() {
        DataManager.loadFromDatabase(mDbOpenHelper);

        mBrooding = findViewById(R.id.item_brooding);
        mBroodingManager = new LinearLayoutManager(this);
        mBroodingRecyclerAdapter = new BroodingRecyclerAdapter(this,null);

        displayBrooding();
    }
    private void displayBrooding() {
        mBrooding.setLayoutManager(mBroodingManager);
        mBrooding.setAdapter(mBroodingRecyclerAdapter);
    }
    @SuppressLint("StaticFieldLeak")
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle bundle) {
        CursorLoader loader = null;
        if (id == LOADER_BROODING) {
            loader = new CursorLoader(this) {
                @Override
                public Cursor loadInBackground() {
                    SQLiteDatabase db = mDbOpenHelper.getReadableDatabase();
                    final String[] Columns = {
                            BroodingEntry.getQName(BroodingEntry._ID),
                            BroodingEntry.COLUMN_DESCRIPTION,
                            BroodingEntry.COLUMN_DEFINITION,
                            BroodingEntry.COLUMN_TYPE,
                            BroodingEntry.COLUMN_IMAGE};

//                    final String OrderBy = BroodingEntry.COLUMN_DEFINITION;

                    return db.query(BroodingEntry.TABLE_NAME, Columns, null, null, null, null, null);
//                            OrderBy);
                }
            };
        }

        return loader;
    }
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (loader.getId() == LOADER_BROODING) {
            mBroodingRecyclerAdapter.changeCursor(data);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        if (loader.getId()== LOADER_BROODING) {
            mBroodingRecyclerAdapter.changeCursor(null);
        }
    }


}