import java.io.*;
import java.util.*;

public class DictionaryManagement {
    private Dictionary dic = new Dictionary();

    public DictionaryManagement(Dictionary d) {
        dic = d;
    }

    /**
     * add some word to dic using commmandline.
     */
    public void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng từ cần thêm: ");
        int n = Integer.parseInt(sc.nextLine());
        if (n <= 0) {
            System.out.println("Không hợp lệ.");
        } else {
            for (int i = 1; i <= n; i++) {
                System.out.println("Nhập từ Tiếng Anh: ");
                String Eng = sc.nextLine();
                System.out.println("Nhập từ Tiếng Việt: ");
                String Viet = sc.nextLine();
                dic.insertWord(Eng, Viet);
            }
        }
    }

    /**
     * add some word to dic using file.
     * @throws IOException exception
     * @throws FileNotFoundException exception
     */
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
            System.out.println("Lỗi cú pháp.");
        }
    }

    public void deleteInFile() throws IOException {
        File file = new File("dictionaries.txt");
        file.delete();
        File newFile = new File("dictionaries.txt");
        newFile.createNewFile();
    }

    /**
     * export dic to file.
     * @throws IOException exception
     */
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

    public void dictionaryLookup() {
        System.out.println("Nhập từ cần tra cứu: ");
        Scanner sc = new Scanner(System.in);
        String Eng = sc.next();
        String Viet = dic.searchWord(Eng);
        if (Viet == null) {
            System.out.println("Không có trong từ điển.");
        } else {
            System.out.println("Nghĩa của từ là: ");
            System.out.println(Viet);
        }
    }

    public void deleteWord() {
        System.out.println("Nhập từ Tiếng Anh cần xóa: ");
        Scanner sc = new Scanner(System.in);
        String Eng = sc.nextLine();
        String Viet = dic.searchWord(Eng);
        if (Viet == null) {
            System.out.println("Không có trong từ điển.");
        } else {
            if (dic.removeWord(Eng, Viet) == true) {
                System.out.println("Xóa thành công.");
            } else {
                System.out.println("Không thành công, vui lòng thử lại.");
            }
        }
    }

    public void editWord() {
        System.out.println("Nhập từ Tiếng Anh cần sửa: ");
        Scanner sc = new Scanner(System.in);
        String Eng = sc.nextLine();
        String Viet = dic.searchWord(Eng);
        if (Viet == null) {
            System.out.println("Không có trong từ điển.");
        } else {
            System.out.println("Nhap nghia moi cua tu: ");
            String vietNew = sc.nextLine();
            if (dic.editWord(Eng, Viet, Eng, vietNew) == true) {
                System.out.println("Sửa từ thành công.");
            } else {
                System.out.println("Không thành công, vui lòng thử lại.");
            }
        }
    }

    public void search() {

    }
    /*
    public static void main(String[]args) {
        Dictionary dictionary = new Dictionary();
        DictionaryManagement a = new DictionaryManagement(dictionary);
        a.insertFromCommandline();
        a.dictionaryLookup();
    }
    */

}