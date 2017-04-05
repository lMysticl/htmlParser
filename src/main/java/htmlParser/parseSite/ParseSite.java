package htmlParser.parseSite;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeMap;
/**
 * @author Putrenkov Pavel
 *
 */
public class ParseSite {

    private final TreeMap<String, Integer> MAP_COUNTER;
    private final String url;

    public ParseSite(String url) {
        this.url = url;
        this.MAP_COUNTER = new TreeMap<>();
    }

    public TreeMap<String, Integer> startParse() throws IOException {

        org.jsoup.Jsoup.parse(new java.net.URL(url), 10_000)
                .body().children().stream()
                .map(Element::children)
                .filter(Elements::hasText)
                .forEach(str -> {
                    StringTokenizer st = new StringTokenizer(str.text().toLowerCase());
                    while (st.hasMoreTokens()) {
                        StringBuilder sb = new StringBuilder();
                        for (char ch : st.nextToken().toCharArray()) {
                            if (Character.isLetter(ch)) sb.append(ch);
                        }
                        String text = sb.toString();
                        if (!text.isEmpty())
                            MAP_COUNTER.put(text, MAP_COUNTER.get(text) == null ? 1 : MAP_COUNTER.get(text) + 1);
                    }
                });

        return MAP_COUNTER;
    }
}
