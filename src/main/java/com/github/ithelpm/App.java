package com.github.ithelpm;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import javafx.stage.Stage;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.application.Application;

public class App extends Application {
    protected static Path scriptLib;
    protected static Path dataPath;
    protected static String dataName = "Data Storage.csv";
    
    protected static String storagePath;
    protected static String storage = "Spent.csv";
    protected static Path fxmlPath;
    protected static String data2write;
    
    public static void main(String[] args) throws Exception{
        PathTool pt = new PathTool();
        String cwd = "user.dir";
        dataPath = pt.findFolder(new File(System.getProperty(cwd)), "storage");
        scriptLib = pt.findFolder(new File(System.getProperty(cwd)), "pythonScript");
        fxmlPath = pt.findFolder(new File(System.getProperty(cwd)), "fxmlLib");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        PathTool pt = new PathTool();
        if (pt.isCreated()&&new File(App.dataPath+"\\"+App.dataName).length()!=0) {
            //if path have been choosen, then initial the storage path to the one in the Data Storage.csv
            storagePath = pt.executeScript(scriptLib, "readStorage.py");
            //show main scene after initial
            stage.setScene(mainScene(fxmlPath.toString()));
            stage.show();
        } else {
            var loader = new FXMLLoader();
            loader.setClassLoader(getClass().getClassLoader());
            loader.setLocation(new File(fxmlPath+"\\Chooser.fxml").toURI().toURL());
            Parent dirChooser = loader.load();
            stage.setScene(new Scene(dirChooser));
            stage.show();
        }
    }

    @Override
    public void stop() {

    }

    public static Scene mainScene(String path2FXML){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(new File(path2FXML+"\\App.fxml").toURI().toURL());
            Parent root = loader.load();
            return new Scene(root);
        } catch(IOException e) {
            System.err.println(e);
        }
        return null;
    }
}

class Writer {
    private static File createNewFile(String Path, String Name) {
        File file = new File(Path + "\\" + Name);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.err.println("An error occured when creating file:" + e);
        }
        return file;
    }
}

class PathTool {
    public String executeScript(Path from, String command) {
        try {
            ProcessBuilder pb = new ProcessBuilder().command("python", "-u", from.toString() + "\\" + command);
            Process p = pb.start();
            p.waitFor();
            Scanner sc = new Scanner(p.getInputStream());
            StringBuilder buffer = new StringBuilder();

            while (sc.hasNext()) {
                buffer.append(sc.next());
            }
            sc.close();

            return buffer.toString();
        } catch (InterruptedException|IOException e) {
            System.err.println(e);
        }
        return "";
    }

    public Path findFolder(File rootDir, String name) {
        if (rootDir.getName().equals(name)) {
            return rootDir.toPath();
        } else {
            File[] files = rootDir.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        Path result = findFolder(f, name);
                        if (result == null) {
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
        File checkFile = new File(App.dataPath.toString());
        if (checkFile.isDirectory()) {
            String[] files = checkFile.list();
            if (files.length > 0) {
                flag = true;
            }
        }
        return flag;
    }
}
