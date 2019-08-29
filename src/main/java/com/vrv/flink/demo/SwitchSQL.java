package com.vrv.flink.demo;

import java.util.List;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.java.BatchTableEnvironment;

import com.vrv.flink.demo.WordCountSQL.WC;
import com.vrv.flink.demo.model.OutPutVO;
import com.vrv.flink.demo.model.ProbeNetflow;
import com.vrv.flink.demo.model.util.SourceUtil;

/**
 * @author wudi E-mail:wudi891012@163.com
 * @version 创建时间：2019年8月29日 下午7:05:01 类说明
 */
public class SwitchSQL {

	public static void main(String[] args) throws Exception {
		ExecutionEnvironment fbEnv = ExecutionEnvironment.getExecutionEnvironment();
		BatchTableEnvironment fbTableEnv = BatchTableEnvironment.create(fbEnv);
		//获得有界数据流
		List<ProbeNetflow> list = SourceUtil.getProBeSource();
		DataSet<ProbeNetflow> flowSet = fbEnv.fromCollection(list);
		//将数据源注册到表当中
		fbTableEnv.registerDataSet("probe", flowSet, "dst_ip,download_bytes");
		String sql = "select dst_ip as ip,sum(download_bytes) as sums from probe group by dst_ip";
		//执行sql查询
		Table table = fbTableEnv.sqlQuery(sql);
		DataSet<OutPutVO> dataSet = fbTableEnv.toDataSet(table, OutPutVO.class);
		dataSet.print();
		
	}

}
