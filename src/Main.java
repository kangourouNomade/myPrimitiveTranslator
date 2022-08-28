import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String> enToUkrDict = new HashMap<>();
        enToUkrDict.put("two", "��");
        enToUkrDict.put("cows", "������");
        enToUkrDict.put("standing", "������");
        enToUkrDict.put("in", "�");
        enToUkrDict.put("field", "���");
        enToUkrDict.put("one", "����");
        enToUkrDict.put("says", "����");
        enToUkrDict.put("to", "��");
        enToUkrDict.put("other", "����");
        enToUkrDict.put("you", "��");
        enToUkrDict.put("worried", "���������");
        enToUkrDict.put("about", "���");
        enToUkrDict.put("mad", "����");
        enToUkrDict.put("cow", "����");
        enToUkrDict.put("no", "�");
        enToUkrDict.put("it", "��");
        enToUkrDict.put("doesn't", "��");
        enToUkrDict.put("worry", "�����");
        enToUkrDict.put("me", "����");
        enToUkrDict.put("i'm", "�");
        enToUkrDict.put("horse", "���");

        File english = new File("English.in");
        File ukrainian = new File("Ukrainian.out");

        MyTranslator englToUkrTranslator = new MyTranslator(enToUkrDict);
        String translation = "";
        try {
            translation = englToUkrTranslator.toTranslate(english);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            MyTranslator.writeWordsToFile(translation, ukrainian);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(translation);
        englToUkrTranslator.setDictionaryManually();

        File dictionary = new File("Dictionary.txt");
        try {
            englToUkrTranslator.saveDictionaryToFile(dictionary);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}