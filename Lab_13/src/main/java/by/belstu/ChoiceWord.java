package by.belstu;

import java.io.File;
import java.io.FilenameFilter;

public class ChoiceWord {
    public String[] wordList;
    public ChoiceWord(String dir, String wordPrefix) {
        File fileDir = new File(dir);
        System.out.println(fileDir.exists());
        if (fileDir.exists()) {
            wordList = fileDir.list(new OnlyWord(wordPrefix));  // list - возвращает массив строк, содержащий имена файлов и каталогов
        }
    }
    protected static class OnlyWord implements FilenameFilter {
        String wordFile = null;
        public OnlyWord(String wordPrefix) {
            this.wordFile = "." + wordPrefix;
        }

        @Override
        public boolean accept(File dir, String name) {  // accept - проверяет, соответствует ли имя файла заданному имени файла
            return name.endsWith(wordFile);
        }   // endsWith - проверяет, заканчивается ли строка на указанную подстроку
    }
}