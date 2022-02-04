package com.example.projectbusv2.DataManagers;

public class GetCoordinates {
    public  double DistanceTo(double lat1, double lon1, double lat2, double lon2, String unit) {
        double rlat1 = Math.PI * lat1 / 180.0f;
        double rlat2 = Math.PI * lat2 / 180.0f;
        double rlon1 = Math.PI * lon1 / 180.0f;
        double rlon2 = Math.PI * lon2 / 180.0f;

        double theta = lon1 - lon2;
        double rtheta = Math.PI * theta / 180.0f;

        double dist = Math.sin(rlat1) * Math.sin(rlat2) + Math.cos(rlat1) * Math.cos(rlat2) * Math.cos(rtheta);
        dist = Math.acos(dist);
        dist = dist * 180.0f / Math.PI;
        dist = dist * 60.0f * 1.1515f;

        if (unit == "K") {
            dist = dist * 1.609344f;
        }
        if (unit == "M") {
            dist = dist * 1.609344 * 1000f;
        }
        if (unit == "N") {
            dist = dist * 0.8684f;
        }
        return dist;
    }
}
