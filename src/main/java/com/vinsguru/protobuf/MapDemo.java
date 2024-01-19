package com.vinsguru.protobuf;

import com.vinsguru.models.BodyStyle;
import com.vinsguru.models.Car;
import com.vinsguru.models.Dealer;

public class MapDemo {
    public static void main(String[] args) {
        Car accord=Car
                .newBuilder()
                .setMake("Honda")
                .setModel("Accord")
                .setBodyStyle(BodyStyle.SEDAN)
                .setYear(2019)
                .build();

        Car civic=Car
                .newBuilder()
                .setMake("Honda")
                .setModel("Civic")
                .setBodyStyle(BodyStyle.AUDI)
                .setYear(2018)
                .build();
        Dealer dealer = Dealer.newBuilder().putModel(2019, civic).putModel(2018, accord).build();
        System.out.println(
dealer.getModelOrThrow(2019).getBodyStyle());
    }
}
