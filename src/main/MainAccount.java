package main;

import java.io.*;
import java.util.*;

public class MainAccount
{
    public static void main(String[] args)
    {
        Interface.MainInterface();
        System.out.print("\033\143");
        System.out.println();
    }
    static class Interface
    {
        public static void MainInterface()
        {
            Interface i = new Interface();
            Scanner sc = new Scanner(System.in);
            int channel = 0;
            while(channel!=4)
            {
                System.out.print("|1 = income");
                System.out.println("                                                  |");
                System.out.print("|2 = expenditure");
                System.out.println("                                             |");
                System.out.print("|3 = statement of account");
                System.out.println("                                    |");
                System.out.print("|4 = exit");
                System.out.println("                                                    |");
                System.out.print("input：");
                channel = sc.nextInt();
                System.out.flush();
                if(channel == 1)
                {
                    System.out.print("input income：");
                    Variable.i = sc.next();
                    Variable.maximize++;
                }
                else if(channel == 2)
                {
                    System.out.print("input expenditure：");
                    Variable.j = sc.next();
                    Variable.maximize++;
                }
                else if(channel == 3)
                {
                    i.Statement();
                }
                else if(channel >4)
                {
                    System.out.println("ERROR!!!");
                }
            }
            sc.close();
        }
        protected void Statement()
        {
            
        }
    }
    static class infoIO
    {
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
    static class Variable
    {
        Variable(){}
        public static int maximize = 0;
        public static String i = "0";
        public static String j = "0";
        public static Long income = Long.parseUnsignedLong(i);
        public static Long expenditure = Long.parseUnsignedLong(j);
        public static Long buffer = Long.parseUnsignedLong((Long.toString(income-expenditure)));
        public static Long money = Long.parseUnsignedLong(Long.toString(buffer));
    }
}



