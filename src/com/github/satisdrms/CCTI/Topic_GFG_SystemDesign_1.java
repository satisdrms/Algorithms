package com.github.satisdrms.CCTI;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

class ENewsManager {
	List<NewsChannel> subscriptionList;

	public void addSubscription(NewsChannel n) {}
	public void removeSubscription(NewsChannel n) {}
	public void searchSubscriptionList(NewsChannel n){}
	
	public void refreshNewsChannel(NewsChannel n){}
	
	
}

class NewsChannel {
	HashMap<Date, NewsContent> downloadedContent;
	List<String> topicsOfInterest;

	public void addInterest(String s) {}
	public void removeInterest(String s) {}
	public void checkForNewNewsContent(){}
	public void removeNewsContent(NewsContent n){}

	public void browseNews(Date d){
		//News sorted by date
		NewsContent n=downloadedContent.get(d /*Calendar.DATE*/);
		displayNews(n);
	}
	
	public void displayNews(NewsContent n){}

}

class NewsContent {
	String title;
	Date dateOfNews;
	String htmlNewsContent;

}

public class Topic_GFG_SystemDesign_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
