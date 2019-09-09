/**
 * Copyright  2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.nie.lucene;

import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.index.SortedDocValues;
import org.apache.lucene.search.Collector;
import org.apache.lucene.search.LeafCollector;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Scorer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * MyCollector
 *
 * @author zhaochengye
 * @Date 2019/9/9
 */
public class MyCollector implements Collector , LeafCollector {
    /**评分计算器*/
    private Scorer scorer;
    /**段文件的编号*/
    private int docBase;
    /**
     * 域字段名
     */
    private String fieldName;
    /**
     * 排序字段values
     */
    private SortedDocValues sortedDocValues;
    /**
     * 评分文档
     */
    private List<ScoreDoc> scoreDocs = new ArrayList<ScoreDoc>();


    public MyCollector(String fieldName){
        super();
        this.fieldName = fieldName;
    }


    @Override
    public LeafCollector getLeafCollector(LeafReaderContext leafReaderContext) throws IOException {
        this.sortedDocValues = leafReaderContext.reader().getSortedDocValues(fieldName);
        return this;
    }

    @Override
    public boolean needsScores() {
        return false;
    }

    @Override
    public void setScorer(Scorer scorer) throws IOException {
        this.scorer = scorer;
    }

    @Override
    public void collect(int docId) throws IOException {
        // scoreDoc:docId和评分
        this.scoreDocs.add(new ScoreDoc(this.docBase + docId, this.scorer.score()));
    }

    public Scorer getScorer() {
        return scorer;
    }

    public int getDocBase() {
        return docBase;
    }

    public void setDocBase(int docBase) {
        this.docBase = docBase;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public SortedDocValues getSortedDocValues() {
        return sortedDocValues;
    }

    public void setSortedDocValues(SortedDocValues sortedDocValues) {
        this.sortedDocValues = sortedDocValues;
    }

    public List<ScoreDoc> getScoreDocs() {
        return scoreDocs;
    }

    public void setScoreDocs(List<ScoreDoc> scoreDocs) {
        this.scoreDocs = scoreDocs;
    }
}