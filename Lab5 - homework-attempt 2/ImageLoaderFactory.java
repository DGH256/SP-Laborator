package com.company;

import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImageLoaderFactory {

    public ImageLoader create(String imageName) throws Exception {
        if(imageName.toLowerCase().endsWith("jpg"))
        {
            return new JPGImageLoader(imageName);
        }
        else
            if(imageName.toLowerCase().endsWith("bmp"))
            {
                return new BMPImageLoader(imageName);
            }
            else
                if(imageName.toLowerCase().endsWith("png"))
                {
                return new PNGImageLoader(imageName);
                }

        throw new Exception("Unsupported image type");
    }

}
