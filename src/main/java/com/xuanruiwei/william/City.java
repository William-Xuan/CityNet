package com.xuanruiwei.william;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanruiwei on 2017/8/1.
 */
public class City {
    int id;
    int value = 0;
    List<Integer> citysConnect;

    public City(int id, int value) {
        this.id = id;
        this.value = value;
        citysConnect = new ArrayList<Integer>();
    }

    public void addCityConnected(int cityID) {
        if (!citysConnect.contains(cityID))
            citysConnect.add(cityID);
    }

    public List<Integer> getCitysConnect() {
        return citysConnect;
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }
}
