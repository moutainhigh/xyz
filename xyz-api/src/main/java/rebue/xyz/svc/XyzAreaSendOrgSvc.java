package rebue.xyz.svc;
import rebue.robotech.svc.BaseSvc;
import rebue.xyz.jo.XyzAreaSendOrgJo;
import rebue.xyz.mo.XyzAreaSendOrgMo;
import rebue.xyz.ro.AreaSendOrgRo;
import rebue.xyz.to.AreaSendOrgTo;

/**
 * 区域发货组织关系
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
public interface XyzAreaSendOrgSvc extends BaseSvc<java.lang.Long, XyzAreaSendOrgMo, XyzAreaSendOrgJo> {
	
	/**
	 * 根据条件查询发货组织
	 * @param to
	 * @return
	 */
	AreaSendOrgRo listAreaSendOrgs(AreaSendOrgTo to,Integer pageSize, Integer pageNum);
}
