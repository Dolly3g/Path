package com.company;

import java.util.HashMap;
import java.util.List;

class Path {
	String src;
	String dest;

	public Path(String src, String dest) {
		this.src = src;
		this.dest = dest;
	}

	public int hashCode (){
		return this.src.hashCode() + this.dest.hashCode();
	}

	public boolean equals(Path p) {
		if(p == null)
			return false;
		return p.src.equals(src) && p.dest.equals(dest);
	}

//    public java.util.Map<String,String> attachCitiesToCountries(List<String> stations,java.util.Map<String,String> cityCountryMap){
//        java.util.Map<String,String> map = new HashMap<String, String>();
//        for (String station : stations){
//            map.put(station,cityCountryMap.get(station));
//        }
//        return map;
//    }

	public String toString(){
        return src + "->" + dest;
	}
}