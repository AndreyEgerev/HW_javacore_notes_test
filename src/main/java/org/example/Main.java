package org.example;

import DAO.FileNotesAccess;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

//        for (String message: args
//             ) {
//            try {
//                FileNotesAccess.writeNote(message);
//                System.out.println("write OK");
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
        try {
            FileNotesAccess.writeNote(args);
            System.out.println("write OK");
        } catch (IOException e) {
            System.out.println("write error" + e.getMessage());
        }
    }
}