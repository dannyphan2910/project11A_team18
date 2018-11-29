package search;

import java.io.IOException;
import java.net.URLEncoder;
import java.awt.Desktop;
import java.net.URI;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

//javac -classpath ".:jsoup-1.10.2.jar:SimpleTTS.jar" SearchFunction.java
//java -classpath ".:jsoup-1.10.2.jar:SimpleTTS.jar" SearchFunction

public class SearchFunction {
	/*
	public static void main(String[] args) {
		//for testing
		search("Williamstown");
	}
	*/
	public static void search(String searchText) {

		String encoding = "UTF-8";

		try {
			Document google = Jsoup.connect("https://www.google.com/search?q=" + URLEncoder.encode(searchText, encoding)).userAgent("Mozilla/5.0").get();

			Elements webLinks = google.getElementsByTag("cite");

			//Check if any results found
			if (webLinks.isEmpty()) {
				System.out.println("No results found.");
				return;
			}

			//to display everything:
			//webLinks.forEach(link->System.out.println(link.text()));

			//to display only the first:
			//String firstLink = webLinks.get(0).text();
			//System.out.println(firstLink);

			//to open the site:
			//openWebpage(firstLink);

			System.out.printf("Here are the search results for '%s': %n%n",searchText);
			SimpleTTS.say("Here are the search results for " + searchText);

			for (int i = 0; i < 5; i++) {
				if (webLinks.get(i).text().contains("https://")) {
					System.out.println(webLinks.get(i).text());
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/*
	public static void openWebpage(String urlString) {
    try {
        Desktop.getDesktop().browse(new URI(urlString));
    } catch (Exception e) {
        e.printStackTrace();
    }
	}
	*/
}
