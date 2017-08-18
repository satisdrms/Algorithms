package com.satisdrms.code.interPrct;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class UserPage {
	int user_id;
	String url;

	public UserPage(int user_id, String url) {
		this.user_id = user_id;
		this.url = url;
	}
}

class ThreePagePath {
	String[] urls;
	int size;

	public ThreePagePath() {
		urls = new String[3];
		size = 0;
	}

	public void setUrl(String url) {
		if (size == 3) {
			urls[0] = urls[1];
			urls[1] = urls[2];
			urls[2] = url;
		} else {
			urls[size++] = url;

		}
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		String u = urls[0] + " " + urls[1] + " " + urls[2];
		return u;
	}

}

public class MostVisited3PagePath {
	public static HashMap<String, Integer> countOfEachThreePages = new HashMap<String, Integer>();

	public static void main(String[] args) {
		UserPage[] user_pages = loadURLLog();
		mostVisitedPath(user_pages);

	}

	private static void mostVisitedPath(UserPage[] user_pages) {

		HashMap<Integer, ThreePagePath> threePagePathsForEachUser = new HashMap<Integer, ThreePagePath>();

		for (int i = 0; i < user_pages.length; i++) {
			ThreePagePath tpTemp;
			//Adding the URL when the id exists in the latest three page URL per user
			if (threePagePathsForEachUser.containsKey(user_pages[i].user_id)) {
				tpTemp = threePagePathsForEachUser.get(user_pages[i].user_id);
				tpTemp.setUrl(user_pages[i].url);

				// Adding the Three page URL to the collections where each entry is counted
				if (tpTemp.getSize() == 3)
					addThreePageURLToCollections(tpTemp);

			} else {
				tpTemp = new ThreePagePath();
				tpTemp.setUrl(user_pages[i].url);
				threePagePathsForEachUser.put(user_pages[i].user_id, tpTemp);
			}
		}

		//Finding the max three page url based on the event occured
		Set<String> k = countOfEachThreePages.keySet();
		int maxOccur = 0;
		String maxThreePageURL = null;
		for (String t : k) {
			int curCount = countOfEachThreePages.get(t);
			if (curCount > maxOccur) {
				maxOccur = curCount;
				maxThreePageURL = t;
			}
		}

		System.out.println("most visited three page URL is \n"
				+ maxThreePageURL.replace(" ", "\n"));
	}

	private static void addThreePageURLToCollections(ThreePagePath tpTemp) {
		//Incrementing the threepageurl count if it is already found in the collection, otherwise it is added with default value of 1
		if (countOfEachThreePages.containsKey(tpTemp.toString())) {
			Integer count = countOfEachThreePages.get(tpTemp.toString());
			countOfEachThreePages.put(tpTemp.toString(), ++count);
		} else {
			countOfEachThreePages.put(tpTemp.toString(), 1);
		}

	}

	private static UserPage[] loadURLLog() {
		List<UserPage> up = new LinkedList<UserPage>();
		up.add(new UserPage(1, "/products"));
		up.add(new UserPage(1, "/products/iPhone"));
		up.add(new UserPage(1, "/products/pixelPhone"));
		up.add(new UserPage(1, "/order_product"));
		up.add(new UserPage(2, "/products"));
		up.add(new UserPage(2, "/products/jeans"));
		up.add(new UserPage(3, "/home"));
		up.add(new UserPage(2, "/support/faq"));
		up.add(new UserPage(3, "/products/table"));
		up.add(new UserPage(1, "/payment"));
		up.add(new UserPage(1, "/products"));
		up.add(new UserPage(1, "/products/iPhone"));
		up.add(new UserPage(1, "/products/pixelPhone"));

		return (UserPage[]) up.toArray(new UserPage[up.size()]);

	}
}
