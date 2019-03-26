package rebue.xyz.ro;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class AreaSendOrgRo {

	/**
	 * 区域id
	 */  
	private Long areaId;

	/**
	 * 区域名称
	 */
	private String areaName;
 
	/**
	 * 区域下的发货总数
	 */
	private Long allCount;
	
	/**
	 * 分页返回值
	 */
	private Long total;
	/**
	 * 分页返回值
	 */
	private int pageNum;
	/**
	 * 分页返回值
	 */
	private int pageSize;

	/**
	 * 发货组织集合
	 */
	private List<SendOrgDeliverCountRo> sendOrg;

}
