package com.vinsguru.protobuf;

import com.vinsguru.models.Person;

public class DefaultValueDemo {
    public static void main(String[] args) {
        Person build = Person.newBuilder().build();
        System.out.println(

                "city:"+build.getAddress().getCity()
        );
        System.out.println(

                build.hasAddress()
        );
    }
}
