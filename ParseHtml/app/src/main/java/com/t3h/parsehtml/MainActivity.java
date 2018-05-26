package com.t3h.parsehtml;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parseHtmlMp3();
    }

    private void parseHtmlMp3() {
        String link = "https://mp3.zing.vn/tim-kiem/bai-hat.html?q=co+gai+m+52";
        new AsyncTask<String, Void, Void>() {
            @Override
            protected Void doInBackground(String... links) {
                try {
                    parse(links[0]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }
                .execute(link);
    }

    private void parse(String link) throws IOException {
        //connect den html de parse thong qua
        Document document =
                Jsoup.connect(link).timeout(20000)
                        .get();
        //lay cac item mong muon
        //par: ten the muon lay
        Elements itemSongs = document.select("div.item-song");
        for (Element itemSong : itemSongs) {
            //trong the co the co nhieu attr
            String dataId = itemSong.attr("data-id");
            Log.d(TAG, "dataId: " + dataId);
            String dataCode = itemSong.attr("data-code");
            Log.d(TAG, "dataCode: " + dataCode);
            try {
                String linkImg =
                        itemSong.selectFirst("img").attr("src");
                Log.d(TAG, "link image: " + linkImg);
            } catch (NullPointerException e) {

            }

            try {
                String name =
                        itemSong.selectFirst("a").attr("title");
                Log.d(TAG, "name: " + name);
            } catch (NullPointerException e) {

            }

            try {
                String url =
                        itemSong.selectFirst("a").attr("href");
                Log.d(TAG, "url: " + url);
            } catch (NullPointerException e) {

            }

        }
    }
}
