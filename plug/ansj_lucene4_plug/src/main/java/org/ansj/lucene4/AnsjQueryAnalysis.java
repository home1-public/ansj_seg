package org.ansj.lucene4;

import org.ansj.lucene.util.AnsjTokenizer;
import org.ansj.splitWord.ToAnalysis;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Tokenizer;

import java.io.Reader;
import java.util.Set;

public class AnsjQueryAnalysis extends Analyzer {

    private final Set<String> filter;
    private final boolean pstemming;

//    /**
//     * @param pstemming 是否分析词干.进行单复数,时态的转换
//     */
//    public AnsjQueryAnalysis(final boolean pstemming) {
//        this.filter = null;
//        this.pstemming = pstemming;
//    }

    /**
     * @param filter    停用词
     * @param pstemming 是否分析词干
     */
    public AnsjQueryAnalysis(final Set<String> filter, final boolean pstemming) {
        this.filter = filter;
        this.pstemming = pstemming;
    }

    public AnsjQueryAnalysis() {
        super();
        this.filter = null;
        this.pstemming = false;
    }

    @Override
    protected TokenStreamComponents createComponents(final String fieldName, final Reader reader) {
        final Tokenizer tokenizer = new AnsjTokenizer(new ToAnalysis(reader, null), reader, this.filter, this.pstemming);
        return new TokenStreamComponents(tokenizer);
    }

}
