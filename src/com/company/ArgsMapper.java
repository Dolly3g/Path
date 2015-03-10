package com.company;

import java.util.HashMap;

/**
 * Created by dollyg on 3/8/2015.
 */
public class ArgsMapper {
    String []args;
    public ArgsMapper(String[] args){
        this.args = args;
    }


    public java.util.Map mapArgs(){
        java.util.Map argsMap = new HashMap();
        int fIndex = indexOf(args, "-f");
        int cIndex = indexOf(args, "-c");
        String pathFilename = fIndex >= 0 ? args[fIndex+1] : "defaultPaths.txt";
        String cityFilename = cIndex >= 0 ? args[cIndex+1] : "defaultCities.txt";
        argsMap.put("opt_f",pathFilename);
        argsMap.put("opt_c",cityFilename);
        argsMap.put("src",args[args.length-2]);
        argsMap.put("dest",args[args.length-1]);
        return argsMap;
    }

    private int indexOf(String[] array, String ele) {
        for(int i=0 ; i<array.length ; i++){
            if(array[i].equals(ele)){
                return i;
            }
        }
        return -1;
    }
}
