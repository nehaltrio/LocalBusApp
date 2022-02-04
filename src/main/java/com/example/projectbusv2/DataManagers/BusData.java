package com.example.projectbusv2.DataManagers;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Map;

public class BusData {
    private ArrayList<String> bus;

    private String origin;
    private String dest;
    private double distance;
    private double fare;


    public String getDistance(String orig, String des) {
        String country = ",Dhaka,Bangladesh";
        String address = orig + country;
        String address2 = des + country;

        Map<String, Double> coords = OpenStreetMapUtils.getInstance().getCoordinates(address);
        Map<String, Double> coord2 = OpenStreetMapUtils.getInstance().getCoordinates(address2);

        if (coords.get("lat") == null || coord2.get("lat") == null){
            distance = 0;
            return "0.00";
        }else {

            double lat1 = coords.get("lat");
            double lon1 = coords.get("lon");

            double lat2 = coord2.get("lat");
            double lon2 = coord2.get("lon");

            GetCoordinates cord = new GetCoordinates();

            distance = cord.DistanceTo(lat1, lon1, lat2, lon2, "K");

            String disStr = String.format("%.2f", distance);

            return disStr;
        }
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getFare(double dist) {
        fare = dist * 2.15;
        if (dist==0){
            return "0.00";
        }
        else if (fare<10){
            return "10.00";
        }

        String fareStr = String.format("%.2f", fare);

        return fareStr;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }


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
