package com.minto.soft.moviesapp.ui.moviedetails.trailers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.youtube.player.YouTubePlayer;
import com.minto.soft.moviesapp.R;
import com.minto.soft.moviesapp.data.local.model.Trailer;
import com.minto.soft.moviesapp.databinding.ItemTrailerBinding;
import com.minto.soft.moviesapp.utils.Constants;
import com.minto.soft.moviesapp.utils.GlideApp;
import com.thefinestartist.ytpa.YouTubePlayerActivity;
import com.thefinestartist.ytpa.enums.Orientation;


public class TrailerViewHolder extends RecyclerView.ViewHolder {

    private ItemTrailerBinding binding;

    private Context context;

    public TrailerViewHolder(@NonNull ItemTrailerBinding binding, Context context) {
        super(binding.getRoot());

        this.binding = binding;
        this.context = context;
    }

    public void bindTo(final Trailer trailer) {
        String thumbnail =
                "https://img.youtube.com/vi/" + trailer.getKey() + "/hqdefault.jpg";
        GlideApp.with(context)
                .load(thumbnail)
                .placeholder(R.color.md_grey_200)
                .into(binding.imageTrailer);

        binding.trailerName.setText(trailer.getTitle());

        binding.cardTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, YouTubePlayerActivity.class);
                // Youtube video ID (Required, You can use YouTubeUrlParser to parse Video Id from url)
                intent.putExtra(YouTubePlayerActivity.EXTRA_VIDEO_ID, trailer.getKey());

                // Youtube player style (DEFAULT as default)
                intent.putExtra(YouTubePlayerActivity.EXTRA_PLAYER_STYLE, YouTubePlayer.PlayerStyle.DEFAULT);

                // Screen Orientation Setting (AUTO for default)
                // AUTO, AUTO_START_WITH_LANDSCAPE, ONLY_LANDSCAPE, ONLY_PORTRAIT
                intent.putExtra(YouTubePlayerActivity.EXTRA_ORIENTATION, Orientation.AUTO);

                // Show audio interface when user adjust volume (true for default)
                intent.putExtra(YouTubePlayerActivity.EXTRA_SHOW_AUDIO_UI, true);

                // If the video is not playable, use Youtube app or Internet Browser to play it
                // (true for default)
                intent.putExtra(YouTubePlayerActivity.EXTRA_HANDLE_ERROR, true);

                // Animation when closing youtubeplayeractivity (none for default)
                intent.putExtra(YouTubePlayerActivity.EXTRA_ANIM_ENTER, R.anim.fade_in);
                intent.putExtra(YouTubePlayerActivity.EXTRA_ANIM_EXIT, R.anim.fade_out);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        binding.executePendingBindings();
    }

    public static TrailerViewHolder create(ViewGroup parent) {
        // Inflate
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // Create the binding
        ItemTrailerBinding binding =
                ItemTrailerBinding.inflate(layoutInflater, parent, false);
        return new TrailerViewHolder(binding, parent.getContext());
    }
}
