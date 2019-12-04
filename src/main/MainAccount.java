package main;

import java.io.*;
import java.util.*;

public class MainAccount
{
    public static void main(String[] args)
    {
        String readableFile;
        if(FileCookie())
        {
            fileCreate();
            System.out.print("\033\143");
            System.out.println();
        }else{
            readableFile = fileFind();
        }
        Interface.MainInterface();
        System.out.print("\033\143");
        System.out.println();
    }
    protected static Scanner fileFind()
    {
        if(Variable.fileName != null)
            Variable.myFile = new File(Variable.fileName);
        Scanner reader = new Scanner(Variable.myFile);
        return reader;
    }
    protected static boolean fileCreate()
    {
        Scanner sc = new Scanner();
        System.out.print("Enter your file name: ");
        Variable.fileName = sc.next();
        path = Variable.path + Variable.fileName;
        System.out.println();
        File File = new File(path);
        boolean bool = file.mkdirs();
        if(bool){
           System.out.println("Directory created successfully");
        }else{
           System.out.println("Sorry couldnt create specified directory:\r\n maybe already exist??");
        }
        return bool;
    }
    private static int FileCookie()
    {
        boolean bool = filecreate();
        int cookie;
        if(bool)
            cookie = 1;
        else
            cookie = 0;
        return cookie;
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
        public static File myfile;
        public static String fileName;
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