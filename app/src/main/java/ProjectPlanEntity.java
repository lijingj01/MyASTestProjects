import android.graphics.Region;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

///工作计划实体类
public class ProjectPlanEntity {

    //region 内部属性
    private int PlanId;
    private String PlanTitle;
    private String PlanContent;
    private Date BeginDate;
    private Date EndDate;
    //endregion

    //region 公开属性
    public void setPlanId(int id){
        PlanId = id;
    }
    public int getPlanId(){
        return PlanId;
    }

    public void setPlanTitle(String planTitle){
        PlanTitle =planTitle;
    }
    public String getPlanTitle(){
        return PlanTitle;
    }

    public String getPlanContent() {
        return PlanContent;
    }

    public void setPlanContent(String planContent) {
        PlanContent = planContent;
    }

    public Date getBeginDate() {
        return BeginDate;
    }

    public void setBeginDate(Date beginDate) {
        BeginDate = beginDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    //显示日期组合
    public String GetPublishDate(){
        Format f = new SimpleDateFormat("yyyy年MM月dd日");
        StringBuilder strText = new StringBuilder();

        strText.append(f.format(BeginDate) + "---" + f.format(EndDate));

        return  strText.toString();
    }
    //endregion
}
