package rebue.xyz.to;


import java.util.ArrayList;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class AreaSendOrgTo {
	
	
	/**
	 * 组织id
	 */
	private Long orgId;
	
	/**
	 * 组织名称
	 */
	private String orgName;
	
	/**
	 * 要查询的物流状态集合
	 */
	private ArrayList<Byte> logisticStatus;
	
	/**
	 * 分页返回值
	 */
	private int pageNum;
	/**
	 * 分页返回值
	 */
	private int pageSize;
	
	/**
	 * 下单时间开始
	 */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date orderTimeStart;
	
    /**
     * 下单时间结束
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date orderTimeEnd;
}
