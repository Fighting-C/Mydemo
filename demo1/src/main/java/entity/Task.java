package entity;

import java.io.Serializable;
import java.util.Date;

/**
 * task
 * @author 
 */
public class Task implements Serializable {
    private Integer taskId;

    private Integer proId;

    private Integer fromUserid;

    private String taskType;

    private Integer toUserid;

    private Date taskTime;

    private String taskStatu;

    public Integer getToUserid() {
        return toUserid;
    }

    public void setToUserid(Integer toUserid) {
        this.toUserid = toUserid;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", proId=" + proId +
                ", fromUserid=" + fromUserid +
                ", taskType='" + taskType + '\'' +
                ", toUserid=" + toUserid +
                ", taskTime=" + taskTime +
                ", taskStatu='" + taskStatu + '\'' +
                '}';
    }

    public Task() {
    }

    private static final long serialVersionUID = 1L;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Integer getFromUserid() {
        return fromUserid;
    }

    public void setFromUserid(Integer fromUserid) {
        this.fromUserid = fromUserid;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public Date getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(Date taskTime) {
        this.taskTime = taskTime;
    }

    public String getTaskStatu() {
        return taskStatu;
    }

    public void setTaskStatu(String taskStatu) {
        this.taskStatu = taskStatu;
    }
}