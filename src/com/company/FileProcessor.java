package com.company;
import javafx.print.PageLayout;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Created by dollyg on 3/7/2015.
 */
public class FileProcessor {
    String filename;
    String content;

    public FileProcessor(String filename) throws IOException {
        this.filename = "resources/" + filename;
        File_Reader fileReader = new File_Reader(this.filename);
        content = fileReader.readFile();
    }

    public Map convertPathFileToMap(){
        Map map = new Map();
        String []lines = content.split("\r\n");
        for (String line : lines) {
            String[] src_dest = line.split("-");
            Path path = new Path(src_dest[0], src_dest[1]);
            map.paths.add(path);
        }
        return map;
    }

    public java.util.Map getCitiesAndTheirCountries(){
        java.util.Map<String,String> map = new HashMap<String,String>();
        String []lines = content.split("\r\n");
        for (String line : lines) {
            String[] city_country = line.split(",");
            map.put(city_country[0], city_country[1]);
        }
        return map;
    }
}
