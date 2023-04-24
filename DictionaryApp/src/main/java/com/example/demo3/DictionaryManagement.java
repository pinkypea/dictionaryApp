package com.example.demo3;

import java.io.*;
import java.util.*;

public class DictionaryManagement {
    private Dictionary dic = new Dictionary();

    public DictionaryManagement(Dictionary d) {
        dic = d;
    }

    public void insertFromFile() throws IOException, FileNotFoundException {
        try {
            FileInputStream input = new FileInputStream("dictionaries.txt");
            Scanner sc = new Scanner(input);
            ArrayList<Word> word = new ArrayList<>();
            dic.setDictionaryList(word);
            while(sc.hasNextLine()) {
                String s = sc.nextLine();
                String[] a = s.split("\\t");
                dic.insertWord(a[0], a[1]);
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Syntax error!");
        }
    }

    public void deleteInFile() throws IOException {
        File file = new File("dictionaries.txt");
        file.delete();
        File newFile = new File("dictionaries.txt");
        newFile.createNewFile();
    }

    public void dictionaryExportToFile() throws IOException {
        File file = new File("dictionaries.txt");
        FileWriter writer = new FileWriter(file, true);
        BufferedWriter buffer = new BufferedWriter(writer);
        PrintWriter print = new PrintWriter(buffer);
        ArrayList<Word> a = dic.getDictionaryList();
        for (int i = 0; i < a.size(); i++) {
            String Eng = a.get(i).getWord_target();
            String Viet = a.get(i).getWord_explain();
            print.println(Eng + "\t" + Viet);
        }
        print.close();
    }

}
