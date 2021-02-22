package com.github.ithelpm;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.stream.*;
import javafx.stage.Stage;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.Parent;
import com.opencsv.CSVWriter;
import javafx.application.Application;

public class App extends Application {
    protected static Path scriptLib;
    protected static Path storePath;
    public static String dataPath = "StorePath.txt";
    protected static String dataName = "Data Storage.json";
    protected static Path fxmlPath;

    public static void main(String[] args) throws Exception{
        PathTool pt = new PathTool();
        String cwd = "user.dir";
        storePath = pt.findFolder(new File(System.getProperty(cwd)), "storage");
        scriptLib = pt.findFolder(new File(System.getProperty(cwd)), "pythonScript");
        fxmlPath = pt.findFolder(new File(System.getProperty(cwd)), "fxmlLib");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        PathTool pt = new PathTool();
        if (pt.isCreated()&&new File(App.dataPath+"\\"+App.dataName).length()!=0) {
            stage.setScene(mainScene(fxmlPath+"App.fxml"));
        } else {
            var loader = new FXMLLoader();
            loader.setClassLoader(getClass().getClassLoader());
            loader.setLocation(new File(fxmlPath+"\\Chooser.fxml").toURI().toURL());
            Parent dirChooser = loader.load();
            stage.setScene(new Scene(dirChooser));
            stage.show();
        }
        
    }

    public Scene mainScene(String path2FXML) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new File(path2FXML+"Main.fxml").toURI().toURL());
        Parent root = loader.load();
        return new Scene(root);
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

    public void appendData(String path, String Name, String usage, String... data) {
        String[] content = Arrays.copyOf(data, data.length+1);
        for(int i = content.length-1;i>1;i--) {
            content[i]=content[i-1];
        }
        content[0] = usage;
        File file = createNewFile(path, Name);
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file, true))) {
            CSVWriter writer = new CSVWriter(out);
            writer.writeNext(content);
        } catch (IOException e) {
            System.err.println("An error occured when writing file:" + e);
        }
    }
}

class PathTool {
    public String executeScript(Path from, String scriptName) {
        try {
            ProcessBuilder pb = new ProcessBuilder().command("python", "-u", from.toString() + "\\" + scriptName);
            Process p = pb.start();
            try {
                p.waitFor();    
            } catch (Exception e) {
                System.err.println(e);
            }
            Scanner sc = new Scanner(p.getInputStream());
            StringBuilder buffer = new StringBuilder();

            while (sc.hasNext()) {
                buffer.append(sc.next());
            }
            sc.close();

            return buffer.toString();
        } catch (IOException e) {
            System.err.println(e);
        }
        return "";
    }

    public String executeScript() {
        return executeScript(null, "");
    }

    public List<Path> findPath(Path startFrom, String Name) throws IOException {
        List<Path> path;
        try (Stream<Path> stream = Files.find(startFrom, Integer.MAX_VALUE,
                (p, BasicFileAttributes) -> p.getFileName().toString().equalsIgnoreCase(Name))) {
            path = stream.collect(Collectors.toList());
        }
        return path;
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
        File checkFile = new File(App.storePath.toString());
        if (checkFile.isDirectory()) {
            String[] files = checkFile.list();
            if (files.length > 0) {
                flag = true;
            }
        }
        return flag;
    }
}
