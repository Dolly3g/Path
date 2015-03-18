package com.company;

import org.omg.CORBA.ARG_OUT;
import java.util.*;

class Map {
	Set<Path> paths;
    List<List<String>> allPathsFound;

	public Map() {
        paths = new HashSet<Path>();
        allPathsFound = new LinkedList<List<String>>();
	}

    private void fill(){
        int count = 0;
        List<String> path1= allPathsFound.get(0);
        for(List<String> path : allPathsFound) {
            if(allPathsFound.get(0) == path) {
                continue;
            }
            String src = path.get(0);
            for(String city : path1){
                if(city!= src)
                    path.add(count++,city);
                else
                    break;
            }
        }
    }

    public List<List<String>> findPath(String src, String dest) {
        List<String> stations = new LinkedList<String>();
        stations = findPath(src, dest, stations);
        if(allPathsFound.size() != 0)
            fill();
        return allPathsFound;
    }

    public boolean contains(String src,String dest){
        for(Path p : paths) {
            if(p.equals(new Path(src,dest)) || p.equals(new Path(dest,src))) {
                return true;
            }
        }
        return false;
    }

    public List<String> findPath(String src, String dest, List<String> stations) {
        List<String> visitedCities = new LinkedList<String>();
        if(stations.contains(src)) {
            return null;
        }
        stations.add(src);
        if(contains(src,dest)){
            stations.add(dest);
            allPathsFound.add(new LinkedList<String>(stations));
            return stations;
        }

        int size = allPathsFound.size();

        for(Path p : paths) {
            if(p.src.equals(src) && visitedCities.indexOf(p.dest) == -1) {
                if(stations.size() == 0){
                    stations.add(src);
                }
                visitedCities.add(p.dest);
                if (findPath(p.dest, dest, stations) !=null) {
                    if(allPathsFound.size() == size+1){
                        stations.clear();
                    }
                    else{
                        return stations;
                    }
                }
            }
        }

        if(allPathsFound.size() == size+1){
            return stations;
        }
        for(Path p : paths) {
            if(p.dest.equals(src) && visitedCities.indexOf(p.src) == -1) {
               if(stations.size() == 0){
                    stations.add(src);
                }
                visitedCities.add(p.src);
                if(findPath(p.src, dest, stations) != null){
                    if(allPathsFound.size() == size+1){
                        stations.clear();
                    }
                    else{
                        return stations;
                    }
                }
            }
        }
        return null;
    }

    private boolean isCityASource(String city) {
		int count=0;
		int size=paths.size();
		for(Path p : paths) {
			if(p.src.equals(city)){
				return true;
			}
			count++;
		}
		return false;
	}

	public boolean isCityPresent(String city) {
		for(Path p : paths) {
			if(p.src.equals(city) || p.dest.equals(city) )
				return true;
		}
		return false;
	}

	public void addPath(String src, String dest) {
		paths.add(new Path(src,dest));
		return;
	}

	public void setup(){
		this.addPath("Bangalore","Singapore");
		this.addPath("Singapore","Seoul");
		this.addPath("Singapore","Dubai");
        this.addPath("Dubai","Seoul");
		this.addPath("Seoul","Beijing");
		this.addPath("Beijing","Tokyo");
        this.addPath("Chennai","Rajasthan");
	}

    public String toString(){
        String map = "";
        for(Path p : paths){
            map += p.toString() + "\n";
        }
        return map;
    }

    public String formatPath(List<String> stations, java.util.Map<String,String> cityCountryMap){
        String []path = new String[stations.size()];
        int count = 0;
        for (String station : stations){
            path[count++] = station + "[" + cityCountryMap.get(station) + "]";
        }
        return String.join("->", path);
    }
}