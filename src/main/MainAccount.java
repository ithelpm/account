package main;

import java.io.*;
import java.util.*;
import java.nio.charset.*;

public class MainAccount
{
    public static void main(String[] args)
    {
        FileCreator();
    }

    protected static void FileCreator() 
    {
        File file = new File(Variable.path);
        boolean bool = true;
        try{
            file.createNewFile();
        }catch(IOException e){
            bool = false;
            e.printStackTrace();
        }
        if (bool)
        {
            System.out.println("File is created!");
        } else {
            System.out.println("File already exists.");
        }
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(Variable.path), StandardCharsets.UTF_8);
        writer.write("Test data");
        writer.close();
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
        public static String path = "C:\\Windows\\java's_data.txt";
        public static int maximize = 0;
        public static String i = "0";
        public static String j = "0";
        public static Long income = Long.parseUnsignedLong(i);
        public static Long expenditure = Long.parseUnsignedLong(j);
        public static Long buffer = Long.parseUnsignedLong((Long.toString(income-expenditure)));
        public static Long money = Long.parseUnsignedLong(Long.toString(buffer));
    }
}