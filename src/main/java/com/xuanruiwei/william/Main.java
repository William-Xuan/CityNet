package com.xuanruiwei.william;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by xuanruiwei on 2017/8/1.
 */
public class Main {

    List<City> cityList = new ArrayList<City>();
    int n,q,c,u,v,src,dest;

    public void main(String args[]){
        Scanner mScanner = new Scanner(System.in);
        n = mScanner.nextInt();
        q = mScanner.nextInt();
        City mCity;
        for (int i = 0 ;i < n;i ++) {
            c = mScanner.nextInt();
            mCity = new City(i+1,c);
            cityList.add(mCity);
        }
        for (int i = 0;i < n-1;i ++){
            u = mScanner.nextInt();
            v = mScanner.nextInt();
            cityList.get(u-1).addCityConnected(v);
        }
        /*for (int i = 0 ; i < q; i ++)
        {

        }*/
        ArrayList<Integer> path = new ArrayList<Integer>();
        findPath(4,2,path);
    }
    public void findPath(int u,int v,ArrayList<Integer> path){
        int n = cityList.get(u-1).getCitysConnect().size();
        for (int i = 0;i < n;i ++)
        {
            
        }
    }
}
