package com.vinsguru.protobuf;

import com.google.protobuf.Int32Value;
import com.vinsguru.models.Address;
import com.vinsguru.models.Car;
import com.vinsguru.models.Person;

import java.util.ArrayList;
import java.util.List;

public class CompositionDemo {
    public static void main(String[] args) {
        Address address=Address.newBuilder()
                .setPostbox(272125)
                .setStreet("Baghnagar")
                .setCity("Khalilalbad")
                .build();
        Car accord=Car
                .newBuilder()
                .setMake("Honda")
                .setModel("Accord")
                .setYear(2019)
                .build();

        Car civic=Car
                .newBuilder()
                .setMake("Honda")
                .setModel("Civic")
                .setYear(2018)
                .build();
        List<Car> cars=new ArrayList<>();
        cars.add(accord);
        cars.add(civic);
        Person moin = Person
                .newBuilder()
                .setName("Moin")
                .setAge(Int32Value.newBuilder().setValue(25).build())
                .addAllCar(cars).build();

        System.out.println(

                moin
        );
    }
}
