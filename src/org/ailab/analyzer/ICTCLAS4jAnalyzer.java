package org.ailab.analyzer;

import java.io.Reader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;

/**
 * ictclas4j �� lucene ������
 * 
 * @author chenlb 2009-1-23 ���� 11:39:39
 */
public class ICTCLAS4jAnalyzer extends Analyzer {

	private static final long serialVersionUID = 1L;

	// �����Զ�����Ӹ���Ĺ��ǵĴʣ���Ƶ�޶�̫�ô��Ĵʣ�
	private static final String[] STOP_WORDS = { "and", "are", "as", "at",
			"be", "but", "by", "for", "if", "in", "into", "is", "it", "no",
			"not", "of", "on", "or", "such", "that", "the", "their", "then",
			"there", "these", "they", "this", "to", "was", "will", "with", "��" };

	@Override
	public TokenStream tokenStream(String fieldName, Reader reader) {
		TokenStream result = new ICTCLAS4jTokenizer(reader);

		// new StopFilter(new LowerCaseFilter(result), STOP_WORDS)
		result = new ICTCLAS4jFilter(new StopFilter(
				new LowerCaseFilter(result), STOP_WORDS));

		return result;
	}

}
