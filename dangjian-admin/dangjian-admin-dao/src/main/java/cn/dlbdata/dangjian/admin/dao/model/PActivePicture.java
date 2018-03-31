package cn.dlbdata.dangjian.admin.dao.model;

import java.io.Serializable;

public class PActivePicture implements Serializable {
    /**
     * 活动图片集合ID
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 图片ID
     *
     * @mbg.generated
     */
    private Integer pictureId;

    /**
     * 活动ID
     *
     * @mbg.generated
     */
    private Integer activeId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public Integer getActiveId() {
        return activeId;
    }

    public void setActiveId(Integer activeId) {
        this.activeId = activeId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pictureId=").append(pictureId);
        sb.append(", activeId=").append(activeId);
        sb.append("]");
        return sb.toString();
    }

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
        PActivePicture other = (PActivePicture) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPictureId() == null ? other.getPictureId() == null : this.getPictureId().equals(other.getPictureId()))
            && (this.getActiveId() == null ? other.getActiveId() == null : this.getActiveId().equals(other.getActiveId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPictureId() == null) ? 0 : getPictureId().hashCode());
        result = prime * result + ((getActiveId() == null) ? 0 : getActiveId().hashCode());
        return result;
    }
}