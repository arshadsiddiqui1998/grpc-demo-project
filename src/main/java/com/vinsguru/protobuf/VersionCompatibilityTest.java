package com.vinsguru.protobuf;

import com.vinsguru.models.Laptop;
//import com.vinsguru.models.Type;
//import com.vinsguru.models.Type;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VersionCompatibilityTest {
    public static void main(String[] args) throws IOException {

        Path pathV1=Paths.get("tv-V1");
        Path pathV2=Paths.get("tv-V2");

       /*Laptop laptop = Laptop.newBuilder().setBrand("HP").setModel(2016).setType(Type.HP).build();

        Files.write(pathV2,laptop.toByteArray());
*/
       byte[] bytes = Files.readAllBytes(pathV1);

        System.out.println(
                Laptop.parseFrom(bytes)
        );
    }
    }