package main;

import java.io.*;

public class MainAccount
{
    public static void main(String[] args)
    {
        
    }
}

public class infoIO {
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