package com.company;

public class ImageLoaderFactory {

    public ImageLoader create(String imageName) throws Exception {
        if(imageName.endsWith("jpg"))
        {
            return new JPGImageLoader(imageName);
        }
        else
            if(imageName.endsWith("bmp"))
            {
                return new BMPImageLoader(imageName);
            }

        throw new Exception("Unsupported image type");
    }
}
