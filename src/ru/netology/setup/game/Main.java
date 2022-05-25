package ru.netology.setup.game;

import java.io.*;

public class Main {
    private static final String ROOT_DIR = "Games";
    private static StringBuilder logBuf = new StringBuilder();

    public static void main(String[] args) {
        createDir("src");
        createDir("res");
        createDir("savegames");
        createDir("temp");
        createDir("src//main");
        createDir("src//test");

        createFile("src//main//Main.java");
        createFile("src//main//Utils.java");

        createDir("res//drawables");
        createDir("res//vectors");
        createDir("res//icons");

        createFile("temp//temp.txt");

        saveLog("temp//temp.txt");
        printLog("temp//temp.txt");
    }

    private static void createDir(String dirName) {
        File dir = new File(ROOT_DIR + "//" + dirName);
        if (dir.mkdir()) {
            logBuf.append("Каталог '" + dir.getName() + "' создан успешно!\n");
        } else {
            logBuf.append("Ошибка создания каталога '" + dir.getName() + "' или каталог уже существует!\n");
        }
    }

    private static void createFile(String fileName) {
        File file = new File(ROOT_DIR + "//" + fileName);
        try {
            if (file.createNewFile()) {
                logBuf.append("Файл '" + file.getName() + "' создан успешно!\n");
            } else {
                logBuf.append("Ошибка создания файла '" + file.getName() + "' или файл уже существует!\n");
            }
        } catch (IOException ex) {
            logBuf.append("Ошибка создания файла '" + file.getName() + "' " + ex.getMessage() + "\n");
        }
    }

    private static void saveLog(String logFileName) {
        try (FileWriter writer = new FileWriter(ROOT_DIR + "//" + logFileName, false)) {
            writer.write(logBuf.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void printLog(String logFileName) {
        if (new File(ROOT_DIR + "//" + logFileName).exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(ROOT_DIR + "//" + logFileName))) {
                String str;
                while ((str = reader.readLine()) != null) {
                    System.out.println(str);
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
