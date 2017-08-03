package com.xuanruiwei.william;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by xuanruiwei on 2017/8/1.
 */
public class Main {
    private static List<City> cityList;
    private static int cityDistance;
    private static int n,q,c,u,v,k = 0;
    private static List<Integer> resultPath;
    public static void main(String args[]){

        cityList = new ArrayList<City>();
        Scanner mScanner = new Scanner(System.in);
        n = mScanner.nextInt();
        //System.out.println(n);
        q = mScanner.nextInt();
        //System.out.println(q);
        City mCity;
        for (int i = 0 ;i < n;i ++) {
            c = mScanner.nextInt();
            mCity = new City(i+1,c);
            cityList.add(mCity);
            //System.out.println(c+","+i);
        }
        for (int i = 0;i < n-1;i ++){
            u = mScanner.nextInt();
            v = mScanner.nextInt();
            cityList.get(u-1).addCityConnected(v-1);
            cityList.get(v-1).addCityConnected(u-1);
            //System.out.println(cityList.get(u-1).getCitysConnect().toString());
        }
        //System.out.println("---------------------");
        for (int i = 0;i < n;i ++)
            //System.out.println(cityList.get(i).getCitysConnect().toString());

        resultPath = new ArrayList<Integer>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        for (int i = 0 ; i < q; i ++)
        {
            resultPath.clear();
            cityDistance = Integer.MAX_VALUE;
            k = 0;

            u = mScanner.nextInt();
            v = mScanner.nextInt();
            c = mScanner.nextInt();

            findPath(u-1,v-1,path);
            resultPath.add(v-1);

            u = resultPath.size();

            ////System.out.println("+++++++++++++++++++");
            for (int j = 0;j < u;j ++){
                ////System.out.println(resultPath.get(j));
                v = cityList.get(resultPath.get(j)).getValue();
                if (v > c){
                    c = v;
                    k ++;
                }
            }
            System.out.println(k);
        }
        mScanner.close();
    }
    public static void findPath(int u,int v,ArrayList<Integer> path){
        //System.out.println("---------------------");
        //System.out.println(path.toString());
        //System.out.println(u);
        path.add(u);
        int n = cityList.get(u).getCitysConnect().size();
        int m ;
        for (int i = 0;i < n;i ++) {
            m = cityList.get(u).getCitysConnect().get(i);
            //System.out.println(m);
            if (path.contains(m))
                continue;
            if (m == v) {
                if (path.size() < cityDistance) {
                    cityDistance = path.size();
                    resultPath.clear();
                    for (Integer index : path)
                        resultPath.add(index);
                }
                continue;
            }
            findPath(m, v, path);
        }
        path.remove(path.size() - 1);
    }
}
