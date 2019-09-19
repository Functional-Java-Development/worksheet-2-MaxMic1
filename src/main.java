import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Worksheet2_1 {

    private static <T> void getStream(int seedValue, int limitTerms)
    {
        Stream.iterate(seedValue, (Integer n) -> n + 1).limit(limitTerms)
                .mapToInt(c -> (c*(c+1)/2))
                .forEach(System.out::println);
    }

    private static <T> void removeStopWords(List<String> words) {
        ArrayList<String> stopWords = new ArrayList<String>() {{
            add("a");
            add("an");
            add("the");
            add("so");
            add("it");
            add("do");
            add("did");
            add("for");
            add("by");
            add("of");
            add("to");
        }};
        System.out.println();

        List<String> newll = words.stream()
                               .distinct()
                               .filter(c -> !stopWords.contains(c))
                               .sorted(Comparator.reverseOrder())
                               .collect(Collectors.toList());

        System.out.println("List without duplicates: " + newll);
    }

    public static void main(String[] args)
    {
        int seedValue = 1;
        int limitTerms = 10;
        getStream(seedValue, limitTerms);

        LinkedList<String> list = new LinkedList<String>();
        Scanner input=new Scanner(System.in);
        System.out.print("how many words do you want to add: ");
        int num=input.nextInt();
        for(int i=0;i<num;i++){
            System.out.print("Add word " + i +": ");
            String element=input.next();
            list.add(element);
        }

        removeStopWords(list);

    }
}