package com.vrv.flink.demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.java.BatchTableEnvironment;

/**
 * 使用flink统计wordCount
 * @author Administrator
 *
 */

public class WordCountSQL {

	
	public static void main(String[] args) throws Exception {
		//创建flink执行环境
		ExecutionEnvironment fbEnv = ExecutionEnvironment.getExecutionEnvironment();
		BatchTableEnvironment fbTableEnv = BatchTableEnvironment.create(fbEnv);
		
		//构造对应的数据源
		String words = "hello word hello flink";
		String[] split = words.split("\\W+");
		List<WC> list = new ArrayList<>();
		for (String s : split) {
			WC wc = new WC(s, 1);
			list.add(wc);
		}
		DataSet<WC> fromCollection = fbEnv.fromCollection(list);
		
		//将数据源注册到表当中
		fbTableEnv.registerDataSet("wordCount", fromCollection, "word,frequency");
		String sql = "select word,sum(frequency) as frequency from wordCount group by word";
		
		//执行对应的sql
		Table table = fbTableEnv.sqlQuery(sql);
		DataSet<WC> dataSet = fbTableEnv.toDataSet(table, WC.class);
		dataSet.print();
		
		//fbEnv.execute();
	}
	
	
	public static class WC  {
		
		public String word;
		public long frequency;
		
		public WC() {}
		
		public WC(String word,long frequency){
			this.word = word;
			this.frequency = frequency;
		}
		@Override
		public String toString() {return word+","+frequency;};
	}
	
	
	
}
