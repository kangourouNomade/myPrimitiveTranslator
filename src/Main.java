import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String> enToUkrDict = new HashMap<>();
        enToUkrDict.put("two", "дві");
        enToUkrDict.put("cows", "корови");
        enToUkrDict.put("standing", "стоять");
        enToUkrDict.put("in", "в");
        enToUkrDict.put("field", "полі");
        enToUkrDict.put("one", "одна");
        enToUkrDict.put("says", "каже");
        enToUkrDict.put("to", "до");
        enToUkrDict.put("other", "іншої");
        enToUkrDict.put("you", "ти");
        enToUkrDict.put("worried", "хвилюєшся");
        enToUkrDict.put("about", "про");
        enToUkrDict.put("mad", "сказ");
        enToUkrDict.put("cow", "корів");
        enToUkrDict.put("no", "ні");
        enToUkrDict.put("it", "це");
        enToUkrDict.put("doesn't", "не");
        enToUkrDict.put("worry", "турбує");
        enToUkrDict.put("me", "мене");
        enToUkrDict.put("i'm", "я");
        enToUkrDict.put("horse", "кінь");

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