import java.util.*;
import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> dictionaryList = new ArrayList<>();

    public void setDictionaryList(ArrayList<Word> a) {
        this.dictionaryList = a;
    }
    public ArrayList<Word> getDictionaryList() {
        return dictionaryList;
    }

    /**
     * add new word.
     * @param Eng english word
     * @param Viet Viet Nam
     */
    public void insertWord(String Eng, String Viet) {
        Word new_word = new Word(Eng, Viet);
        dictionaryList.add(new_word);
    }

    // print list word
    public void print() {
        for(int i = 0; i < dictionaryList.size(); i++) {
            System.out.println(dictionaryList.get(i).getWord_target() + ":" + dictionaryList.get(i).getWord_explain());
        }
    }

    /**
     * check if word in list.
     * @param Eng english
     * @return word or null
     */
    public String searchWord(String Eng) {
        for (int i = 0; i < dictionaryList.size(); i++) {
            if (dictionaryList.get(i).getWord_target().equals(Eng)) {
                return dictionaryList.get(i).getWord_explain();
            }
        }
        return null;
    }

    /**
     * remove word from list.
     * @param Eng english
     * @param Viet Vietnamese
     * @return true or false
     */
    public boolean removeWord(String Eng, String Viet) {
        for (int i = 0; i < dictionaryList.size(); i++) {
            if (dictionaryList.get(i).getWord_target().equals(Eng)
                    && dictionaryList.get(i).getWord_explain().equals(Viet)) {
                dictionaryList.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * check word is added or not.
     * @param Eng old
     * @param Viet old
     * @param _Eng new
     * @param _Viet new
     * @return true or false
     */
    public boolean editWord(String Eng, String Viet, String _Eng, String _Viet) {
        if(removeWord(Eng, Viet) == true) {
            insertWord(_Eng, _Viet);
            return true;
        }
        return false;
    }

}