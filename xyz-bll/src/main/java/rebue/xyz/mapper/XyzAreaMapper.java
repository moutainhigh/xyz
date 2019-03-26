package rebue.xyz.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.robotech.mapper.MybatisBaseMapper;
import rebue.xyz.mo.XyzAreaMo;

@Mapper
public interface XyzAreaMapper extends MybatisBaseMapper<XyzAreaMo, Long> {
    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(XyzAreaMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(XyzAreaMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    XyzAreaMo selectByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(XyzAreaMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(XyzAreaMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<XyzAreaMo> selectAll();

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<XyzAreaMo> selectSelective(XyzAreaMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(XyzAreaMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(XyzAreaMo record);
}