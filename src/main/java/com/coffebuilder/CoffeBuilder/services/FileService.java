package com.coffebuilder.CoffeBuilder.services;
import com.coffebuilder.CoffeBuilder.entities.Coffee;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {
    private final File defaultPath = new File("");
    private final String path = defaultPath.getAbsolutePath() + "/src/main/resources/data/CoffeeSave.csv";

    public FileService() {}

    public String getPath() {
        return path;
    }

    public void writeFile(String content) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(content);
        } catch (IOException err) {
            throw new IOException(err);
        }
    }

    public Coffee getCoffeeContent() {
        return new Coffee("Lunar",new ArrayList<>(),1.0);
    }

    public List<Coffee> readFile() throws IOException {
        List<Coffee> coffeeList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String lineContent = reader.readLine();
            while(lineContent != null) {
                String[] splitedLine = lineContent.split(",");
                coffeeList.add(ConvertCoffeeService.createCoffee(splitedLine));
                lineContent =  reader.readLine();
            }
            coffeeList.forEach(System.out::println);
            return coffeeList;
        } catch (IOException err) {
            throw new IOException(err);
        }
    }
}
