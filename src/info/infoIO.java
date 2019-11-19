package info;

import java.io.*;

class indoIO
{ 
    public static void IO(String path)
    {
        String encode = "UTF-8";
        FileReader reader = new FileReader(path);
        File file = new File(path);
        BufferedReader br = new BufferedReader(reader);
        String line = br.readLine();
        while(line != null)
        {
            System.out.println(line);
        }
        br.close();
    }
}