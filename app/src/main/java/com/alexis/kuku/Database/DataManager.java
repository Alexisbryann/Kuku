package com.alexis.kuku.Database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.alexis.kuku.Breeds.BreedsInfo;

import java.util.ArrayList;
import java.util.List;

import static com.alexis.kuku.Database.DataBaseContract.*;

public class DataManager {
    private static DataManager ourInstance = null;
    private List<BreedsInfo> mBreeds = new ArrayList<>();

    public static DataManager getInstance(){
        if (ourInstance == null){
            ourInstance=new DataManager();
        }
        return ourInstance;
    }
    public static void loadFromDatabase (DataBaseOpenHelper dataBaseOpenHelper){
        SQLiteDatabase database = dataBaseOpenHelper.getReadableDatabase();
        final  String[] breedsColumns = {
                BreedsEntry.COLUMN_IMAGE,
                BreedsEntry.COLUMN_BREED,
                BreedsEntry.COLUMN_PURPOSE,
                BreedsEntry.COLUMN_EXAMPLES,
                BreedsEntry.COLUMN_CHARACTERISTICS};
        final Cursor breedsCursor = database.query(BreedsEntry.TABLE_NAME,breedsColumns,null,null,null,null,BreedsEntry.COLUMN_BREED + " DESC");
        loadBreedsFromDatabase(breedsCursor);
    }

    private static void loadBreedsFromDatabase(Cursor breedsCursor) {

        int imagePos = breedsCursor.getColumnIndex(BreedsEntry.COLUMN_IMAGE);
        int breedPos = breedsCursor.getColumnIndex(BreedsEntry.COLUMN_BREED);
        int purposePos = breedsCursor.getColumnIndex(BreedsEntry.COLUMN_PURPOSE);
        int examplesPos = breedsCursor.getColumnIndex(BreedsEntry.COLUMN_EXAMPLES);
        int characteristicsPos = breedsCursor.getColumnIndex(BreedsEntry.COLUMN_CHARACTERISTICS);

        DataManager dm = getInstance();
        dm.mBreeds.clear();
        while (breedsCursor.moveToNext()){

            String image = breedsCursor.getString(imagePos);
            String breed = breedsCursor.getString(breedPos);
            String purpose = breedsCursor.getString(purposePos);
            String examples = breedsCursor.getString(examplesPos);
            String characteristics = breedsCursor.getString(characteristicsPos);

            BreedsInfo breedsInfo = new BreedsInfo(image,breed,purpose,examples,characteristics);

            dm.mBreeds.add(breedsInfo);
        }
        breedsCursor.close();
    }

    public List<BreedsInfo> getBreeds() {return mBreeds;}

    public BreedsInfo getBreed(String id){
        for (BreedsInfo breedsInfo :mBreeds){
            if (id.equals(breedsInfo.getBreed()))
                return breedsInfo;
        }
        return null;
    }
}
