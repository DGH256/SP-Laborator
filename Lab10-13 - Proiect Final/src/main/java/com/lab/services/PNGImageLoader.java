package com.lab.services;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PNGImageLoader implements ImageLoader{

    private String url;
    private BufferedImage loadedImage= null;

    public PNGImageLoader(String imageUrl)
    {
        this.url = imageUrl;
    }

    @Override
    public BufferedImage load() throws IOException {

        if(loadedImage == null) {
            loadedImage = ImageIO.read(new File(url));
        }
        return loadedImage;
    }
}