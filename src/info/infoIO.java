package info;

import java.io.*;

class indoIO
{ 
    public static void IO(String path)
    {
        String encoding = "UTF-8";
        int txt_long;
        File file = new File(path);
        if (file.isFile() && file.exists())
        {
            InputStreamReader read = new InputStreamReader(file, encoding);
            txt_long = read.read();
        }
    }
}