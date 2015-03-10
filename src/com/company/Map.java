package com.company;

import org.omg.CORBA.ARG_OUT;
import java.util.*;

class Map {
	Set<Path> paths;

	public Map() {
		paths = new HashSet<Path>();
	}

    public List<String> findPath(String src, String dest) {
        List<String> stations = new LinkedList<String>();
        findPath(src,dest,stations);
        return stations;
    }

    public boolean contains(String src,String dest){
        for(Path p : paths) {
            if(p.equals(new Path(src,dest)) || p.equals(new Path(dest,src))) {
                return true;
            }
        }
        return false;
    }

    public boolean findPath(String src, String dest, List<String> stations) {
        if(stations.contains(src)) {
            return false;
        }
        stations.add(src);
        if(contains(src,dest)){
            stations.add(dest);
            return true;
        }

        for(Path p : paths) {
            if(p.src.equals(src)) {
                if (findPath(p.dest, dest, stations)) {
                    return true;
                }
            }
        }

        for(Path p : paths) {
            if(p.dest.equals(src)) {
                if(findPath(p.src, dest, stations)){
                    return true;
                }
                else {
                    stations.remove(stations.size()-1);
                }
            }
        }
        return false;
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

    public static List<String> reversePath(List<String> stations) {
		List<String> reversed = new LinkedList<String>();
		int size = stations.size();
		for(String station : stations) {
			reversed.add(stations.get(--size));
		}
		return reversed;
	}

	public void setup(){
		this.addPath("Bangalore","Singapore");
		this.addPath("Singapore","Seoul");
		this.addPath("Singapore","Dubai");
		this.addPath("Seoul","Beijing");
		this.addPath("Beijing","Tokyo");
	}

    public String toString(){
        String map = "";
        for(Path p : paths){
            map += p.toString() + "\n";
        }
        return map;
    }

    public String formatPath(List<String> stations, java.util.Map<String,String> cityCountryMap){
        //String path = "";
        String []path = new String[stations.size()];
        int count = 0;
        for (String station : stations){
            //path += station + "[" + cityCountryMap.get(station) + "]" +  "->";
            path[count++] = station + "[" + cityCountryMap.get(station) + "]";
        }
        return String.join("->", path);
    }
}