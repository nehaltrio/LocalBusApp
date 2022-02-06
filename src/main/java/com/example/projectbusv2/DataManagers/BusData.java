package com.example.projectbusv2.DataManagers;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Map;

public class BusData {
    private ArrayList<String> bus;

    private String origin;
    private String dest;


    public ArrayList<String> getBus() {
        dataFetch data = new dataFetch();
        bus = data.getCellData(getOrigin(), getDest());

        if (bus.isEmpty()){
            bus.add("NO BUSES");
        }

        return bus;
    }

    public void setBus(ArrayList<String> bus) {
        this.bus = bus;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }


}
