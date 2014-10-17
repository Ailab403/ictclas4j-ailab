package org.ailab.analyzer;

import java.io.Reader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;

/**
 * ictclas4j 的 lucene 分析器
 * 
 * @author chenlb 2009-1-23 上午 11:39:39
 */
public class ICTCLAS4jAnalyzer extends Analyzer {

	private static final long serialVersionUID = 1L;

	// 可以自定义添加更多的过虑的词（高频无多太用处的词）
	private static final String[] STOP_WORDS = { "and", "are", "as", "at",
			"be", "but", "by", "for", "if", "in", "into", "is", "it", "no",
			"not", "of", "on", "or", "such", "that", "the", "their", "then",
			"there", "these", "they", "this", "to", "was", "will", "with", "的" };

	@Override
	public TokenStream tokenStream(String fieldName, Reader reader) {
		TokenStream result = new ICTCLAS4jTokenizer(reader);

		// new StopFilter(new LowerCaseFilter(result), STOP_WORDS)
		result = new ICTCLAS4jFilter(new StopFilter(
				new LowerCaseFilter(result), STOP_WORDS));

		return result;
	}

}
