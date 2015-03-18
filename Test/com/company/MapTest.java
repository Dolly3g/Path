package com.company;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class MapTest {
	@Test
	public void findPath_returns_src_and_dest_if_there_is_a_direct_path_between_src_and_dest (){
		Map map = new Map();
		map.setup();
		List<List<String>> allPaths = map.findPath("Bangalore","Singapore");
        List<String> path1 = allPaths.get(0);
		assertEquals("Bangalore",path1.get(0));
		assertEquals("Singapore",path1.get(1));
	}

    @Test
    public void findPath_returns_path_for_Singapore_to_Bangalore_if_path_from_Bangalore_toSingapore_exists (){
        Map map = new Map();
        map.setup();
        List<List<String>> allPaths = map.findPath("Singapore","Bangalore");
        List<String> path1 = allPaths.get(0);
        assertEquals("Singapore",path1.get(0));
        assertEquals("Bangalore",path1.get(1));
    }

    @Test
    public void findPath_returns_full_indirect_path_if_path_exists_between_src_and_dest (){
        Map map = new Map();
        map.setup();
        List<List<String>> allPaths = map.findPath("Bangalore","Tokyo");
        List<String> path1 = allPaths.get(0);
        List<String> path2 = allPaths.get(1);
        assertEquals("Bangalore",path1.get(0));
        assertEquals("Singapore",path1.get(1));
        assertEquals("Seoul",path1.get(2));
        assertEquals("Beijing",path1.get(3));
        assertEquals("Tokyo",path1.get(4));

        assertEquals("Bangalore",path2.get(0));
        assertEquals("Singapore",path2.get(1));
        assertEquals("Dubai",path2.get(2));
        assertEquals("Seoul",path2.get(3));
        assertEquals("Beijing",path2.get(4));
        assertEquals("Tokyo",path2.get(5));
    }
    @Test
    public void findPath_returns_reverse_indirect_path_if_path_exists_between_src_and_dest (){
        Map map = new Map();
        map.setup();
        List<List<String>> allPaths = map.findPath("Tokyo","Bangalore");
        List<String> path1 = allPaths.get(0);
        List<String> path2 = allPaths.get(1);

        assertEquals("Tokyo",path1.get(0));
        assertEquals("Beijing",path1.get(1));
        assertEquals("Seoul",path1.get(2));
        assertEquals("Singapore",path1.get(3));
        assertEquals("Bangalore",path1.get(4));

        assertEquals("Tokyo",path2.get(0));
        assertEquals("Beijing",path2.get(1));
        assertEquals("Seoul",path2.get(2));
        assertEquals("Dubai",path2.get(3));
        assertEquals("Singapore",path2.get(4));
        assertEquals("Bangalore",path2.get(5));
    }

    @Test
    public void addPath_adds_a_direct_path_from_given_src_to_dest (){
        Map map = new Map();
        map.addPath("Bangalore","Singapore");
        List<List<String>> allPaths = map.findPath("Bangalore","Singapore");
        List<String> path1 = allPaths.get(0);
        assertEquals("Bangalore",path1.get(0));
        assertEquals("Singapore",path1.get(1));
    }

    @Test
    public void findPath_returns_all_paths_from_Bangalore_to_Dubai (){
        Map map = new Map();

        map.addPath("Bangalore","Singapore");
        map.addPath("Singapore","Dubai");
        map.addPath("Bangalore","Tokyo");
        map.addPath("Tokyo","Dubai");
        List<List<String>> allPaths = map.findPath("Bangalore", "Dubai");
        List<String> path1 = allPaths.get(0);
        List<String> path2 = allPaths.get(1);
        assertEquals("Bangalore", path1.get(0));
        assertEquals("Tokyo", path1.get(1));
        assertEquals("Dubai",path1.get(2));

        assertEquals("Bangalore", path2.get(0));
        assertEquals("Singapore",path2.get(1));
        assertEquals("Dubai",path2.get(2));
    }

    @Test
    public void findPath_returns_path_for_Tokyo_to_Dubai (){
        Map map = new Map();
        map.setup();
        List<List<String>> allPaths = map.findPath("Tokyo", "Dubai");
        List<String> path1 = allPaths.get(0);
        assertEquals("Tokyo",path1.get(0));
        assertEquals("Beijing", path1.get(1));
        assertEquals("Seoul",path1.get(2));
        assertEquals("Dubai", path1.get(3));
    }

    @Test
    public void findPath_returns_null_for_if_path_does_not_exist (){
        Map map = new Map();
        map.setup();
        List<List<String>> allPaths = map.findPath("Beijing", "Chennai");
        assertEquals(0,allPaths.size());

    }

	@Test
	public void isCityPresent_returns_false_for_Chennai (){
		Map map = new Map();
		map.setup();
		assertEquals(false,map.isCityPresent("Delhi"));
	}

	@Test
	public void isCityPresent_returns_true_for_Tokyo (){
		Map map = new Map();
		map.setup();
		assertEquals(true,map.isCityPresent("Tokyo"));
	}
}
