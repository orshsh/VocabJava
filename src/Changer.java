import java.io.*;
import java.util.*;
import java.io.*;



public class Changer {

    public static void Adder(int VNum) throws IOException {
        String Key = (Valid.WordCheck(VNum));
        if (!Key.isEmpty()) {
            String Note = Valid.MeaningCheck(Key);

            if (!Note.isEmpty()) {
                try {
                    FileWriter writer = new FileWriter(FilePath.FILEPATH + VNum + ".txt", true);
                    BufferedWriter bufferWriter = new BufferedWriter(writer);

                    bufferWriter.write("\n" + Note);
                    bufferWriter.close();
                    System.out.println("\nДобавлено.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void Replacer(int VNum, String OldKey, String NewNote) throws IOException {
//            String Note=Valid.WordCheck(VNum);
//            if (!Note.isEmpty()) {

        String OldFile = FilePath.FILEPATH + VNum + ".txt"; // имя исходного файла
        String TempFile = FilePath.FILEPATH + 0 + ".txt"; // путь к временному файлу

        try {
            File Voc = new File(OldFile);
            File Temp = new File(TempFile);

            int count=0;
            int enter=0;

            BufferedReader reader = new BufferedReader(new FileReader(Voc));
            BufferedWriter writer = new BufferedWriter(new FileWriter(Temp));

            String line;
            while ((line = reader.readLine()) != null) {
              if (enter!=0){writer.newLine();}
                if (line.contains(OldKey)) {

                    if (NewNote.isEmpty())
                    {count++;
                    enter=0;}
                    else {
                        writer.write(NewNote);
                        count++;
                        enter++;
                    }
                    }

                else {
                        writer.write(line);
                    enter++;
                }
            }


                writer.close();
                reader.close();

                Voc.delete(); // Удаляем исходный файл
                Temp.renameTo(Voc); // Переименовываем временный файл в исходное имя файла

            if (count==0) {
                System.out.println("В словаре не найдено ключа "+ OldKey+ ".");
            }
            else{System.out.println("Строка успешно удалена/изменена.");}
        }
            catch(FileNotFoundException e){
                e.printStackTrace();
            } catch(IOException e){
                e.printStackTrace();
            }

    }
}
