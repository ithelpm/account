package com.github.ithelpm;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.stream.*;

public class App {
    public static void main(String[] args) throws IOException {
        String getDataPath = getPath();
        System.out.println(getDataPath);
    }

    private static String getPath() {
        try {
            ProcessBuilder pb = new ProcessBuilder().command("python", "-u", 
                findPath(new File(System.getProperty("user.dir")).toPath(), "readPath.py"));
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

    private static String findPath(Path startFrom, String Name) throws IOException {
        String path;
        try(
            Stream<Path> stream = 
                Files.find(startFrom, Integer.MAX_VALUE, (p, BasicFileAttributes)->
                    p.getFileName().toString().equalsIgnoreCase(Name))
        ) {
            StringBuilder delBraces = new StringBuilder();
            stream.collect(Collectors.toList()).forEach(delBraces::append);
            path = delBraces.toString();
        }
        return path;
    }
}
