package main;

import java.io.*;
import java.util.*;

public class MainAccount {
    public static void main(String[] args) {

    }

    protected static void FileCreator()
    {
        try {
            Process p = Runtime.getRuntime().exec("python fileCreator.py");
            p.wait(1000);
            p.destroy();
        } catch (IOException|InterruptedException e) {
            System.out.println("cannot create file or "+" fileCreator.py "+" mot found");
            e.printStackTrace();
        }
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
                    System.out.print("\033\143");
                    System.out.println();
                }
                else if(channel == 2)
                {
                    System.out.print("input expenditure：");
                    Variable.j = sc.next();
                    Variable.maximize++;
                    System.out.print("\033\143");
                    System.out.println();
                }
                else if(channel == 3)
                {
                    i.Statement();
                }
                else if(channel >4)
                {
                    System.out.println("ERROR!!!");
                    System.out.print("\033\143");
                    System.out.println();
                }
            }
            sc.close();
        }
        protected void Statement()
        {
            
        }
    }
    static class Variable
    {
        Variable(){}
        public static File myfile;
        public static String fileName = "";
        public static String path = "C:\\Windows\\";
        public static int maximize = 0;
        public static String i = "0";
        public static String j = "0";
        public static Long income = Long.parseUnsignedLong(i);
        public static Long expenditure = Long.parseUnsignedLong(j);
        public static Long buffer = Long.parseUnsignedLong((Long.toString(income-expenditure)));
        public static Long money = Long.parseUnsignedLong(Long.toString(buffer));
    }
}