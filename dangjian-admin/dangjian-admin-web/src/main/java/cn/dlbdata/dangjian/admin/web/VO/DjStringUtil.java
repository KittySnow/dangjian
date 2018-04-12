package cn.dlbdata.dangjian.admin.web.VO;

public class DjStringUtil {
    public static Integer[] changeStringToArray(String str){
        String arrs[] = str.split(",");
        Integer[] ints = new Integer[arrs.length];
        for(int i=0;i<arrs.length;i++){
            ints[i] = Integer.parseInt(arrs[i]);
        }
        return ints;
    }
}
