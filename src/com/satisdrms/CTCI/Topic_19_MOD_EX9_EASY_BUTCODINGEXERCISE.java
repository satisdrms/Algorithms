package com.satisdrms.CTCI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Since XML is very verbose, you are given a way of encoding it where each tag gets mapped to a pre-defined integer value. The language/grammar is as follows:
//Element --> Element Attr* END Element END [aka, encode the element
//tag, then its attributes, then tack on an END character, then
//encode its children, then another end tag]
//Attr --> Tag Value [assume all values are strings]
//END --> 01
//Tag --> some predefined mapping to int
//Value --> string value END
//Write code to print the encoded version of an xml element (passed in as string).
//FOLLOW UP
//Is there anything else you could do to (in many cases) compress this even further?

class xmlEncoder {
	ArrayList<String> tokens = new ArrayList<String>();
	Map<String, Integer> tagCode = new HashMap<String, Integer>();
	int currentTokenIndex = 0;
	int[] end = { 0, 1 };

	xmlEncoder(String s) {
		tokenize(s);
		initTagCode();
		for (String str : tokens) {
			System.out.println(str);
		}
	}

	public void encode() throws IOException {
		while (hasNextToken("<")) {
			nextToken("<");
			String tagName = nextToken();
			print(getTagCode(tagName));
			while (!hasNextToken(">") && !hasNextToken("/", ">")) {
				String key = nextToken();
				nextToken("=");
				String value = nextToken();
				print(tagCode.get(key));
				print(value);
			}
			print(end[0]);
			if (hasNextToken("/", ">")) {
				nextToken("/");
				nextToken(">");
			} else
				nextToken(">");
		}
	}

	private boolean hasNextToken(String... string) throws IOException {
		if (currentTokenIndex >= tokens.size()) {
			throw new IOException("Unexpected end of the input");
		}
		for (int i = 0; i < string.length; i++) {
			if (!tokens.get(currentTokenIndex + i).equals(string[i]))
				return false;
		}
		return true;
	}

	private boolean hasNextToken(String string) throws IOException {
		if (currentTokenIndex >= tokens.size()) {
			throw new IOException("Unexpected end of the input");
		}
		if (tokens.get(currentTokenIndex).equals(string))
			return true;
		return false;
	}

	private void print(String value) {
		System.out.print(value + " ");

	}

	private void print(Integer Code) {
		System.out.print(Code + " ");

	}

	private Integer getTagCode(String tagName) {
		return tagCode.get(tagName);
	}

	private String nextToken() throws IOException {
		if (currentTokenIndex >= tokens.size()) {
			throw new IOException("Unexpected end of the input");
		}
		String str = tokens.get(currentTokenIndex);
		currentTokenIndex++;
		return str;

	}

	private void nextToken(String expectedToken) throws IOException {
		if (currentTokenIndex >= tokens.size()) {
			throw new IOException("Unexpected end of the input");
		}
		String token = tokens.get(currentTokenIndex);
		if (token.equals(expectedToken)) {
			currentTokenIndex++;
		} else
			throw new IOException("Unexpected input. Expected '"
					+ expectedToken + "'; found '" + token + "'.");

	}

	private void initTagCode() {
		// <family lastName="McDowell" state="CA">
		// <person firstName="Gayle">Some Message</person>
		// </family>
		tagCode.put("family", 11);
		tagCode.put("lastName", 12);
		tagCode.put("state", 13);
		tagCode.put("firstName", 14);
		tagCode.put("person", 15);
		tagCode.put("root", 16);

	}

	public void tokenize(String s) {
		int i = 0;
		char[] str = s.toCharArray();
		while (i < str.length)
			if (str[i] == ' ')
				i++;
			else if (str[i] == '<' || str[i] == '>' || str[i] == '='
					|| str[i] == '/') {
				tokens.add(Character.toString(str[i]));
				i++;
			} else {
				StringBuilder string = new StringBuilder();
				do {
					string.append(str[i]);
					i++;
					if (str[i] == '<' || str[i] == '>' || str[i] == '='
							|| str[i] == '/' || str[i] == ' ')
						break;
				} while (i < str.length);
				tokens.add(string.toString());
			}

	}

}

public class Topic_19_MOD_EX9_EASY_BUTCODINGEXERCISE {

	public static void main(String[] args) throws IOException {
		String s = " <family lastName=\"McDowell\" state=\"CA\">  <person firstName=\"Gayle\">Some Message</person>  </family>";
		xmlEncoder xmlEnc = new xmlEncoder(s);
		xmlEnc.encode();

	}
}
