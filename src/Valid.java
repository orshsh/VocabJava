import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class Valid {
    public static String WordCheck(int VNum) {
        System.out.printf("\nВведите слово в формате — %s:\n", FilePath.RUSHAPEARR[VNum - 1]);
        Scanner console = new Scanner(System.in);
        String Key = console.nextLine();
        if (Pattern.matches(FilePath.SHAPEARR[VNum - 1], Key)) {
 //           Key=Valid.MeaningCheck(Key);
            return Key;
        }
        else {
            System.out.println("\nОшибочный формат.\n");
            return "";}
    }

    public static String MeaningCheck(String Key) {
        System.out.printf("Введите значение слова в формате — %s:\n", FilePath.RUMEANING);
        Scanner console = new Scanner(System.in);
        String Meaning = console.nextLine();
        if (Pattern.matches(FilePath.MEANINGSHAPE, Meaning)) {
            return Key+"-"+Meaning;
        }
        else {
            System.out.println("\nОшибочный формат.\n");
            return "";}
    }


}

