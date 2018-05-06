package com.example.fadil.butterknifeglide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailActivityWithGlide extends AppCompatActivity {

    @BindView(R.id.tv_alamat_glide)
    TextView alamat;
    @BindView(R.id.tv_nama_glide)
    TextView nama;
    @BindView(R.id.tv_ttl_glide)
    TextView ttl;
    @BindView(R.id.detail_glide)
    ImageView glide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_with_glide);
        ButterKnife.bind(this);

        String nama1 = getIntent().getStringExtra("nama");
        String alamat1 = getIntent().getStringExtra("alamat");
        String ttl1 = getIntent().getStringExtra("ttl");

        //String url="http://1.bp.blogspot.com/-4RyfkbSlWeg/VqCsqHV_p0I/AAAAAAAAH44/UWqUeAGwzN8/s1600/Gambar%2BNaruto%2BTerbaru%2B2016%2B5.jpg";
        //Load Image GIF
        String url = "https://media.giphy.com/media/a7EUhsVF4qHQI/giphy.gif";

        Glide.with(this).load(url)
                .thumbnail(0.5f)
                .error(R.drawable.foto)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL).
                into(glide);

        set(ttl1,alamat1,nama1);

    }
    public void  set(String ttl1,String alamat1,String nama1){
        ttl.setText(ttl1);
        alamat.setText(alamat1);
        nama.setText(nama1);
    }
}
