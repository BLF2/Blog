package net.blf2.staticclass;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by blf2 on 16-2-1.
 * 日期格式化
 */
public class DateFormat {
    public String getCurrentDateTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(new Date());
    }
}
