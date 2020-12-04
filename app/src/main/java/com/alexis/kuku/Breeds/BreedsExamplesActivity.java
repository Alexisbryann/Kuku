package com.alexis.kuku.Breeds;

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

import com.alexis.kuku.Database.DataBaseOpenHelper;
import com.alexis.kuku.Database.DataManager;
import com.alexis.kuku.R;

import static com.alexis.kuku.Database.DataBaseContract.*;

public class BreedsExamplesActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    public static final int LOADER_BREEDS_EXAMPLE = 0;
    private DataBaseOpenHelper mDbOpenHelper;
    private LinearLayoutManager mBreedsExampleLayoutManager;
    private BreedsExamplesRecyclerAdapter mBreedsExamplesRecyclerAdapter;
    private RecyclerView mRecyclerBreedsExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breeds_examples);

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
        mBreedsExamplesRecyclerAdapter.notifyDataSetChanged();
        getLoaderManager().restartLoader(LOADER_BREEDS_EXAMPLE, null,this);
    }

    private void initializeDisplayContent() {
        DataManager.loadFromDatabase(mDbOpenHelper);

        mRecyclerBreedsExample = findViewById(R.id.item_breeds_example);
        mBreedsExampleLayoutManager = new LinearLayoutManager(this);
        mBreedsExamplesRecyclerAdapter = new BreedsExamplesRecyclerAdapter(this,null);

        displayBreedsExamples();
    }

    private void displayBreedsExamples() {
            mRecyclerBreedsExample.setLayoutManager(mBreedsExampleLayoutManager);
            mRecyclerBreedsExample.setAdapter(mBreedsExamplesRecyclerAdapter);
    }

        @SuppressLint("StaticFieldLeak")
    @Override
    public Loader<Cursor> onCreateLoader(int id,  Bundle bundle) {
            CursorLoader loader = null;
            if (id == LOADER_BREEDS_EXAMPLE) {
                loader = new CursorLoader(this) {
                    @Override
                    public Cursor loadInBackground() {
                        SQLiteDatabase db = mDbOpenHelper.getReadableDatabase();
                        final String[] Columns = {
                                BreedsEntry.getQName(BreedsEntry._ID),
                                BreedsEntry.COLUMN_BREED,
                                BreedsEntry.COLUMN_IMAGE,
                                BreedsEntry.COLUMN_EXAMPLES,
                                BreedsEntry.COLUMN_PURPOSE,
                                BreedsEntry.COLUMN_CHARACTERISTICS};

                        final String OrderBy = BreedsEntry.COLUMN_BREED;

                        return db.query(BreedsEntry.TABLE_NAME, Columns, null, null, null, null, OrderBy);
                    }
                };
        }

        return loader;
    }
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (loader.getId() == LOADER_BREEDS_EXAMPLE) {
            mBreedsExamplesRecyclerAdapter.changeCursor(data);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        if (loader.getId()== LOADER_BREEDS_EXAMPLE) {
            mBreedsExamplesRecyclerAdapter.changeCursor(null);
        }
    }

}