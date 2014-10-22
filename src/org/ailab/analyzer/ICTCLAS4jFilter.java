package org.ailab.analyzer;

import java.io.IOException;

import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;

/**
 * 标点符等， 过虑.
 * 
 * superhy fix
 */
public class ICTCLAS4jFilter extends TokenFilter {

	protected ICTCLAS4jFilter(TokenStream input) {
		super(input);
	}

	public final Token next(final Token reusableToken)
			throws java.io.IOException {
		assert reusableToken != null;

		for (Token nextToken = (input).next(reusableToken); nextToken != null; nextToken = (input)
				.next(reusableToken)) {
			String text = nextToken.term();

			switch (Character.getType(text.charAt(0))) {

			case Character.LOWERCASE_LETTER:
			case Character.UPPERCASE_LETTER:

				// English word/token should larger than 1 character.
				if (text.length() > 1) {
					return nextToken;
				}
				break;
			case Character.DECIMAL_DIGIT_NUMBER:
			case Character.OTHER_LETTER:

				// One Chinese character as one Chinese word.
				// Chinese word extraction to be added later here.

				return nextToken;
			}

		}
		return null;
	}

	public boolean incrementToken() throws IOException {
		// TODO Auto-generated method stub
		return false;
	}
}
