package com.company;

import java.util.*;

class Map {
	Set<Path> paths;

	public Map() {
		paths = new HashSet<Path>();
	}

    public List<String> hasPath(String src, String dest) {
        boolean hasPath;
        List<String> stations = new LinkedList<String>();

        hasPath = findPath(src,dest,stations);
        return stations;
    }

    public boolean findPath(String src, String dest, List<String> stations) {
        if(stations.contains(src))
            return false;

        stations.add(src);

        for(Path p : paths) {
            if(p.equals(new Path(src,dest)) || p.equals(new Path(dest,src))) {
                stations.add(dest);
                return true;
            }
        }

        for(Path p : paths) {
            if(p.src.equals(src)) {
                boolean hasPath = this.findPath(p.dest, dest, stations);
                if (hasPath) {
                    return true;
                }

            }
        }

        for(Path p : paths) {
            if(p.dest.equals(src)) {
                boolean hasPath = this.findPath(p.src,dest,stations);
                if(hasPath){
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
}