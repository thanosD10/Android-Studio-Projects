package gr.hua.dit.android.daoapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Contact.class}, version = 1)
public abstract class ContactsDatabase extends RoomDatabase {
    public abstract ContactsDao ContactsDao();
}
