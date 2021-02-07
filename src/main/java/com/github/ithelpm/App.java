package com.github.ithelpm;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class App {
    public static void main(String[] args) {
        String getDataPath = getPath();
        System.out.println(getDataPath);
    }

    private static String getPath() {
        try {
            ProcessBuilder pb = new ProcessBuilder().command("python", "-u");
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

    private static List<Path> findPath(Path startFrom, String Name) {
        
    }
}
