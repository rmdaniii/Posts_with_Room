package com.example.postswithroom;

import android.database.Observable;

import androidx.room.Dao;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.rxjava3.core.Completable;

@Dao
interface PostsDao {

    @Insert
    Completable insertPost(Post post);

    @Query("select * from posts_table")
    Single<List<Post>> getPosts();

}
