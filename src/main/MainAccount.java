package main;

import java.io.*;

public class MainAccount
{
    public static void main(String[] args) throws IOException,Error
    {
        infoIO.IO("C:\\Users\\user\\Desktop\\javaCrawler.txt");
    }
    private static void interface()
    {

    }
}

class infoIO {
    public static void IO(String path) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();
        System.out.println(br.readLine());
        while((line = br.readLine() ) != null)
        {
            System.out.println(line);
        }
        br.close();
    }
}