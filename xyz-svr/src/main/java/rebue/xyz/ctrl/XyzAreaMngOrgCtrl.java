package rebue.xyz.ctrl;

import com.github.pagehelper.PageInfo;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ro.IdRo;
import rebue.robotech.ro.Ro;
import rebue.suc.mo.SucOrgMo;
import rebue.suc.ro.SucOrgInOrNotInRo;
import rebue.xyz.mo.XyzAreaMngOrgMo;
import rebue.xyz.svc.XyzAreaMngOrgSvc;
import rebue.xyz.to.MoveOrgsTo;

/**
 * 区域管理组织关系
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@RestController
public class XyzAreaMngOrgCtrl {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final Logger _log = LoggerFactory.getLogger(XyzAreaMngOrgCtrl.class);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Resource
    private XyzAreaMngOrgSvc svc;

    /**
     * 有唯一约束的字段名称
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String _uniqueFilesName = "某字段内容";

    /**
     * 添加区域管理组织关系
     *
     */
    @PostMapping("/xyz/addOrgs")
    IdRo addOrgs(@RequestBody MoveOrgsTo mo) throws Exception {
        _log.info("add XyzAreaMngOrgMo: {}", mo);
        IdRo ro = new IdRo();
        try {
            int result = svc.addOrgs(mo);
            if (result == 1) {
                String msg = "添加成功";
                _log.info("{}: mo-{}", msg, mo);
                ro.setMsg(msg);
                ro.setResult(ResultDic.SUCCESS);
                return ro;
            } else {
                String msg = "添加失败";
                _log.error("{}: mo-{}", msg, mo);
                ro.setMsg(msg);
                ro.setResult(ResultDic.FAIL);
                return ro;
            }
        } catch (DuplicateKeyException e) {
            String msg = "添加失败，" + _uniqueFilesName + "已存在，不允许出现重复";
            _log.error(msg + ": mo-" + mo, e);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        } catch (RuntimeException e) {
            String msg = "添加失败，出现运行时异常";
            _log.error(msg + ": mo-" + mo, e);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        }
    }
    
    
    /**
     * 删除区域管理组织关系
     *

     */
    @PostMapping("/xyz/delOrgs")
    Ro delOrgs(@RequestBody MoveOrgsTo to) {
        _log.info("delOrgs: MoveOrgsTo {}", to);
        int result = svc.delOrgs(to);
        Ro ro = new Ro();
        if (result == 1) {
            String msg = "删除成功";
            ro.setMsg(msg);
            ro.setResult(ResultDic.SUCCESS);
            return ro;
        } else {
            String msg = "删除失败，找不到该记录";
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        }
    }

    /**
     * 修改区域管理组织关系
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @PutMapping("/xyz/areamngorg")
    Ro modify(@RequestBody XyzAreaMngOrgMo mo) throws Exception {
        _log.info("modify XyzAreaMngOrgMo: {}", mo);
        Ro ro = new Ro();
        try {
            if (svc.modify(mo) == 1) {
                String msg = "修改成功";
                _log.info("{}: mo-{}", msg, mo);
                ro.setMsg(msg);
                ro.setResult(ResultDic.SUCCESS);
                return ro;
            } else {
                String msg = "修改失败";
                _log.error("{}: mo-{}", msg, mo);
                ro.setMsg(msg);
                ro.setResult(ResultDic.FAIL);
                return ro;
            }
        } catch (DuplicateKeyException e) {
            String msg = "修改失败，" + _uniqueFilesName + "已存在，不允许出现重复";
            _log.error(msg + ": mo=" + mo, e);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        } catch (RuntimeException e) {
            String msg = "修改失败，出现运行时异常";
            _log.error(msg + ": mo-" + mo, e);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        }
    }

    /**
     * 删除区域管理组织关系
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @DeleteMapping("/xyz/areamngorg")
    Ro del(@RequestParam("id") java.lang.Long id) {
        _log.info("del XyzAreaMngOrgMo by id: {}", id);
        int result = svc.del(id);
        Ro ro = new Ro();
        if (result == 1) {
            String msg = "删除成功";
            _log.info("{}: id-{}", msg, id);
            ro.setMsg(msg);
            ro.setResult(ResultDic.SUCCESS);
            return ro;
        } else {
            String msg = "删除失败，找不到该记录";
            _log.error("{}: id-{}", msg, id);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        }
    }

    /**
     * 查询区域管理组织关系
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @GetMapping("/xyz/areamngorg")
    PageInfo<XyzAreaMngOrgMo> list(XyzAreaMngOrgMo mo, @RequestParam(value = "pageNum", required = false) Integer pageNum, @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        if (pageNum == null)
            pageNum = 1;
        if (pageSize == null)
            pageSize = 5;
        _log.info("list XyzAreaMngOrgMo:" + mo + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
        if (pageSize > 50) {
            String msg = "pageSize不能大于50";
            _log.error(msg);
            throw new IllegalArgumentException(msg);
        }
        PageInfo<XyzAreaMngOrgMo> result = svc.list(mo, pageNum, pageSize);
        _log.info("result: " + result);
        return result;
    }

    /**
     * 获取单个区域管理组织关系
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @GetMapping("/xyz/areamngorg/getbyid")
    XyzAreaMngOrgMo getById(@RequestParam("id") java.lang.Long id) {
        _log.info("get XyzAreaMngOrgMo by id: {}", id);
        return svc.getById(id);
    }
    
    
    /**
     * 查询指定区域的已添加和未添加的组织列表
     * 
     * @param id
     *            区域ID
     * @param pageNum
     *            第几页
     * @param pageSize
     *            每页大小
     */
    @GetMapping("/xyz/areamngorg/listaddedandunaddedorgs")
    SucOrgInOrNotInRo listAddedAndUnaddedOrgs(@RequestParam("id") Long id, @RequestParam(value = "pageNum", required = false) Integer pageNum,
            @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        if (pageNum == null)
            pageNum = 1;
        if (pageSize == null)
            pageSize = 7;
        _log.info("list id:" + id + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
        if (pageSize > 50) {
            String msg = "pageSize不能大于50";
            _log.error(msg);
            throw new IllegalArgumentException(msg);
        }
        return svc.listAddedAndUnaddedOrgs(id, null, null, null, null, null);
    }
    
    @GetMapping("/xyz/areamngorg/listUnaddedOrgs")
    PageInfo<SucOrgMo>  listUnaddedOrgs(@RequestParam("id") Long id, @RequestParam(value = "keys", required = false) String keys, @RequestParam(value = "pageNum", required = false) Integer pageNum,
            @RequestParam(value = "pageSize", required = false) Integer pageSize){
        _log.info("list id:" + id + ", keys = " + keys + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
        if (pageNum == null)
            pageNum = 1;
        if (pageSize == null)
            pageSize = 7;
        _log.info("list id:" + id + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
        if (pageSize > 50) {
            String msg = "pageSize不能大于50";
            _log.error(msg);
            throw new IllegalArgumentException(msg);
        }
        
        
    	return svc.listUnaddedOrgsByOrgIdsAndKeys(id,keys,pageNum,pageSize);
    }
    
    @GetMapping("/xyz/areamngorg/listAddedOrgs")
    PageInfo<SucOrgMo>  listAddedOrgs(@RequestParam("id") Long id, @RequestParam(value = "keys", required = false) String keys, @RequestParam(value = "pageNum", required = false) Integer pageNum,
            @RequestParam(value = "pageSize", required = false) Integer pageSize){
        _log.info("list id:" + id + ", keys = " + keys + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
        if (pageNum == null)
            pageNum = 1;
        if (pageSize == null)
            pageSize = 7;
        _log.info("list id:" + id + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
        if (pageSize > 50) {
            String msg = "pageSize不能大于50";
            _log.error(msg);
            throw new IllegalArgumentException(msg);
        }
        
        
    	return svc.listAddedOrgsByOrgIdsAndKeys(id,keys,pageNum,pageSize);
    }
    
}
