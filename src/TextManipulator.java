import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TextManipulator {

    String slowo;
    int dlugosc;
    List<Character> uniqueList;
    List<Character> chars;
    List<Integer> occurrencesList;
    List<Double> charsProbabilityList;

    public TextManipulator(String str) {
        this.slowo = str;
        this.dlugosc = str.length();
        this.chars = this.convertStringToCharList(str);
        this.uniqueList = this.uniqueCharsFromList(chars);
        this.occurrencesList=this.charsOccurrences(chars,uniqueList);
        this.charsProbabilityList= this.charsProbability(occurrencesList);
    }

    public static List<Character> convertStringToCharList(String str) { // konwersja łańcucha znaków na Listę znaków
        List<Character> chars = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            chars.add(ch);
        }
        return chars;
    }

    public static List<Character> uniqueCharsFromList(List<Character> list) { // wybranie wartości unikalnych z Listy znaków
        List<Character> uniqueList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!uniqueList.contains(list.get(i))) {
                uniqueList.add(list.get(i));
            }
        }
        return uniqueList;
    }

    public static List<Integer> charsOccurrences(List<Character> list, List<Character> uniqueList) { // zliczenie wystąpień poszczególnych znaków w Liście
        List<Integer> occurrencesList = new ArrayList<>();
        for (Character c : uniqueList) {
            occurrencesList.add(Collections.frequency(list, c));
        }
        return occurrencesList;

    }

    public static List<Double> charsProbability(List<Integer> occurrencesList) { // wyliczenie prawdopodobieństw
        List<Double> charsProbabilityList = new ArrayList<>(); // lista prawdopodobienstw
        int suma = occurrencesList.stream().mapToInt(Integer::intValue).sum(); // suma elementow z listy
        charsProbabilityList = occurrencesList.stream().map(e -> (double) e / suma).collect(Collectors.toList());
        return charsProbabilityList;
    }
}
