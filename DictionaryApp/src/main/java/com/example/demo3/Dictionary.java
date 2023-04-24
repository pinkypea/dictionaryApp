package com.example.demo3;

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

    public void insertWord(String Eng, String Viet) {
        Word new_word = new Word(Eng, Viet);
        dictionaryList.add(new_word);
    }

    public String searchWord(String Eng) {
        for (int i = 0; i < dictionaryList.size(); i++) {
            if (dictionaryList.get(i).getWord_target().equals(Eng)) {
                return dictionaryList.get(i).getWord_explain();
            }
        }
        return null;
    }

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

    public boolean editWord(String Eng, String Viet, String _Eng, String _Viet) {
        if(removeWord(Eng, Viet) == true) {
            insertWord(_Eng, _Viet);
            return true;
        }
        return false;
    }

}
