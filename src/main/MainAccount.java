package main;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.*;

public class MainAccount
{
    public static void main(String[] args)
    {
        if(Variable.myfile.exists() == false)
        {
	        FileCreate();
        }
        MainInterface();
    }

    protected static void FileCreate()
    {
        try {
            if (Variable.myfile.createNewFile())
                System.out.println("File created");
            else
                System.out.println("File already exists");
        } catch (Exception e) {
            System.out.println("File create failuired");
            System.err.println(e); 
        }
    }
    public static void MainInterface()
    {
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
            }
            else if(channel == 2)
            {
                System.out.print("input expenditure：");
                Variable.j = sc.next();
            }
            else if(channel == 3)
            {
                Statement(); // 這啥？寫入資料？
            }
            else
            {
                System.out.println("Error!");
            }
            }
        sc.close();
    }
    protected static void Statement()
    {
        List<String> lines = Arrays.asList(Long.toString(Variable.income+Variable.expenditure));
       try{
            Path file = Paths.get("D:\\java_file\\AccountData.txt");
            Files.write(file, lines, StandardCharsets.UTF_8);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
class Variable
{
    Variable(){}
    public static String path = "E:\\java_file\\AccountData.txt";
    public static File myfile = new File(path);
    public static String i = "0";
    public static String j = "0";
    public static Long income = Long.parseUnsignedLong(i);
    public static Long expenditure = Long.parseUnsignedLong(j);
    public static Long buffer = Long.parseUnsignedLong((Long.toString(income-expenditure)));
    public static Long money = Long.parseUnsignedLong(Long.toString(buffer));
}
