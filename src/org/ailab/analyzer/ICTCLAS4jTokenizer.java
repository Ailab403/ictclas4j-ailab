package org.ailab.analyzer;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.Tokenizer;
import org.ictclas4j.bean.SegResult;
import org.ictclas4j.segment.SegTag;

/**
 * ictclas4j ÇÐ´Ê
 * 
 * superhy fix
 */
public class ICTCLAS4jTokenizer extends Tokenizer {

	private static SegTag segment;

	private StringBuilder sb = new StringBuilder();

	private ArrayList<String> words;

	private int startOffest = 0;
	private int length = 0;
	private int wordIdx = 0;

	public ICTCLAS4jTokenizer() {
		words = new ArrayList<String>();
	}

	public ICTCLAS4jTokenizer(Reader input) {
		super(input);
		char[] buf = new char[8192];
		int d = -1;
		try {
			while ((d = input.read(buf)) != -1) {
				sb.append(buf, 0, d);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		SegResult sr = seg().split(sb.toString(), false); // ·Ö´Ê

		words = sr.getWords();
	}

	public Token next(Token reusableToken) throws IOException {
		assert reusableToken != null;

		length = 0;
		Token token = null;
		if (wordIdx < words.size()) {
			String word = words.get(wordIdx);
			length = word.length();
			token = reusableToken.reinit(word, startOffest, startOffest
					+ length);
			wordIdx++;
			startOffest += length;

		}

		return token;
	}

	private static SegTag seg() {
		if (segment == null) {
			segment = new SegTag(1);
		}
		return segment;
	}

	public boolean incrementToken() throws IOException {
		// TODO Auto-generated method stub
		return false;
	}
}