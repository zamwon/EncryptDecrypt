package encryptdecrypt;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static String input;
    private static int modulator;
    private static String  xFile = "";



    public static void encrypt() {

        char[] arr = input.toCharArray();
        for (char inputChar : arr) {
            if (inputChar > 31 && inputChar < 127) {
                char encryptedChar = (char) (inputChar + modulator);
                if (encryptedChar > 127) {
                    encryptedChar = (char) (encryptedChar - 92);
                }
                xFile += encryptedChar;

            }
        }
    }

    public static void decrypt() {

        char[] arr = input.toCharArray();
        for (char inputChar : arr) {
            if (inputChar > 31 && inputChar < 127) {
                char decryptedChar = (char) (inputChar - modulator);
                if (decryptedChar < 32) {
                    decryptedChar = (char) (decryptedChar + 92);
                }
                xFile += decryptedChar;

            }
        }
    }


    public static void main(String[] args) {
        HashMap<String, String> mapa = new HashMap<>();
        for (int i = 0; i < args.length; i += 2) {
            mapa.put(args[i], args[i + 1]);
        }
        String exampleIn;
        String exampleOut;


        // KEY
        modulator = Integer.parseInt(mapa.getOrDefault("-key", "0"));
        // INPUT OR DATA
        // oba puste

        if (mapa.get("-data") == null && mapa.get("-in") == null) {
            input = "";
            // oba nie puste
        } else if ((mapa.get("-data") != null) && (mapa.get("-in") != null)) {
            input = mapa.get("-data");
            // data puste, in nie puste
        } else if (mapa.get("-data") == null && mapa.get("-in") != null) {
            exampleIn = mapa.get("-in");
            File file = new File(exampleIn);

            try {
                Scanner scanner = new Scanner(file);
                input = scanner.nextLine();
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error 1");
            }
            // in puste, data nie puste
        } else if (mapa.get("-in") == null && mapa.get("-data") != null) {
            input = mapa.get("-data");
        }

        // MODE ENC/DEC

        if (mapa.getOrDefault("-mode", "enc").equals("enc")) {
            encrypt();
        } else {
            decrypt();
        }

        // OUT OR PRINT
        exampleOut = mapa.get("-out");
        if (exampleOut == null) {
            System.out.println(xFile);
        } else {
            try {
                File fileOut = new File(exampleOut);
                FileWriter writer = new FileWriter(fileOut);
                writer.append(xFile);
                writer.close();
            } catch (Exception e) {
                System.out.println("Error 2");
            }


        }
    }
}
