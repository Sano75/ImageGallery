package com.example.imagegallery;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, 1);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertData(String describe, byte[] image){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO ImageTbl VALUES (NULL, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,describe );
        statement.bindBlob(2, image);

        statement.executeInsert();
    }

    public void updateData(String describe,byte[] image, int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "UPDATE ImageTbl SET describe = ?, image = ? WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);

        statement.bindString(1, describe);
        statement.bindBlob(2, image);
        statement.bindDouble(3, (double)id);

        statement.execute();
        database.close();
    }

    public  void deleteData(int id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM ImageTbl WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1, (double)id);

        statement.execute();
        database.close();
    }
    public void lastRowDelete(){
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM ImageTbl order by id desc limit 1";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.execute();
        database.close();
    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
