package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dollyg on 3/8/2015.
 */
public class ArgsMapperTest {
    @Test
    public void mapArgs_gives_a_Map_of_options_and_src_and_dest_from_arguments_array(){
        String []args = {"-f","paths.txt","Bangalore","Singapore"};
        ArgsMapper mapper = new ArgsMapper(args);
        java.util.Map map = mapper.mapArgs();
        assertEquals("paths.txt",map.get("opt_f"));
        assertEquals("Bangalore",map.get("src"));
        assertEquals("Singapore",map.get("dest"));
    }

    @Test
    public void mapArgs_gives_a_Map_of_src_and_dest_from_arguments_array(){
        String []args = {"Bangalore","Singapore"};
        ArgsMapper mapper = new ArgsMapper(args);
        java.util.Map map = mapper.mapArgs();
        assertEquals("Bangalore",map.get("src"));
        assertEquals("Singapore",map.get("dest"));
    }
}
