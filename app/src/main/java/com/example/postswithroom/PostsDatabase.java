package com.example.postswithroom;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Post.class, version = 1)
abstract class PostsDatabase  extends RoomDatabase {

    private static PostsDatabase instance;
    public abstract PostsDao postsDao();

    public static  synchronized PostsDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context,
                            PostsDatabase.class, "posts_database")

                    .fallbackToDestructiveMigration()
                    .build();

        }
        return instance;
    }

}
