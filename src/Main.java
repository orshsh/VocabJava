import java.awt.*;
import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Chooser();
    }

    public static void Chooser() {
        int VocVal = FilePath.SHAPEARR.length;
        System.out.printf("\nКакой словарь открыть? Введите целое число от 1 до %s включительно.\n", VocVal);
        Scanner console = new Scanner(System.in);
        int VocNum = (console.nextInt());
        while (VocNum > VocVal) {
            System.out.println("У нас пока не настолько много словарёв. Повторите ввод:\n");
            VocNum = (console.nextInt());
        }

        try {
            Menu(VocNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Menu(int VNum) throws IOException {
        String z = "запись";
        System.out.printf("\nСЛОВАРЬ № %s!", VNum);
        System.out.printf("\nМЕНЮ\n\n" +
                "1. Показать все записи.\n2. Найти %s.\n3. Изменить %s.\n4. Добавить (снизу) %s.\n" +
                "5. Удалить %s.\n6. Вернуться к выбору словаря.\n", z, z, z, z);
        Scanner console = new Scanner(System.in);
            int Act = (console.nextInt());

            try {


                if (Act == 1) {
                    Printer.AllWords(VNum);
                    Menu(VNum);
                }
                if (Act == 2) {
                    Printer.Finder(VNum);
                    Menu(VNum);
                }
                if (Act == 3) {
                    System.out.println("Какое слово заменить?");
                    String String4Replace = Valid.WordCheck(VNum);
                    if (!String4Replace.isEmpty()) {
                        System.out.println("На что заменить?");
                        String StringNew = Valid.WordCheck(VNum);
                        Changer.Replacer(VNum, String4Replace, Valid.MeaningCheck(StringNew));
                    }
                    Menu(VNum);
                }
                if (Act == 4) {
                    Changer.Adder(VNum);
                    Menu(VNum);
                }
                if (Act == 5) {
                    System.out.println("Какое слово удалить?");
                    String StringDelete = Valid.WordCheck(VNum);
                    Changer.Replacer(VNum, StringDelete, "");
                    Menu(VNum);
                }
                if (Act == 6) {
                    Chooser();
                } else {
                    Menu(VNum);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}