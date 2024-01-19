package com.vinsguru.protobuf;

import com.vinsguru.models.Credentials;
import com.vinsguru.models.EmailCredentials;
import com.vinsguru.models.PhoneOTP;

public class OneOfDemo {
    public static void main(String[] args) {
        EmailCredentials emailCredentials= EmailCredentials.newBuilder().setEmail("onlyone@gmail.com")
                .setPassword("arshad@1234").build();

        PhoneOTP phoneOTP= PhoneOTP.newBuilder().setNumber(973937533).setCode(91).build();
        Credentials credentials= Credentials.newBuilder()
                .setEmailMode(emailCredentials)
                .setPhoneMode(phoneOTP)
                .build();
        login(credentials);
    }
    private static void login(Credentials credentials){
        switch (credentials.getModeCase()){
            case EMAILMODE:
                System.out.println(credentials.getEmailMode());
                break;
            case PHONEMODE:
                System.out.println(credentials.getPhoneMode());
                break;
        }

    }
}
