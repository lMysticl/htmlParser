package htmlParser.main;

import htmlParser.parseSite.ParseSite;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
/**
 * @author Putrenkov Pavel
 *
 */
public class Main {

    public static void main(String[] args) {

        System.out.print("Input your URL: ");
        Scanner sc = new Scanner(System.in);
        String site = sc.nextLine();


        try {
            TreeMap<String, Integer> startParse = new ParseSite(site).startParse();
            Iterator<Map.Entry<String, Integer>> iterator = startParse.entrySet().iterator();
            int count = 0;

            while (iterator.hasNext()) {
                Map.Entry<String, Integer> nextWordCount = iterator.next();
                System.out.println(nextWordCount.getKey() + " - " + nextWordCount.getValue());
                count = count + nextWordCount.getValue();
            }
            System.out.println("Words number: " + count);

        } catch (IOException e) {
            System.out.println("Connect error or unknown url: " + site);
        }

    }

}
