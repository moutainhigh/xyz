package rebue.xyz.ctrl;

import com.github.pagehelper.PageInfo;

import java.util.Date;

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
import rebue.xyz.mo.XyzAreaSendOrgMo;
import rebue.xyz.ro.AreaSendOrgRo;
import rebue.xyz.svc.XyzAreaSendOrgSvc;
import rebue.xyz.to.AreaSendOrgTo;

/**
 * 区域发货组织关系
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@RestController
public class XyzAreaSendOrgCtrl {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final Logger _log = LoggerFactory.getLogger(XyzAreaSendOrgCtrl.class);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Resource
    private XyzAreaSendOrgSvc svc;

    /**
     * 有唯一约束的字段名称
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String _uniqueFilesName = "某字段内容";

    /**
     * 添加区域发货组织关系
     * 添加录入时间
     */
    @PostMapping("/xyz/areasendorg")
    IdRo add(@RequestBody XyzAreaSendOrgMo mo) throws Exception {
        _log.info("add XyzAreaSendOrgMo: {}", mo);
        mo.setEntryTime(new Date());
        IdRo ro = new IdRo();
        try {
            int result = svc.add(mo);
            if (result == 1) {
                String msg = "添加成功";
                _log.info("{}: mo-{}", msg, mo);
                ro.setMsg(msg);
                ro.setResult(ResultDic.SUCCESS);
                ro.setId(mo.getId().toString());
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
     * 修改区域发货组织关系
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @PutMapping("/xyz/areasendorg")
    Ro modify(@RequestBody XyzAreaSendOrgMo mo) throws Exception {
        mo.setEntryTime(new Date());
        _log.info("modify XyzAreaSendOrgMo: {}", mo);
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
     * 删除区域发货组织关系
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @DeleteMapping("/xyz/areasendorg")
    Ro del(@RequestParam("id") java.lang.Long id) {
        _log.info("del XyzAreaSendOrgMo by id: {}", id);
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
     * 查询区域发货组织关系
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @GetMapping("/xyz/areasendorg")
    PageInfo<XyzAreaSendOrgMo> list(XyzAreaSendOrgMo mo, @RequestParam(value = "pageNum", required = false) Integer pageNum, @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        if (pageNum == null)
            pageNum = 1;
        if (pageSize == null)
            pageSize = 5;
        _log.info("list XyzAreaSendOrgMo:" + mo + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
        if (pageSize > 50) {
            String msg = "pageSize不能大于50";
            _log.error(msg);
            throw new IllegalArgumentException(msg);
        }
        PageInfo<XyzAreaSendOrgMo> result = svc.list(mo, pageNum, pageSize);
        _log.info("result: " + result);
        return result;
    }

    /**
     * 获取单个区域发货组织关系
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @GetMapping("/xyz/areasendorg/getbyid")
    XyzAreaSendOrgMo getById(@RequestParam("id") java.lang.Long id) {
        _log.info("get XyzAreaSendOrgMo by id: {}", id);
        return svc.getById(id);
    }
    
    @GetMapping("/xyz/areasendorg/listAreaSendOrgs")
    AreaSendOrgRo listAreaSendOrgs( AreaSendOrgTo to,@RequestParam(value = "pageNum", required = false) Integer pageNum, @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        _log.info("list listAreaSendOrgs:" + to + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
        return svc.listAreaSendOrgs(to, pageSize, pageNum);
    }
}
