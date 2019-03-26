package rebue.xyz.svc.impl;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageInfo;
import rebue.kdi.svr.feign.KdiSvc;
import rebue.kdi.to.DeliverCountTo;
import rebue.robotech.svc.impl.BaseSvcImpl;
import rebue.suc.mo.SucOrgMo;
import rebue.suc.svr.feign.SucOrgSvc;
import rebue.xyz.dao.XyzAreaSendOrgDao;
import rebue.xyz.jo.XyzAreaSendOrgJo;
import rebue.xyz.mapper.XyzAreaSendOrgMapper;
import rebue.xyz.mo.XyzAreaMngOrgMo;
import rebue.xyz.mo.XyzAreaMo;
import rebue.xyz.mo.XyzAreaSendOrgMo;
import rebue.xyz.ro.AreaSendOrgRo;
import rebue.xyz.ro.SendOrgDeliverCountRo;
import rebue.xyz.svc.XyzAreaMngOrgSvc;
import rebue.xyz.svc.XyzAreaSendOrgSvc;
import rebue.xyz.svc.XyzAreaSvc;
import rebue.xyz.to.AreaSendOrgTo;

/**
 * 区域发货组织关系
 *
 * 在单独使用不带任何参数的 @Transactional 注释时，
 * propagation(传播模式)=REQUIRED，readOnly=false，
 * isolation(事务隔离级别)=READ_COMMITTED，
 * 而且事务不会针对受控异常（checked exception）回滚。
 *
 * 注意：
 * 一般是查询的数据库操作，默认设置readOnly=true, propagation=Propagation.SUPPORTS
 * 而涉及到增删改的数据库操作的方法，要设置 readOnly=false, propagation=Propagation.REQUIRED
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
@Service
public class XyzAreaSendOrgSvcImpl extends BaseSvcImpl<java.lang.Long, XyzAreaSendOrgJo, XyzAreaSendOrgDao, XyzAreaSendOrgMo, XyzAreaSendOrgMapper> implements XyzAreaSendOrgSvc {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final Logger _log = LoggerFactory.getLogger(XyzAreaSendOrgSvcImpl.class);

    /**

     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int add(XyzAreaSendOrgMo mo) {
        _log.info("添加区域发货组织关系");
        //先查询当前是否已经存在，如果存在就删除再插入
        XyzAreaSendOrgMo areaSendOrgMo=new XyzAreaSendOrgMo();
        areaSendOrgMo.setAreaId(mo.getAreaId());
        areaSendOrgMo.setSendOrgId(mo.getSendOrgId());
        _log.info("先查询当前记录是否已经存在参数-{}",areaSendOrgMo);
        List<XyzAreaSendOrgMo> SendOrgResult=super.list(areaSendOrgMo);
        _log.info("先查询当前记录是否已经存在结果-{}",SendOrgResult);
        if(SendOrgResult.size() !=0) {
        	super.del(SendOrgResult.get(0).getId());
        }
        
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId() == 0) {
            mo.setId(_idWorker.getId());
        }
        return super.add(mo);
    }
    
    @Resource
    private XyzAreaSvc xyzAreaSvc;
    
    @Resource
    private XyzAreaSendOrgSvc sendOrgSvc;
    
    @Resource
    private XyzAreaMngOrgSvc mngOrgSvc;
    
	@Resource
	private SucOrgSvc sucOrgSvc;
	
	
	@Resource
	private KdiSvc  kdiSvc;

	@Override
	public AreaSendOrgRo listAreaSendOrgs(AreaSendOrgTo to, Integer pageSize, Integer pageNum) {
		_log.info("根据条件获取区域下的发货组织信息 ： listAreaSendOrgs  AreaSendOrgTo- {},pageSize -{},pageNum-{}", to, pageSize,
				pageNum);
		AreaSendOrgRo areaSendOrgRo=new AreaSendOrgRo();
		List<SendOrgDeliverCountRo> sendOrgResult=new ArrayList<>();
		
		// 查询管理组织所在的区域
		XyzAreaMngOrgMo sendMo = new XyzAreaMngOrgMo();
		sendMo.setMngOrgId(to.getOrgId());
		_log.info("查询组织区域的参数为sendMo-{}", sendMo);
		List<XyzAreaMngOrgMo> mngResult = mngOrgSvc.list(sendMo);
		_log.info("查询组织区域的结果为sendResult-{}", mngResult);
		if (mngResult.size() == 0) {
			return new AreaSendOrgRo();
		}
		
		//获取区域名称
		_log.info("获取区域名称参数为-{}", mngResult.get(0).getAreaId());
		XyzAreaMo areaMo=xyzAreaSvc.getById(mngResult.get(0).getAreaId());
		_log.info("获取区域名称结果为-{}", areaMo);
		areaSendOrgRo.setAreaName(areaMo.getAreaName());
		areaSendOrgRo.setAreaId(mngResult.get(0).getAreaId());
		
		// 获取区域下的发货组织
		XyzAreaSendOrgMo areaSendMo = new XyzAreaSendOrgMo();
		areaSendMo.setAreaId(mngResult.get(0).getAreaId());
		_log.info("查询区域下的发货组织参数为areaSendMo-{}", areaSendMo);
		List<XyzAreaSendOrgMo> areaSendResult = sendOrgSvc.list(areaSendMo);
		_log.info("查询区域下的发货组织结果为areaSendResult-{}", areaSendResult);
		
		//获取该区域下的发货数量总数
		ArrayList<Long> AllorgId= new ArrayList<Long>();
		for (XyzAreaSendOrgMo xyzAreaSendOrgMo : areaSendResult) {
			AllorgId.add(xyzAreaSendOrgMo.getSendOrgId());
		}
		DeliverCountTo allDeliverCountTo=new DeliverCountTo();
		allDeliverCountTo.setOrgIds(AllorgId);
		allDeliverCountTo.setLogisticStatus(to.getLogisticStatus());
		allDeliverCountTo.setOrderTimeStart(to.getOrderTimeStart());
		allDeliverCountTo.setOrderTimeEnd(to.getOrderTimeEnd());
		_log.info("查询该区域下所有组织发货量总数参数为：{}",allDeliverCountTo);
		Long allDeliverCount=kdiSvc.getDeliverCount(allDeliverCountTo);
		_log.info("查询该区域下所有组织发货量总数结果为：{}",allDeliverCount);
		areaSendOrgRo.setAllCount(allDeliverCount);
		
		//分页去查询组织名称
		//拼接的组织id,切记在sql中的in()里面要写成in(${valueName})而不是in(#{valueName})
		String orgIds = "";
		if (areaSendResult.size() != 0) {
			for (int i = 0; i < areaSendResult.size(); i++) {
				if (i != 0 && i < areaSendResult.size()) {
					orgIds += ",'" + areaSendResult.get(i).getSendOrgId()+"'";
				} else {
					orgIds += "'" + areaSendResult.get(i).getSendOrgId() +"'";
				}
			}
	        _log.info("查询未添加和已经添加的组织的参数为: {}", orgIds);
		}else {
			orgIds="0";
		}
		
		//获取已经添加的组织
		PageInfo<SucOrgMo> added=sucOrgSvc.listAddedOrgs(orgIds, to.getOrgName(), pageNum, pageSize);
		_log.info("已经添加的组织: {}", added.getList());
		
		//设置区域和页数
		areaSendOrgRo.setPageNum(added.getPageNum());
		areaSendOrgRo.setPageSize(added.getPageSize());
		areaSendOrgRo.setTotal(added.getTotal());

		//获取物流订单
		for (SucOrgMo sucOrgMo : added.getList()) {
			_log.info("查询组织发货量循环开始-------------------------------------------");
			SendOrgDeliverCountRo sendOrg=new SendOrgDeliverCountRo();
			ArrayList<Long> orgId= new ArrayList<Long>();
			orgId.add(sucOrgMo.getId());
			DeliverCountTo deliverCountTo=new DeliverCountTo();
			deliverCountTo.setOrgIds(orgId);
			deliverCountTo.setLogisticStatus(to.getLogisticStatus());
			deliverCountTo.setOrderTimeStart(to.getOrderTimeStart());
			deliverCountTo.setOrderTimeEnd(to.getOrderTimeEnd());
			_log.info("查询组织发货量参数为：{}",deliverCountTo);
			Long DeliverCount=kdiSvc.getDeliverCount(deliverCountTo);
			_log.info("查询组织发货量结果为：{}",DeliverCount);
			
			//设置发货组织id以便页面删除记录
			for (XyzAreaSendOrgMo xyzAreaSendOrgMo : areaSendResult) {
				if(xyzAreaSendOrgMo.getSendOrgId().equals(sucOrgMo.getId())) {
					sendOrg.setId(xyzAreaSendOrgMo.getId());
				}
			}
			sendOrg.setCount(DeliverCount);
			sendOrg.setOrgName(sucOrgMo.getName());
			_log.info("当前组织的数据：{}",sendOrg);
			sendOrgResult.add(sendOrg);
			_log.info("查询组织发货量循环结束++++++++++++++++++++++++++++++++++++++++++++++++");

		}
		areaSendOrgRo.setSendOrg(sendOrgResult);
		_log.info("返回值areaSendOrgRo：{}",areaSendOrgRo);
		_log.info("返回值areaSendOrgRo.getSendOrg()：{}",areaSendOrgRo.getSendOrg());

		return areaSendOrgRo;
		
	}


    
    
    
}
