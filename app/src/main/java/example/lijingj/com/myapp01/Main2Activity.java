package example.lijingj.com.myapp01;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TableLayout myTable = (TableLayout)findViewById(R.id.myTable);

//        for (int i = 0; i < 10; i++) {
            //创建一行
            TableRow row = new TableRow(getApplicationContext());

            //创建显示的内容,这里创建的是一列
            TextView text = new TextView(getApplicationContext());

            //设置显示内容
            text.setText("日期");

            text.setTextColor(Color.RED); //字体颜色
            text.setBackgroundColor(Color.YELLOW); //背景色
            text.setTextSize(20); //字体大小
            text.setGravity(Gravity.CENTER); //居中显示


            //添加到Row
            row.addView(text);

        Format f = new SimpleDateFormat("MM-dd");
        Calendar cal = Calendar.getInstance();
            int iYear =  cal.get(Calendar.YEAR);
            int iMonth =cal.get(Calendar.MONTH) + 1;
            Date FirstDay = getWeekStartDay();
            //当前月份的最大天数
//            int iMaxDay = cal.getActualMaximum(Calendar.DAY_OF_WEEK);
            for(int iDay = 0; iDay< 7; iDay++){

                //region 添加标题卡片
                CardView card = new CardView(Main2Activity.this);
                card.setRadius(10);
                card.setCardBackgroundColor(Color.YELLOW);
                card.setContentPadding(10,3,10,3);

                TextView textTitle = new TextView(getApplicationContext());
                //设置日期表头
                textTitle.setText(f.format(FirstDay));
                textTitle.setTextColor(Color.BLACK); //字体颜色
                textTitle.setBackgroundColor(Color.YELLOW); //背景色
                textTitle.setTextSize(15); //字体大小
                textTitle.setGravity(Gravity.CENTER); //居中显示
                textTitle.setPadding(10, 3, 10, 3);

                card.addView(textTitle);
                //endregion

                row.addView(card);

                //日期更新
                Calendar cTemp = Calendar.getInstance();
                cTemp.setTime(FirstDay);
                cTemp.add(Calendar.DAY_OF_MONTH,1);
                FirstDay = cTemp.getTime();
            }



            LinearLayout.LayoutParams lp = new TableRow.LayoutParams(-2,-2);
            lp.setMargins(1,1,1,1);
            row.setLayoutParams(lp);

            //将一行数据添加到表格中
            myTable.addView(row);
//        }
    }

    public Date getWeekStartDay() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date dt = cal.getTime();
        return dt;
    }
}
