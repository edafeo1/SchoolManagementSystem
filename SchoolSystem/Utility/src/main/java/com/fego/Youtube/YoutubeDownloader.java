package com.fego.Youtube;

import com.github.axet.vgetVGet;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class YoutubeDownloader {
    public static void main(String[] args) throws MalformedURLException {
        try {
            // ex: http://www.youtube.com/watch?v=Nj6PFaDmp6c
            String url = 'Video Url';
            // ex: "/Users/axet/Downloads"
            String path = "Path on device to save";
            VGet v = new VGet(new URL(url), new File(path));
            v.download();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
