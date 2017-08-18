package com.satisdrms.code.interPrct;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class UserPage1 {
	int user_id;
	String url;

	public UserPage1(int user_id, String url) {
		this.user_id = user_id;
		this.url = url;
	}
}

class ThreePagePath1 implements Comparable<ThreePagePath> {
	String[] urls;
	int size;

	public ThreePagePath1() {
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
	public int hashCode() {
		String u = urls[0] + urls[1] + urls[2];
		return u.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		ThreePagePath to = (ThreePagePath) obj;
		if (to.urls[0].equals(urls[0]) && to.urls[1].equals(urls[1])
				&& to.urls[2].equals(urls[2]))
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		String u = urls[0] + urls[1] + urls[2];
		return u;
	}

	@Override
	public int compareTo(ThreePagePath o) {
		String cur = urls[0] + urls[1] + urls[2];
		String foriegn = o.urls[0] + o.urls[1] + o.urls[2];
		return cur.compareTo(foriegn);

	}

}

public class CopyOfMostVisited3PagePath {
	public static void main(String[] args) {
		UserPage[] user_pages = loadURLLog();
		mostVisitedPath(user_pages);
	}

	private static void mostVisitedPath(UserPage[] user_pages) {

		HashMap<Integer, ThreePagePath> threePagePathsForEachUser = new HashMap<Integer, ThreePagePath>();

		HashMap<ThreePagePath, Integer> countOfEachThreePages = new HashMap<ThreePagePath, Integer>();

		for (int i = 0; i < user_pages.length; i++) {
			System.out.println("url " + user_pages[i].url);
			ThreePagePath tpTemp;
			if (threePagePathsForEachUser.containsKey(user_pages[i].user_id)) {

				tpTemp = threePagePathsForEachUser.get(user_pages[i].user_id);
				tpTemp.setUrl(user_pages[i].url);
				System.out.println(tpTemp.getSize());
				if (tpTemp.getSize() == 3) {
					System.out.println(tpTemp.toString());
					if (countOfEachThreePages.containsKey(tpTemp)) {
						System.out.println("contains");
						Integer count = countOfEachThreePages.get(tpTemp);
						countOfEachThreePages.put(tpTemp, count++);
					} else {
						System.out.println("not contains");

						countOfEachThreePages.put(tpTemp, 1);
					}
				}
			} else {
				tpTemp = new ThreePagePath();
				tpTemp.setUrl(user_pages[i].url);
				threePagePathsForEachUser.put(user_pages[i].user_id, tpTemp);
			}

		}
		Set<ThreePagePath> k = countOfEachThreePages.keySet();
		for (ThreePagePath t : k) {
			System.out.println(t.toString() + " the count is "
					+ countOfEachThreePages.get(t));
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
