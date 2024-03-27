package com.assignment.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.assignment.Entity.Story;

@Service
public class DataExtract {

	public static List<Story> dataExtract() {
		List<Story> details = new ArrayList<>();
		try {
			
			Document doc = Jsoup.connect("https://time.com").get();

			Elements stories = doc.getElementsByClass("latest-stories__item");
			int count = 0;

			for (Element story : stories) {

				// Extract link
				String link = story.getElementsByTag("a").attr("href");
				
				String title = link.substring(9);
				title = title.substring(0, title.length()-1);
				
				Story st = new Story();
				st.setLink(link);
				st.setTitle(title);
				details.add(st);
				if (count == 6) {
					break;
				}
				count++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return details;
	}

}
