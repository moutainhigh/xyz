package rebue.xyz.ro;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class SendOrgDeliverCountRo {
	
	/**
	 * 组织id
	 */
	private Long id;
	
	/**
	 * 组织名称
	 */
	private  String  orgName;
	
	/**
	 * 发货数量
	 */
	private Long count;
	
}
