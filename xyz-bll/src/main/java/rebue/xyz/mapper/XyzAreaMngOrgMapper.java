package rebue.xyz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import rebue.robotech.mapper.MybatisBaseMapper;
import rebue.xyz.mo.XyzAreaMngOrgMo;

@Mapper
public interface XyzAreaMngOrgMapper extends MybatisBaseMapper<XyzAreaMngOrgMo, Long> {
    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(XyzAreaMngOrgMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(XyzAreaMngOrgMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    XyzAreaMngOrgMo selectByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(XyzAreaMngOrgMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(XyzAreaMngOrgMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<XyzAreaMngOrgMo> selectAll();

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<XyzAreaMngOrgMo> selectSelective(XyzAreaMngOrgMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(XyzAreaMngOrgMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(XyzAreaMngOrgMo record);
    

    @Delete("delete from  XYZ_AREA_MNG_ORG where AREA_ID=#{areaId,jdbcType=BIGINT} and MNG_ORG_ID =#{mngOrgId,jdbcType=BIGINT} ")
    int  delOrgs(@Param("areaId") Long areaId, @Param("mngOrgId") Long mngOrgId );
    		
}