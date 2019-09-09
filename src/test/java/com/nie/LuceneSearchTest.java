/**
 * Copyright  2019 北京易酒批电子商务有限公司. All rights reserved.
 */
package com.nie;

import com.nie.lucene.MyCollector;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.QueryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

/**
 * LuceneSearch
 *
 * @author zhaochengye
 * @Date 2019/9/9
 */
public class LuceneSearchTest {

    @Test
    public void testMyCollector() throws IOException {
        String indexDir = "C:\\Users\\zhaochengye\\Desktop\\4CDggCNdRdSoQJEr3VF04w\\0\\index";
        Directory directory = FSDirectory.open(Paths.get(indexDir));
        IndexReader reader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(reader);
        TermQuery termQuery = new TermQuery(new Term("searchWordsNoScore", "酒"));
        MyCollector collector = new MyCollector("searchWordsNoScore");
        searcher.search(termQuery,collector);
//        ScoreDoc[] docs = topDocs.scoreDocs;
        List<ScoreDoc> docs = collector.getScoreDocs();
        for (ScoreDoc scoreDoc : docs) {
            int docID = scoreDoc.doc;
            Document document = searcher.doc(docID);
            String productSkuId = document.get("_uid");
            float score = scoreDoc.score;
            System.out.println(docID + ":" + productSkuId + "  " + score);
        }

        reader.close();
        directory.close();
    }
}