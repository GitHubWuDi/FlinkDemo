package com.vrv.flink.demo.model.util;
/**
* @author wudi E-mail:wudi891012@163.com
* @version 创建时间：2019年8月29日 下午7:22:55
* 类说明
*/

import java.util.ArrayList;
import java.util.List;

import com.vrv.flink.demo.model.ProbeNetflow;

public class SourceUtil {
        
	    public static List<ProbeNetflow>  getProBeSource(){
	    	List<ProbeNetflow> list = new ArrayList<>();
	    	for (int i = 0; i < 10; i++) {
	    		ProbeNetflow probeNetflow = new ProbeNetflow();
	    		probeNetflow.setDownload_bytes(Long.valueOf("1000"));
	    		probeNetflow.setSrc_Ip("192.168.120.105");
	    		probeNetflow.setDst_ip("192.168.120.106");
	    		list.add(probeNetflow);
			}
			return list;
	    } 
	     
	
}
