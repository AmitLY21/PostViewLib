# PostView Library 📱💻📊

PostView is a custom view library for displaying social media posts in Android applications.📲💬📝</br>
This library is easy to use and highly customizable, allowing you to display social media posts in the way that best suits your app's design.🎨👨‍💻💡 </br>

## Installation 🔧
To use the PostView library in your Android project, follow these steps:
<ol>
<li>Add the JitPack repository to your root build.gradle file: </br></li>

```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

<li>Add the library dependency to your app build.gradle file:</br></li>

```gradle
dependencies {
	implementation 'com.github.AmitLY21:PostViewLib: 1.0.1'
}
```

Note: Replace Tag with the desired version of the library (e.g. v1.0.0).</br>
</ol>


## Usage 🚀
To use the PostView in your app, simply add it to your layout XML file like any other view. Here is an example:</br>

```xml
<com.amitdev.postview.PostView
    android:id="@+id/post_view"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:avatarImage="@drawable/avatar"
    app:authorName="John Doe"
    app:location="San Francisco, CA"
    app:postImage="@drawable/post"
    app:numLikes="100"
    app:numComments="50"
    app:threeDotsButton="@drawable/ic_three_dots"
    app:heartButton="@drawable/ic_heart"
    app:commentsButton="@drawable/ic_comment"
    app:shareButton="@drawable/ic_share" />
``` 
    
You can also set the values of the view programmatically by using the setter methods provided by the PostView class. For example:</br>

```Java
PostView postView = findViewById(R.id.post_view);
postView.setAvatarImage(R.drawable.avatar);
postView.setAuthorName("John Doe");
postView.setLocation("San Francisco, CA");
postView.setPostImage(R.drawable.post);
postView.setNumLikes(100);
postView.setNumComments(50);
postView.setThreeDotsButton(getResources().getDrawable(R.drawable.ic_three_dots));
postView.setHeartButton(R.drawable.ic_heart);
postView.setCommentsButton(R.drawable.ic_comment);
postView.setShareButton(R.drawable.ic_share);
```

You can also set click listeners on the view elements by using the setter methods provided by the PostView class. For example:</br>

```Java
postView.setThreeDotsButtonClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // Handle three dots button click
    }
});

postView.setHeartButtonClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // Handle heart button click
    }
});

postView.setCommentsButtonClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // Handle comments button click
    }
});

postView.setShareButtonClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // Handle share button click
    }
});
```

## Demo 📹

<p align="center">
  <img src="https://user-images.githubusercontent.com/62396197/233796439-2653ceca-7293-4a18-95c4-bc416670b738.png" width="450">
</p>

To implement the feature shown in the image above, follow these:


```Java
package com.amitdev.postview;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    PostView postView;
    boolean isLiked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postView = findViewById(R.id.post_view);

        postView.setAuthorName("Amit Levy");
        postView.setLocation("Tel Aviv");

        postView.setAvatarImage(R.drawable.avatar);
        postView.setPostImage(R.drawable.demo_post_image);
        postView.setHeartButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isLiked) {
                    postView.setHeartButton(R.drawable.fav);
                    int likes = postView.getNumLikes() + 1;
                    postView.setNumLikes(likes);
                    isLiked = true;
                }
            }
        });

        postView.setShareButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                startActivity(Intent.createChooser(shareIntent, "Share via"));
            }
        });

        postView.setThreeDotsButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage("Report on this User?");
                builder.setCancelable(true);
                builder.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                builder.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });


    }
}
```
