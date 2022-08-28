import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class MyTranslator {
    private Map <String, String> dictionary;

    public MyTranslator(Map<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Map <String, String> dictionary) {
        this.dictionary = dictionary;
    }

    public void setDictionaryManually(){
        Scanner sc = new Scanner(System.in);
        String key = "";
        String value = "";
        for (;;){
            System.out.println("Input word. For stop input \"0\" : ");
            key = sc.next();
            if (key.equals("0")){
                break;
            }
            System.out.println("Input translation: ");
            value = sc.next();
            dictionary.put(key, value);
        }
        System.out.println(dictionary);
    }

    public void saveDictionaryToFile(File whereToSave) throws IOException {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(whereToSave)))) {
            pw.println(dictionary);
            System.out.println("Your translation successfully saved to " + whereToSave.getName());
        }

    }


    public static String[] readWordsFromFile (String fileName) throws IOException {
        return Files.lines(Paths.get(fileName)).filter(str -> str.length() > 1)
                .collect(Collectors.joining()).toLowerCase().replaceAll("[?,.!\"]", "").split(" ");
    }

    public static void writeWordsToFile (String words, File output) throws IOException {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(output.getName())))) {
            pw.println(words);
            System.out.println("Your translation successfully saved to " + output.getName());
        }
    }

    public String toTranslate (File english) throws IOException{
        String[] read = readWordsFromFile(english.getName());
        String translation = "";
        for (String s : read){
            if (dictionary.get(s) != null) {
                System.out.println(s);
                translation += dictionary.get(s) + " ";
            }
        }
    return translation.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyTranslator)) return false;
        MyTranslator that = (MyTranslator) o;
        return Objects.equals(getDictionary(), that.getDictionary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDictionary());
    }

    @Override
    public String toString() {
        return "MyTranslator{" +
                "dictionary=" + dictionary +
                '}';
    }
}
