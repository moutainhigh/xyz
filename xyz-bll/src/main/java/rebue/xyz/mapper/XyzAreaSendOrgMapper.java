package rebue.xyz.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.robotech.mapper.MybatisBaseMapper;
import rebue.xyz.mo.XyzAreaSendOrgMo;

@Mapper
public interface XyzAreaSendOrgMapper extends MybatisBaseMapper<XyzAreaSendOrgMo, Long> {
    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(XyzAreaSendOrgMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(XyzAreaSendOrgMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    XyzAreaSendOrgMo selectByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(XyzAreaSendOrgMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(XyzAreaSendOrgMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<XyzAreaSendOrgMo> selectAll();

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<XyzAreaSendOrgMo> selectSelective(XyzAreaSendOrgMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(XyzAreaSendOrgMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(XyzAreaSendOrgMo record);
}