package rebue.xyz.svc;

import com.github.pagehelper.PageInfo;

import rebue.robotech.svc.BaseSvc;
import rebue.suc.mo.SucOrgMo;
import rebue.suc.ro.SucOrgInOrNotInRo;
import rebue.xyz.jo.XyzAreaMngOrgJo;
import rebue.xyz.mo.XyzAreaMngOrgMo;
import rebue.xyz.to.MoveOrgsTo;

/**
 * 区域管理组织关系
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
public interface XyzAreaMngOrgSvc extends BaseSvc<java.lang.Long, XyzAreaMngOrgMo, XyzAreaMngOrgJo> {
	
	/**
	 * 添加区域组织
	 * @param to
	 * @return
	 */
	int addOrgs(MoveOrgsTo to);
	
	/**
	 * 添加区域组织
	 * @param to
	 * @return
	 */
	int delOrgs(MoveOrgsTo to);
	/**
	 * 根据区域id获取已经添加和未添加的组织
	 * @param areaId
	 * @param pageSize
	 * @param addedKeys
	 * @param addedPageNum
	 * @param unaddedKeys
	 * @param unaddedPageNum
	 * @return
	 */
    public SucOrgInOrNotInRo listAddedAndUnaddedOrgs(Long areaId, Integer pageSize, String addedKeys, Integer addedPageNum, String unaddedKeys, Integer unaddedPageNum);
    
    /**
     *根据区域id获取已经添加的组织
     * @param areaId
     * @param keys
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<SucOrgMo> listAddedOrgsByOrgIdsAndKeys(Long areaId,  String keys, Integer pageNum, Integer pageSize);
    
    /**
     * 根据区域id获取没有添加的组织
     * @param areaId
     * @param keys
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<SucOrgMo> listUnaddedOrgsByOrgIdsAndKeys(Long areaId,  String keys, Integer pageNum, Integer pageSize);

}
