package main;

import java.io.*;
import java.util.*;

public class MainAccount
{
    public static void main(String[] args)
    {
        MainInterface();
    }
    public static void MainInterface()
    {
        MainAccount ma = new MainAccount();
        Scanner sc = new Scanner(System.in);
        int channel = 0;
        while(channel!=4)
        {
            System.out.print("|1 = 收入");
            System.out.println("                                                    |");
            System.out.print("|2 = 支出");
            System.out.println("                                                    |");
            System.out.print("|3 = 帳目表");
            System.out.println("                                                  |");
            System.out.print("|4 = 離開");
            System.out.println("                                                    |");
            System.out.print("請輸入：");
            channel = sc.nextInt();
            if(channel == 1)
            {
                System.out.print("輸入收入：");
                Variable.i = sc.next();
                Variable.maximize++;
            }
            else if(channel == 2)
            {
                System.out.print("輸入收入：");
                Variable.j = sc.next();
                Variable.maximize++;
            }
            else if(channel == 3)
            {
                ma.Statement();
            }
            else if(channel >4)
            {
                System.out.println("錯誤!!!");
            }
        }
        sc.close();
    }
    protected void Statement()
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

class Variable
{
    public static int maximize = 0;
    public static String i = "0";
    public static String j = "0";
    public static Long income = Long.parseUnsignedLong(i);
    public static Long expenditure = Long.parseUnsignedLong(j);
    public static Long buffer = Long.parseUnsignedLong((Long.toString(income-expenditure)));
    public static Long money = Long.parseUnsignedLong(Long.toString(buffer));
}