package com.github.ithelpm;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.stream.*;

public class App {
    protected static Path scriptLib;
    protected static Path txtPath;
    protected static String dataPath;
    public static void main(String[] args) {
        String cwd = "user.dir";
        PathTool pt = new PathTool();
        txtPath = pt.findFolder(new File(System.getProperty(cwd)), "txt");
        System.out.println(txtPath);
        scriptLib = pt.findFolder(new File(System.getProperty(cwd)), "pythonScript");
        Writer wt = new Writer();
        if(pt.isCreated()) {

        } else {
            dataPath = pt.executeScript(scriptLib, "readPath.py");
            wt.appendData(txtPath.toString(), "DataSign.txt", "choosedPath", dataPath);
        }
    }
}

class Writer {
    private static File createNewFile(String Path, String Name){
        File file = new File(Path+"\\"+Name);
        try{
            if(file.createNewFile()){}
        } catch(IOException e) {
            System.err.println("An error occured when creating file:"+e);
        }
        return file;
    }

    public void appendData(String path, String Name, String usage, String data) {
        
        File file = createNewFile(path, Name);
        try(BufferedWriter out = new BufferedWriter(new FileWriter(file, true))){
            out.write("["+usage+":"+data+"]");
        } catch(IOException e) {
            System.err.println("An error occured when writing file:"+e);
        }
    }
}

class PathTool {
    public String executeScript(Path from, String scriptName) {
        try {
            ProcessBuilder pb = new ProcessBuilder().command("python", "-u", from.toString()+"\\"+scriptName);
            Process p = pb.start();

            Scanner sc = new Scanner(p.getInputStream());
            StringBuilder buffer = new StringBuilder();

            while (sc.hasNext()) {
                buffer.append(sc.next());
            }
            sc.close();
            
            return buffer.toString();
        } catch(IOException e) {
            System.err.println(e);
        }
        return "";
    }

    public String executeScript() {
        return executeScript(null, "");
    }

    public List<Path> findPath(Path startFrom, String Name) throws IOException {
        List<Path> path;
        try(
            Stream<Path> stream = 
                Files.find(startFrom, Integer.MAX_VALUE, (p, BasicFileAttributes)->
                    p.getFileName().toString().equalsIgnoreCase(Name))
        ) {
            path = stream.collect(Collectors.toList());
        }
        return path;
    }

    public Path findFolder(File rootDir, String name) {
        if(rootDir.getName().equals(name)) {
            return rootDir.toPath();
        } else {
            File[] files = rootDir.listFiles();
            if(files!=null) {
                for (File f : files) {
                    if(f.isDirectory()) {
                        Path result = findFolder(f, name);
                        if(result==null) {
                            continue;
                        } else {
                            return result;
                        }
                    }
                }
            }
        }
        return null;
    }

    public boolean isCreated() {
        boolean flag = false;
        File checkFile = new File(App.txtPath.toString());
        if(checkFile.isDirectory()) {
            String[] files = checkFile.list();
            if(files.length>0) {
                flag = true;
            }
        }
        return flag;
    }
}

class Gui {
    public Gui() {

    }
}
