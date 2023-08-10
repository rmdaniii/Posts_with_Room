package com.example.postswithroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;


import io.reactivex.SingleObserver;
import io.reactivex.CompletableObserver;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private RecyclerView postsRecycler;
    private Button insertBtn, getBtn;
    private EditText titleEdt, bodyEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //some widget
        insertBtn  = findViewById(R.id.insert_post_btn);
        getBtn  = findViewById(R.id.git_post_btn);
        titleEdt   = findViewById(R.id.title_post_edt);
        bodyEdt   = findViewById(R.id.body_post_edt);


        //Recycler View Implement
        postsRecycler = findViewById(R.id.list_posts_rcy);
        PostsAdapter adapter = new PostsAdapter();
        postsRecycler.setAdapter(adapter);

        final PostsDatabase postsDatabase = PostsDatabase.getInstance(this);

        // Insert Posts Buttom
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             
            }
        });
        postsDatabase.postsDao().insertPost(new Post(new User(1,"Ahmed"),titleEdt.getEditableText().toString(),
                bodyEdt.getEditableText().toString()))
                .subscribeOn(Schedulers.computation())
                
        //Get Button for list posts
        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postsDatabase.postsDao().getPosts()
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new SingleObserver<List<Post>>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onSuccess(List<Post> posts) {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        });
            }
        });


    }
}