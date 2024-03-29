package com.vrv.flink.demo.model;
import lombok.Data;

import java.sql.Timestamp;

import com.vrv.flink.demo.model.enums.FieldDesc;
import com.vrv.flink.demo.model.enums.LogDesc;
import com.vrv.flink.demo.model.enums.RelateField;

/**
 *  @author zhouwu
 *  @version 创建时间：2019年8月12日 下午10:13:20  
 */
@Data
@LogDesc(value="流量探针/网络审计（03）",tableName="probe_netflow",topicName="probe-netflow")
public class ProbeNetflow {
    @FieldDesc("上报设备IP")
    private String  report_ip;
    @FieldDesc("上报设备IP转换")
    private	String 	report_ip_num;
    @FieldDesc("发生时间")
    private	String 	event_time;
    @FieldDesc("来源")
    private String msg_src;
    @FieldDesc("原始字段")
    private	String 	report_msg;
    @FieldDesc("安全域关联IP")
    private	String safety_margin_ip;
    @FieldDesc("安全级别")
    private	String 	security_level;
    @FieldDesc("日志类别")
    private	String log_type;
    @FieldDesc("安全域")
    private	String safety_margin;
    @FieldDesc("源ip")
    @RelateField("src_Ip")
    private	String 	src_Ip;
    @FieldDesc("源区域")
    private	String src_area;
    @FieldDesc("目的IP")
    private	String dst_ip;
    @FieldDesc("目标区域")
    private	String 	dst_area;
    @FieldDesc("源port")
    private	String 	src_port;
    @FieldDesc("目标port")
    private String dst_port;
    @FieldDesc("传输层协议")
    private	String 	transport_protocol;
    @FieldDesc("应用层协议")
    private	String 	protocol_type;
    @FieldDesc("发送包数量")
    private	String upload_pkg;
    @FieldDesc("发送大小")
    private	String upload_bytes;
    @FieldDesc("接收包数量")
    private	Long download_pkg;
    @FieldDesc("接收包大小")
    private	Long download_bytes;
    @FieldDesc("总包数量")
    private	Long 	all_pkg;
    @FieldDesc("总包大小")
    private	Long all_bytes;
    @FieldDesc("开始时间")
    private	String start_time;
    @FieldDesc("结束时间")
    private	String 	end_time;


    @FieldDesc("处理时间")
    private Timestamp triggerTime;
}
