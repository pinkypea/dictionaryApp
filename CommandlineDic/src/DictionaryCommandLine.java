import java.util.*;
import java.io.*;

public class DictionaryCommandLine {
    private ArrayList<Word> listWord;
    private Dictionary dic;
    private DictionaryManagement dicManagement;

    public DictionaryCommandLine(Dictionary dictionary) {
        this.dic = dictionary;
        dicManagement = new DictionaryManagement(dictionary);
    }

    public DictionaryCommandLine(Dictionary dic, DictionaryManagement dicManagement) {
        this.dic = dic;
        this.dicManagement = dicManagement;
    }

    /**
     * show all word.
     */
    public void showAllWords() {
        listWord = new ArrayList<Word>(dic.getDictionaryList());
        if(!listWord.isEmpty()) {
            int n = 1;
            System.out.printf("%-5s|%-15s|%s%n%n", "No", "English", "Vietnamese");
            for (int i = 0; i < listWord.size(); i++) {
                System.out.printf("%-6d%-16s%s%n", n, listWord.get(i).getWord_target(), listWord.get(i).getWord_explain());
                n++;
            }
        } else {
            System.out.println("Từ điển trống.");
        }
    }

    public void dictionaryBasic() {
        dicManagement.insertFromCommandline();
        showAllWords();
    }

    public void dictionaryAdvanced() throws IOException {
        dicManagement.insertFromFile();
        showAllWords();
        dicManagement.dictionaryLookup();
    }

    /**
     * Returns words that start with string s.
     * @param s string s
     * @return listword
     */
    public ArrayList<String> dictionarySearch(String s) {
        ArrayList<String> ListWord = new ArrayList<>();
        listWord = new ArrayList<>(dic.getDictionaryList());
        for (int i = 0; i < listWord.size(); i++) {
            String english = listWord.get(i).getWord_target();
            if (english.startsWith(s) == true) {
                ListWord.add(english);
            }
        }
        return ListWord;
    }

    public static void main(String[]args) throws IOException {
        Dictionary dic = new Dictionary();
        DictionaryManagement dicMa = new DictionaryManagement(dic);
        DictionaryCommandLine dicCom = new DictionaryCommandLine(dic, dicMa);
        //Scanner sc = new Scanner(System.in);
        dicCom.dictionaryBasic();
        dicMa.dictionaryExportToFile();
        dicCom.dictionaryAdvanced();
        //String s = sc.next();
        //ArrayList<String> S = dicCom.dictionarySearch(s);
        //for (int i = 0; i < S.size(); i++) {
        //    System.out.print(S.get(i) + " ");
        //}
    }
}