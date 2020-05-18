package com.example.covid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import com.example.covid.user;
import java.util.GregorianCalendar;

public class db extends SQLiteOpenHelper {
    GregorianCalendar gcalendar;
    static int uid=0;

    public db(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "users.db", factory, version);
        gcalendar = new GregorianCalendar();
    }

    @Override
    public void onCreate(SQLiteDatabase SQLdb) {
        SQLdb.execSQL("CREATE TABLE USERS (NAME TEXT, MOBNO TEXT PRIMARY KEY, STATE TEXT, CITY TEXT , LOCALITY TEXT,DOB DATE, VOLUNTEER INTEGER , RAWMATERIAL INTEGER, TRANSPORTATION INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
    public String insertUser(user u)
    {
        ContentValues cv=new ContentValues();
        java.sql.Date d1=new java.sql.Date(u.getDob().getTime().getTime());
        //cv.put("ID",uid++);
        cv.put("NAME",u.getName());
        cv.put("MOBNO",u.getPhNo());
        cv.put("STATE",u.getState());
        cv.put("CITY",u.getCity());
        cv.put("LOCALITY",u.getLocality());
        cv.put("DOB", String.valueOf(d1));
        cv.put("VOLUNTEER",u.isVolunteer());
        cv.put("RAWMATERIAL",u.isRawMaterial());
        cv.put("TRANSPORTATION",u.isTransportation());
        this.getWritableDatabase().insertOrThrow("USERS","",cv);
        return String.valueOf(u.getPhNo());

    }
    public String checkPhNo(String phno) {
        SQLiteDatabase sql1=this.getReadableDatabase();
        Cursor cr = sql1.rawQuery("SELECT * FROM USERS WHERE MOBNO='"+phno+"'",null);

        if(cr.getCount()!=0) {
            while (cr.moveToNext()) {
                return cr.getString(1);
            }
        }
        return null;

    }

    public void deleteUser(user u)
    {

    }
}
