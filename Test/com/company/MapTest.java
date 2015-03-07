package com.company;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class MapTest {
	@Test
	public void hasPath_returns_src_and_dest_if_there_is_a_direct_path_between_src_and_dest (){
		Map map = new Map();
		map.setup();
		List<String> stations = map.hasPath("Bangalore","Singapore");
		assertEquals("Bangalore",stations.get(0));
		assertEquals("Singapore",stations.get(1));
	}

	@Test
	public void hasPath_returns_full_indirect_path_if_path_exists_between_src_and_dest (){
		Map map = new Map();
		map.setup();
		List<String> stations = map.hasPath("Bangalore","Tokyo");
		assertEquals("Bangalore",stations.get(0));
		assertEquals("Singapore",stations.get(1));
		assertEquals("Seoul",stations.get(2));
		assertEquals("Beijing",stations.get(3));
		assertEquals("Tokyo",stations.get(4));

	}

	@Test
	public void hasPath_returns_reverse_indirect_path_if_path_exists_between_src_and_dest (){
		Map map = new Map();
		map.setup();
		List<String> stations = map.hasPath("Tokyo","Bangalore");
		assertEquals("Tokyo",stations.get(0));
		assertEquals("Beijing",stations.get(1));
		assertEquals("Seoul",stations.get(2));
		assertEquals("Singapore",stations.get(3));
		assertEquals("Bangalore",stations.get(4));
	}

	@Test
	public void addPath_adds_a_direct_path_from_given_src_to_dest (){
		Map map = new Map();
		map.addPath("Bangalore","Singapore");
		List<String> stations = map.hasPath("Bangalore","Singapore");
	}

	@Test
	public void reversePath_returns_the_reversed_Path(){
		List<String> stations = new LinkedList<String>();
		stations.add("one");
		stations.add("two");
		List<String> reversed = Map.reversePath(stations);
		assertEquals(stations.get(1),reversed.get(0));
		assertEquals(stations.get(0),reversed.get(1));
	}
}
