package rebue.xyz.svc.impl;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;

import rebue.robotech.svc.impl.BaseSvcImpl;
import rebue.suc.mo.SucOrgMo;
import rebue.suc.ro.SucOrgInOrNotInRo;
import rebue.suc.svr.feign.SucOrgSvc;
import rebue.xyz.dao.XyzAreaMngOrgDao;
import rebue.xyz.jo.XyzAreaMngOrgJo;
import rebue.xyz.mapper.XyzAreaMngOrgMapper;
import rebue.xyz.mo.XyzAreaMngOrgMo;
import rebue.xyz.svc.XyzAreaMngOrgSvc;
import rebue.xyz.to.MoveOrgsTo;

/**
 * 区域管理组织关系
 *
 * 在单独使用不带任何参数的 @Transactional 注释时， propagation(传播模式)=REQUIRED，readOnly=false，
 * isolation(事务隔离级别)=READ_COMMITTED， 而且事务不会针对受控异常（checked exception）回滚。
 *
 * 注意： 一般是查询的数据库操作，默认设置readOnly=true, propagation=Propagation.SUPPORTS
 * 而涉及到增删改的数据库操作的方法，要设置 readOnly=false, propagation=Propagation.REQUIRED
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
@Service
public class XyzAreaMngOrgSvcImpl
		extends BaseSvcImpl<java.lang.Long, XyzAreaMngOrgJo, XyzAreaMngOrgDao, XyzAreaMngOrgMo, XyzAreaMngOrgMapper>
		implements XyzAreaMngOrgSvc {

	/**
	 * @mbg.generated 自动生成，如需修改，请删除本行
	 */
	private static final Logger _log = LoggerFactory.getLogger(XyzAreaMngOrgSvcImpl.class);

	/**
	 * @mbg.generated 自动生成，如需修改，请删除本行
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public int add(XyzAreaMngOrgMo mo) {
		_log.info("添加区域管理组织关系");
		// 如果id为空那么自动生成分布式id
		if (mo.getId() == null || mo.getId() == 0) {
			mo.setId(_idWorker.getId());
		}
		return super.add(mo);
	}
	
	
	@Resource
	private SucOrgSvc sucOrgSvc;

	/**
	 * * 根据区域id获取已经添加和未添加的组织
	 */
	@Override
	public SucOrgInOrNotInRo listAddedAndUnaddedOrgs(Long areaId, Integer pageSize, String addedKeys, Integer addedPageNum,
			String unaddedKeys, Integer unaddedPageNum) {
		SucOrgInOrNotInRo result=new SucOrgInOrNotInRo();
		// 先获取已经添加了那些组织，再根据已经添加的组织，然后分别去查询已经添加的组织和未添加的组织的信息。
		XyzAreaMngOrgMo xyzAreaMngOrgMo = new XyzAreaMngOrgMo();
		xyzAreaMngOrgMo.setAreaId(areaId);
		_log.info("第一步根据区域id获取已经添加的组织的参数为: {}", xyzAreaMngOrgMo);
		List<XyzAreaMngOrgMo> areaMngOrgMoResult = super.list(xyzAreaMngOrgMo);
		_log.info("第一步根据区域id获取已经添加的组织的结果为: {}", areaMngOrgMoResult);
	
		//拼接的组织id
		String orgIds = "";
		if (areaMngOrgMoResult.size() != 0) {
			for (int i = 0; i < areaMngOrgMoResult.size(); i++) {
				if (i != 0 && i < areaMngOrgMoResult.size()) {
					orgIds += ",'" + areaMngOrgMoResult.get(i).getMngOrgId()+"'";
				} else {
					orgIds += "'" + areaMngOrgMoResult.get(i).getMngOrgId() +"'";
				}
			}
	        _log.info("查询未添加和已经添加的组织的参数为: {}", orgIds);
		}else {
			orgIds="0";
		}
		
		//获取已经添加的组织
		PageInfo<SucOrgMo> added=sucOrgSvc.listAddedOrgs(orgIds, addedKeys, addedPageNum, pageSize);
		_log.info("已经添加的组织: {}", added.getList());
		result.setAddedOrgs(added);
		PageInfo<SucOrgMo> unadded=sucOrgSvc.listUnaddedOrgs(orgIds, unaddedKeys, addedPageNum, pageSize);
		result.setUnaddedOrgs(unadded);
		_log.info("未添加的组织: {}", unadded.getList());
		
		return result;
	}

	@Override
	public PageInfo<SucOrgMo> listAddedOrgsByOrgIdsAndKeys(Long areaId, String keys, Integer pageNum, Integer pageSize) {
		
		// 先获取已经添加了那些组织，再根据已经添加的组织，然后分别去查询已经添加的组织和未添加的组织的信息。
		XyzAreaMngOrgMo xyzAreaMngOrgMo = new XyzAreaMngOrgMo();
		xyzAreaMngOrgMo.setAreaId(areaId);
		_log.info("第一步根据区域id获取已经添加的组织的参数为: {}", xyzAreaMngOrgMo);
		List<XyzAreaMngOrgMo> areaMngOrgMoResult = super.list(xyzAreaMngOrgMo);
		_log.info("第一步根据区域id获取已经添加的组织的结果为: {}", areaMngOrgMoResult);
	
		//拼接的组织id
		String orgIds = "";
		if (areaMngOrgMoResult.size() != 0) {
			for (int i = 0; i < areaMngOrgMoResult.size(); i++) {
				if (i != 0 && i < areaMngOrgMoResult.size()) {
					orgIds += ",'" + areaMngOrgMoResult.get(i).getMngOrgId()+"'";
				} else {
					orgIds += "'" + areaMngOrgMoResult.get(i).getMngOrgId() +"'";
				}
			}
	        _log.info("查询未添加和已经添加的组织的参数为: {}", orgIds);
		}else {
			orgIds="0";
		}
		
		//获取已经添加的组织
		PageInfo<SucOrgMo> added=sucOrgSvc.listAddedOrgs(orgIds, keys, pageNum, pageSize);
		_log.info("已经添加的组织: {}", added.getList());
		return added;
	}

	@Override
	public PageInfo<SucOrgMo> listUnaddedOrgsByOrgIdsAndKeys(Long areaId, String keys, Integer pageNum, Integer pageSize) {
		// 先获取已经添加了那些组织，再根据已经添加的组织，然后分别去查询已经添加的组织和未添加的组织的信息。
		XyzAreaMngOrgMo xyzAreaMngOrgMo = new XyzAreaMngOrgMo();
		xyzAreaMngOrgMo.setAreaId(areaId);
		_log.info("第一步根据区域id获取已经添加的组织的参数为: {}", xyzAreaMngOrgMo);
		List<XyzAreaMngOrgMo> areaMngOrgMoResult = super.list(xyzAreaMngOrgMo);
		_log.info("第一步根据区域id获取已经添加的组织的结果为: {}", areaMngOrgMoResult);
	
		//拼接的组织id
		String orgIds = "";
		if (areaMngOrgMoResult.size() != 0) {
			for (int i = 0; i < areaMngOrgMoResult.size(); i++) {
				if (i != 0 && i < areaMngOrgMoResult.size()) {
					orgIds += ",'" + areaMngOrgMoResult.get(i).getMngOrgId()+"'";
				} else {
					orgIds += "'" + areaMngOrgMoResult.get(i).getMngOrgId() +"'";
				}
			}
	        _log.info("查询未添加和已经添加的组织的参数为: {}", orgIds);
		}else {
			orgIds="0";
		}
		
		//获取已经添加的组织
		PageInfo<SucOrgMo> added=sucOrgSvc.listUnaddedOrgs(orgIds, keys, pageNum, pageSize);
		_log.info("已经添加的组织: {}", added.getList());
		return added;
	}
	
	

	@Override
	public int addOrgs(MoveOrgsTo to) {
		//批量添加组织
		int i=0;
		for (Long mngOrgId : to.getMoveIds()) {
			XyzAreaMngOrgMo mo=new XyzAreaMngOrgMo();
			
			//先将旧的区域组织关系去掉，再添加新的
			mo.setMngOrgId(mngOrgId);
			_log.info("先查询是否已经添加在别的区域参数:mo {}",mo);
			List<XyzAreaMngOrgMo> mngResult=super.list(mo);
			_log.info("先查询是否已经添加在别的区域结果:mo {}",mngResult);
			if(mngResult.size() !=0) {
				int result=super.del(mngResult.get(0).getId());
				_log.info("删除旧的关系结果-{}",result);
			}
			
			mo.setAreaId(to.getId());
			mo.setEntryTime(new Date());
			mo.setId(_idWorker.getId());
			_log.info("添加区域组织参数:mo {}",mo);
			i=super.add(mo);
		}
		return i;
	}

	@Override
	public int delOrgs(MoveOrgsTo to) {
		//批量删除组织
		int i=0;
		for (Long mngOrgId : to.getMoveIds()) {
			
			i=_mapper.delOrgs(to.getId(), mngOrgId);
		}
		
		return i;
	}
	
	
	
}
