package com.vinsguru.protobuf;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Int32Value;
import com.google.protobuf.InvalidProtocolBufferException;
import com.vinsguru.models.Person;
import com.vinsguru.protobuf.json.JPerson;

public class PerformanceTest {
    public static void main(String[] args) {

        JPerson jPerson=new JPerson();
        jPerson.setName("Aamir");
        jPerson.setAge(25);
        ObjectMapper objectMapper= new ObjectMapper();
        Runnable jperson=()->{
            try {
                byte[] bytes = objectMapper.writeValueAsBytes(jPerson);
                System.out.println(bytes.length);
                JPerson jPerson1 = objectMapper.readValue(bytes, JPerson.class);

            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        //protobuf

        Person person = Person.newBuilder().setName("Aamir").setAge(Int32Value.newBuilder()

                .setValue(25).build()).build();
        Runnable proto=()->{
            try {
                byte[] byteArray = person.toByteArray();
                System.out.println(byteArray.length);
                Person person1=Person.parseFrom(byteArray);
            } catch (Exception e) {
                e.printStackTrace();
            }

        };
        for (int i = 0; i < 1; i++) {
            runPerformanceTest(jperson,"JSON");
            runPerformanceTest(proto,"PROTO");
        }


    }
    private static void runPerformanceTest(Runnable runnable,String method){

        long time=System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
runnable.run();
        }
        long time2=System.currentTimeMillis();
        System.out.println(
method+":"+(time2-time)+"ms"
        );
    }
}
