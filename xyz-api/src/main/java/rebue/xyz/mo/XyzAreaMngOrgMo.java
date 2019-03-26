package rebue.xyz.mo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
区域管理组织关系

数据库表: XYZ_AREA_MNG_ORG

@mbg.generated 自动生成的注释，如需修改本注释，请删除本行
*/
@JsonInclude(Include.NON_NULL)
public class XyzAreaMngOrgMo implements Serializable {
    /**
    区域组织关系ID
    
    数据库字段: XYZ_AREA_MNG_ORG.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long id;

    /**
    区域ID
    
    数据库字段: XYZ_AREA_MNG_ORG.AREA_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long areaId;

    /**
    管理组织ID
    
    数据库字段: XYZ_AREA_MNG_ORG.MNG_ORG_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long mngOrgId;

    /**
    录入时间
    
    数据库字段: XYZ_AREA_MNG_ORG.ENTRY_TIME
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date entryTime;

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
    区域组织关系ID
    
    数据库字段: XYZ_AREA_MNG_ORG.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getId() {
        return id;
    }

    /**
    区域组织关系ID
    
    数据库字段: XYZ_AREA_MNG_ORG.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setId(Long id) {
        this.id = id;
    }

    /**
    区域ID
    
    数据库字段: XYZ_AREA_MNG_ORG.AREA_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getAreaId() {
        return areaId;
    }

    /**
    区域ID
    
    数据库字段: XYZ_AREA_MNG_ORG.AREA_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    /**
    管理组织ID
    
    数据库字段: XYZ_AREA_MNG_ORG.MNG_ORG_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getMngOrgId() {
        return mngOrgId;
    }

    /**
    管理组织ID
    
    数据库字段: XYZ_AREA_MNG_ORG.MNG_ORG_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setMngOrgId(Long mngOrgId) {
        this.mngOrgId = mngOrgId;
    }

    /**
    录入时间
    
    数据库字段: XYZ_AREA_MNG_ORG.ENTRY_TIME
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Date getEntryTime() {
        return entryTime;
    }

    /**
    录入时间
    
    数据库字段: XYZ_AREA_MNG_ORG.ENTRY_TIME
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", areaId=").append(areaId);
        sb.append(", mngOrgId=").append(mngOrgId);
        sb.append(", entryTime=").append(entryTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        XyzAreaMngOrgMo other = (XyzAreaMngOrgMo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        ;
    }

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }
}