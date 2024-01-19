package com.vinsguru.protobuf;

import com.vinsguru.models.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PersonDemo {
    public static void main(String[] args) throws IOException {
       /* Person jamal = Person.newBuilder().setName("Jamal").setAge(34).build();*/
     Path  path= Paths.get("jamal.ser");
       /* Files.write(path,jamal.toByteArray());*/
        byte[] bytes = Files.readAllBytes(path);
        Person newJamal=Person.parseFrom(bytes);
        System.out.println(
                newJamal

        );
    }
}
