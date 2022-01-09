package com.lab.services;

import java.io.*;

public class FileIOHandler {

    public static void writeToFile(String content, String filePath)
    {
        try {

            File file = new File(filePath);
            if(!file.exists()){ file.createNewFile();}

            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(content);

            writer.close();
        }
        catch (Exception ex){ ex.printStackTrace(); }
    }
}
