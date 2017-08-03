package com.satisdrms.code.stringProblems;

import java.io.File;

public class SlashTest {

	public static void main(String[] args) {
		File file = new File(
				"C:\\Users\\ssubra67\\Projects\\workspace_satis\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\WebTextSearchExample\\input\\redis\\redis-unstable\\.gitignore");
		String folderPath = "/C:/Users/ssubra67/Projects/workspace_satis/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/WebTextSearchExample/input/redis/";
		// System.out.println("File is " + file);
		// System.out.println("Folder path is " + folderPath);
		// folderPath = folderPath.replace('/', '\\');
		// System.out.println(folderPath);
		//
		// folderPath = folderPath.substring(1);
		// System.out.println(folderPath);
		//
		// String filePath = file.getAbsolutePath();
		// File finFile = null;
		// if (filePath.startsWith(folderPath)) {
		// finFile = new File(filePath.substring(folderPath.length() + 2));
		// }
		// System.out.println(finFile.toString());

		System.out.println(getRelativePath(file, folderPath));

	}

	public static String getRelativePath(File file, String folderPath) {
		 System.out.println("File is " + file);
		 System.out.println("Folder path is " + folderPath);
		folderPath = folderPath.replace('/', '\\');
		folderPath = folderPath.substring(1);
		 System.out.println("modified folder path " + folderPath);
		String filePath = file.getAbsolutePath();
		String finFile = null;
		if (filePath.startsWith(folderPath)) {
			finFile = filePath.substring(folderPath.length() );
		}
		System.out.println(finFile.toString());
		return finFile;
	}

}
