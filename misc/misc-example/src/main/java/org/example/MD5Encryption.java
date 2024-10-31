package org.example;

import java.security.MessageDigest;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;

public class MD5Encryption {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Function<String, String> myFun = encrypt
                .andThen(toEncryptedString);
        while(scanner.hasNext()){
            String input = scanner.next();

            System.out.println(myFun.apply(input));
        }

    }

    public static Function<String, Optional<byte[]>> encrypt = (s) -> {
        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            return Optional.of(md5.digest(s.getBytes()));
        }catch(Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    };

    public static Function<Optional<byte[]>, String> toEncryptedString = (input) -> {
        return input.map(inputS -> {
            StringBuilder sb = new StringBuilder();
            for(byte b : inputS){
               String s = Integer.toHexString(0xff & b) ;
               if(s.length() == 1)
                   sb.append('0');
               sb.append(s);
            }
            return sb.toString();
        }).orElseGet(() -> "");
    };

}
