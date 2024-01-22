import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;
import java.util.Scanner;

public class Printer {
    public static void AllWords(int VNum) throws IOException {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(FilePath.FILEPATH+VNum+".txt"));
             Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNext()) {
                String line = scanner.next();
                String[] words = line.split("-");
                System.out.println(words[0] + " — " + words[1] + ".");

            }
            System.out.println();
        }

    }

    public static void Finder(int VNum) throws IOException {
        System.out.println("Введите слово/часть слова, которое нужно найти:");
        Scanner console = new Scanner(System.in);
        String Key = console.nextLine();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(FilePath.FILEPATH+VNum+".txt"));
             Scanner scanner = new Scanner(fileReader)) {
            int fcount = 0;
            while (scanner.hasNext()) {
                String line = scanner.next();
                if(line.contains(Key)){
                    fcount++;
                    String[] words = line.split("-");
                    System.out.printf("Вхождение %s: %s — %s.\n", fcount, words[0], words[1]);
                }
            }
            if (fcount==0) System.out.println("Не найдено.");
            System.out.println();
        }

    }

}
