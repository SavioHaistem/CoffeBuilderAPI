package com.coffebuilder.CoffeBuilder.services;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private String path;

    public FileService() {}
    public FileService(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void writeFile(String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(content);
        } catch (IOException err) {
            throw new IOException(err);
        }
    }

    public List<String> readFile() throws IOException {
        List<String> fileContent = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String lineContent = reader.readLine();
            while(lineContent != null) {
                fileContent.add(lineContent);
                lineContent =  reader.readLine();
            }
            return fileContent;
        } catch (IOException err) {
            throw new IOException(err);
        }
    }

    public String getFileStringCotent() throws IOException {
        return this.readFile().toString();
    }
}
