package com.company;

import static org.junit.Assert.*;
import org.junit.Test;


public class PathTest {
	@Test
	public void equals_returns_true_if_src_and_dest_of_two_paths_are_same (){
		Path p1 = new Path("Bangalore","Singapore");
		Path p2 = new Path("Bangalore","Singapore");
		assertEquals(true,p1.equals(p2));
	}

	@Test
	public void equals_returns_false_if_src_and_dest_of_two_paths_are_different (){
		Path p1 = new Path("Bangalore","Singapore");
		Path p2 = new Path("Bangalore","Tokyo");
		assertEquals(false,p1.equals(p2));
	}

	@Test
	public void equals_returns_false_if_given_path_is_null (){
		Path p1 = new Path("Bangalore","Singapore");
		assertEquals(false,p1.equals(null));
	}
}