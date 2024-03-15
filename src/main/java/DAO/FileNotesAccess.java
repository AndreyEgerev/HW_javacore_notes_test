package DAO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileNotesAccess {
    private static String path;

    public static boolean writeNote(String message) throws IOException {
        boolean statusWriteMessage = false;
        String datePattern = "dd.MM.yyyy HH:mm:ss";
        SimpleDateFormat date = new SimpleDateFormat(datePattern);
        String currentDate = date.format(new Date());
        path = System.getProperty("user.dir")+"\\source\\notes.txt";
        File dataFile = new File(path);
        if (!dataFile.exists()){
            try {
                dataFile.createNewFile();
            } catch (IOException e) {
                throw new IOException("Невозможно создать файл " + path);
            }
        }
        try (FileWriter dataFileWrite = new FileWriter(path,true);){
            dataFileWrite.write(new StringBuilder().append(currentDate).append(" ")
                    .append(message).append('\n').toString());
            System.out.println(currentDate+ " " + message);
            statusWriteMessage = true;
        } catch (IOException e) {
            throw new IOException("Невозможно записать данные в файл " + path);
        }
        return statusWriteMessage;
    }

    public static boolean writeNote(String[] msg) throws IOException {
        boolean statusWriteMessage = false;
        String datePattern = "dd.MM.yyyy HH:mm:ss";
        SimpleDateFormat date = new SimpleDateFormat(datePattern);
        String currentDate = date.format(new Date());
        path = System.getProperty("user.dir")+"\\source\\notes.txt";
        File dataFile = new File(path);
        if (!dataFile.exists()){
            try {
                dataFile.createNewFile();
            } catch (IOException e) {
                throw new IOException("Невозможно создать файл " + path);
            }
        }
        try (FileWriter dataFileWrite = new FileWriter(path,true);){
            for (String message:
                 msg) {
                dataFileWrite.write(new StringBuilder().append(currentDate).append(" ")
                        .append(message).append('\n').toString());
                System.out.println(currentDate+ " " + message);
            }
            statusWriteMessage = true;
        } catch (IOException e) {
            throw new IOException("Невозможно записать данные в файл " + path);
        }
        return statusWriteMessage;
    }
}
