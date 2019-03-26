package rebue.xyz.to;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;


/**
 * 添加区域组织
 * @author jjl
 *
 */
@JsonInclude(Include.NON_NULL)
@Data
public class MoveOrgsTo {
	
	
	/**
	 * 要移动的组织id
	 */
	private ArrayList<Long> moveIds;
	
	/**
	 * 区域id
	 */
	private Long id;

		
}
