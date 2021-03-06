package com.company;

import java.util.*;

public class Paths {
	public static void main(String[] args) {
        if(args.length < 2) return;
        Map map = new Map();
        java.util.Map<String,String> argsMap = new ArgsMapper(args).mapArgs();
        java.util.Map<String,String> cityCountryMap;

        try{
            map = new FileProcessor(argsMap.get("opt_f")).convertPathFileToMap();
            cityCountryMap = new FileProcessor(argsMap.get("opt_c")).getCitiesAndTheirCountries();
        }
        catch(Exception e){
            System.out.println("Exception Occurred: "+e);
            return;
        }

        if(!map.isCityPresent(argsMap.get("src"))) {
            System.out.println("No city named " + argsMap.get("src") + " in database");
            return;
        }

        if(!map.isCityPresent(argsMap.get("dest"))) {
            System.out.println("No city named " + argsMap.get("dest") + " in database");
            return;
        }

        List<List<String>> allPaths = map.findPath(argsMap.get("src"), argsMap.get("dest"));
        if(allPaths.size() == 0){
            System.out.println("No Path Found between " + argsMap.get("src") + " and " + argsMap.get("dest")) ;
            return;
        }
        System.out.println(map.formatAllPaths(allPaths, cityCountryMap));

	}
}
