package com.amitdev.postview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class PostView extends LinearLayout {
    private ImageView avatarImageView;
    private TextView authorNameTextView;
    private TextView locationTextView;
    private ImageView threeDotsButtonImageView;
    private ImageView postImageView;
    private ImageView heartButtonImageView;
    private TextView numLikesTextView;
    private ImageView commentsButtonImageView;
    private TextView numCommentsTextView;
    private ImageView shareButtonImageView;


    private OnClickListener threeDotsButtonClickListener;
    private OnClickListener heartButtonClickListener;
    private OnClickListener commentsButtonClickListener;
    private OnClickListener shareButtonClickListener;

    public PostView(Context context) {
        super(context);
        init(null);
    }

    public PostView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public PostView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        LayoutInflater.from(getContext()).inflate(R.layout.post_view, this, true);

        // Bind the view elements to their respective fields
        avatarImageView = findViewById(R.id.avatar_image_view);
        authorNameTextView = findViewById(R.id.author_name_text_view);
        locationTextView = findViewById(R.id.location_text_view);
        threeDotsButtonImageView = findViewById(R.id.three_dots_button_image_view);
        postImageView = findViewById(R.id.post_image_view);
        heartButtonImageView = findViewById(R.id.heart_button_image_view);
        numLikesTextView = findViewById(R.id.num_likes_text_view);
        commentsButtonImageView = findViewById(R.id.comments_button_image_view);
        numCommentsTextView = findViewById(R.id.num_comments_text_view);
        shareButtonImageView = findViewById(R.id.share_button_image_view);

        // Get the custom attributes from XML and set their values
        if (attrs != null) {
            TypedArray a = getContext().getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.PostView,
                    0, 0);

            try {
                Drawable avatarImage = a.getDrawable(R.styleable.PostView_avatarImage);
                if (avatarImage != null) {
                    avatarImageView.setImageDrawable(avatarImage);
                }

                String authorName = a.getString(R.styleable.PostView_authorName);
                authorNameTextView.setText(authorName);

                String location = a.getString(R.styleable.PostView_location);
                locationTextView.setText(location);

                Drawable threeDotsButton = a.getDrawable(R.styleable.PostView_threeDotsButton);
                if (threeDotsButton != null) {
                    threeDotsButtonImageView.setImageDrawable(threeDotsButton);
                }

                Drawable postImage = a.getDrawable(R.styleable.PostView_postImage);
                if (postImage != null) {
                    postImageView.setImageDrawable(postImage);
                }

                Drawable heartButton = a.getDrawable(R.styleable.PostView_heartButton);
                if (heartButton != null) {
                    heartButtonImageView.setImageDrawable(heartButton);
                }

                int numLikes = a.getInt(R.styleable.PostView_numLikes, 0);
                numLikesTextView.setText(String.valueOf(numLikes));

                Drawable commentsButton = a.getDrawable(R.styleable.PostView_commentsButton);
                if (commentsButton != null) {
                    commentsButtonImageView.setImageDrawable(commentsButton);
                }

                int numComments = a.getInt(R.styleable.PostView_numComments, 0);
                numCommentsTextView.setText(String.valueOf(numComments));

                Drawable shareButton = a.getDrawable(R.styleable.PostView_shareButton);
                if (shareButton != null) {
                    shareButtonImageView.setImageDrawable(shareButton);
                }
            } finally {
                a.recycle();
            }
        }
    }
    // Setters for the view elements
    public void setAvatarImage(int avatarImage) {
        avatarImageView.setImageResource(avatarImage);
    }

    public void setAuthorName(String authorName) {
        authorNameTextView.setText(authorName);
    }

    public void setLocation(String location) {
        locationTextView.setText(location);
    }

    public void setPostImage(int postImage) {
        postImageView.setImageResource(postImage);
    }

    public void setNumLikes(int numLikes) {
        numLikesTextView.setText(String.valueOf(numLikes));
    }

    public void setNumComments(int numComments) {
        numCommentsTextView.setText(String.valueOf(numComments));
    }

    public void setThreeDotsButton(Drawable threeDotsButton) {
        threeDotsButtonImageView.setImageDrawable(threeDotsButton);
    }

    public void setHeartButton(int heartButton) {
        heartButtonImageView.setImageResource(heartButton);
    }

    public void setCommentsButton(int commentsButton) {
        commentsButtonImageView.setImageResource(commentsButton);
    }

    public void setShareButton(int shareButton) {
        shareButtonImageView.setImageResource(shareButton);
    }

    public void setThreeDotsButtonClickListener(OnClickListener listener) {
        threeDotsButtonImageView.setOnClickListener(listener);
    }

    public void setHeartButtonClickListener(OnClickListener listener) {
        heartButtonImageView.setOnClickListener(listener);
    }

    public void setCommentsButtonClickListener(OnClickListener listener) {
        commentsButtonImageView.setOnClickListener(listener);
    }

    public void setShareButtonClickListener(OnClickListener listener) {
        shareButtonImageView.setOnClickListener(listener);
    }

    // Getters for the view elements
    public Drawable getAvatarImage() {
        return avatarImageView.getDrawable();
    }

    public String getAuthorName() {
        return authorNameTextView.getText().toString();
    }

    public String getLocation() {
        return locationTextView.getText().toString();
    }

    public int getNumLikes() {
        return Integer.parseInt(numLikesTextView.getText().toString());
    }

    public int getNumComments() {
        return Integer.parseInt(numCommentsTextView.getText().toString());
    }

    public Drawable getPostImage() {
        return postImageView.getDrawable();
    }

    public ImageView getAvatarImageView() {
        return avatarImageView;
    }

    public TextView getAuthorNameTextView() {
        return authorNameTextView;
    }

    public TextView getLocationTextView() {
        return locationTextView;
    }

    public ImageView getThreeDotsButtonImageView() {
        return threeDotsButtonImageView;
    }

    public ImageView getPostImageView() {
        return postImageView;
    }

    public ImageView getHeartButtonImageView() {
        return heartButtonImageView;
    }

    public TextView getNumLikesTextView() {
        return numLikesTextView;
    }

    public ImageView getCommentsButtonImageView() {
        return commentsButtonImageView;
    }

    public TextView getNumCommentsTextView() {
        return numCommentsTextView;
    }

    public ImageView getShareButtonImageView() {
        return shareButtonImageView;
    }


}

