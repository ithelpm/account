package main;

import java.io.*;
import java.util.*;
import jdk.jfr.Label;
import java.nio.file.*;
import java.nio.charset.*;

class Variable//where the all variable comes from
{
    public static String[] word = new String[]{"0","0"};
    public static Long income = Long.parseUnsignedLong(i);
    public static Long expenditure = Long.parseUnsignedLong(j);
    public static Long buffer = Long.parseUnsignedLong((Long.toString(income-expenditure)));
    public static Long money = Long.parseUnsignedLong(Long.toString(buffer));
    public static List<String> lines;
    public static String path = "D:\\java_file\\AccountData.txt";
    public static String folder = "D:\\java_file";
    public static File myfile = new File(path);
    public static Integer count=0;
    public static String line;
}
public class MainAccount extends Variable
{
    public static void main(String[] args)
    {
        ReadFile rf = new ReadFile(myfile);
        ArrayList<String> al = rf.overrideString();
        line = al.get(0);
        for (int i1 = Integer.parseInt(line); i1>0 ; i1--)
        {
            word[i1] = al.get(i1);
            System.out.println(word[i1]);
        }
        if(!myfile.exists())
        {
	        FileCreate();
        }
        MainInterface();
    }

    protected static void FileCreate()
    {
        try {
            File file = new File(Variable.folder);
            file.mkdirs();
            if (Variable.myfile.createNewFile())
                System.out.println("File created");
            else
                System.out.println("File already exists");
        } catch (IOException e) {
            System.out.println("File create failuired.\nCause by:");
            System.err.println(e);
        }
    }
    protected static void editor()
    {
       try{
            Path file = Paths.get("D:\\java_file\\AccountData.txt");
            Files.write(file, Variable.lines, StandardCharsets.UTF_8);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void MainInterface()
    {
        Scanner sc = new Scanner(System.in);
        int channel = 0;
        while(channel!=4)
        {
            System.out.print("|1 = income                                                  |"+"\n");
            System.out.print("|2 = expenditure                                             |"+"\n");
            System.out.print("|3 = save                                                    |"+"\n");
            System.out.print("|4 = exit                                                    |"+"\n");
            System.out.print("input：");
            channel = sc.nextInt();
            if(channel == 1)
            {
                System.out.print("input income：");
                i = sc.next();
                income = Long.parseUnsignedLong(i);
            }
            else if(channel == 2)
            {
                System.out.print("input expenditure：");
                j = sc.next();
                expenditure = Long.parseUnsignedLong(j);
            }
            else if(channel == 3)
            {
                lines = Arrays.asList("2",
                                      Long.toString(income),
                                      Long.toString(expenditure),
                                      Long.toString(income-expenditure));
                System.out.println(lines.get(0));
                editor();
            }
            else if(channel == 4){}
            else
            {
                System.out.println("Error!");
            }
        }
        sc.close();
    }
}
class ReadFile
{
    File files;
    int counts = Variable.count;
    ReadFile(File file){this.files = file;}
    void display()
    {
        try{
            Scanner sc = new Scanner(files);
            for(;sc.hasNextLine();)
            {
                System.out.println("String inputing");
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred\nCause by");
            System.err.println(e);
        }
    }
    ArrayList<String> overrideString()
    {
        Scanner sc = new Scanner(files);
        ArrayList<String> list = new ArrayList<String>();
        while (sc.hasNext()){
            list.add(s.next());
        }
        sc.close();
        return list;
    }
}