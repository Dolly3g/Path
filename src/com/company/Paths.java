package com.company;

import java.util.*;

class Paths {
	public static void main(String[] args) {
		if(args.length < 2)
			return;
		Map map = new Map();
		map.setup();

		if(!map.isCityPresent(args[0])) {
			System.out.println("No city named " + args[0] + " in database");
			return;
		}

		if(!map.isCityPresent(args[1])) {
			System.out.println("No city named " + args[1] + " in database");
			return;
		}

		List<String> stations = map.hasPath(args[0],args[1]);
		System.out.println(stations);
	}
}