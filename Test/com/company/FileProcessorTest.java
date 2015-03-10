package com.company;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by dollyg on 3/7/2015.
 */
public class FileProcessorTest {
    @Test
    public void convertToMap_converts_path_file_to_Map () throws IOException {
        FileProcessor fp = null;
        fp = new FileProcessor("paths.txt");
        Map map = fp.convertPathFileToMap();
        assertEquals("[Singapore->Seoul][Singapore->Dubai][Beijing->Tokyo][Bangalore->Singapore][Seoul->Beijing]",map.toString());
    }

    @Test
    public void FileProcessor_throws_error_if_invalid_file_is_provided () {
        FileProcessor fp = null;
        try{
            fp = new FileProcessor("invalid.txt");
        }
        catch(Exception e){
            assertEquals("resources\\invalid.txt (The system cannot find the file specified)", e.getMessage());
        }
    }

    @Test
    public void mapCitesToCountries_gives_cities_mapped_with_the_countries_they_belong_to () throws IOException {
        FileProcessor fp = null;
        fp = new FileProcessor("cities.txt");
        java.util.Map<String,String> map = fp.getCitiesAndTheirCountries();
        assertEquals("India", map.get("Bangalore"));
        assertEquals("Singapore", map.get("Singapore"));
        assertEquals("UAE", map.get("Dubai"));
        assertEquals("Japan", map.get("Tokyo"));
        assertEquals("China", map.get("Beijing"));
        assertEquals("South Korea", map.get("Seoul"));
    }
}
