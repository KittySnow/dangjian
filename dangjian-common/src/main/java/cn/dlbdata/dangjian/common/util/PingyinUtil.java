package cn.dlbdata.dangjian.common.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

public class PingyinUtil {
    private static Logger logger = LoggerFactory.getLogger(PingyinUtil.class);

    /**
     * 获取汉字串拼音首字母，英文字符不变
     *
     * @param chinese 汉字串
     * @return 汉语拼音首字母
     */
    public static String cn2FirstSpell(String chinese) {
        StringBuffer pingyinBuffer = new StringBuffer();
        char[] arr = chinese.toCharArray();

        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 128) {
                try {
                    String[] _t = PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat);
                    if (_t != null) {
                        pingyinBuffer.append(_t[0].charAt(0));
                    }
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    logger.error("Get FirstSpell error.", e);
                }
            } else {
                pingyinBuffer.append(arr[i]);
            }
        }

        return pingyinBuffer.toString().replaceAll("\\W", "").trim();
    }

    /**
     * 获取汉字串拼音，英文字符不变
     *
     * @param chinese 汉字串
     * @return 汉语拼音
     */
    public static String cn2Spell(String chinese) {
        StringBuffer pingyinBuffer = new StringBuffer();
        char[] arr = chinese.toCharArray();

        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 128) {
                try {
                    pingyinBuffer.append(PinyinHelper.toHanyuPinyinStringArray(arr[i], defaultFormat)[0]);
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    logger.error("Get Full Spell error.", e);
                }
            } else {
                pingyinBuffer.append(arr[i]);
            }
        }

        return pingyinBuffer.toString();
    }

    /**
     * 获取汉字串拼音，英文字符不变，去除字符中间空格
     *
     * @param chinese
     * @return
     */
    public static String cn2SpellNoBlank(String chinese) {
        return cn2Spell(chinese).replaceAll("\\W", "").trim();
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String x = "浦  迪";
        System.out.println(cn2FirstSpell(x));
        System.out.println(cn2SpellNoBlank(x));
        System.out.println(cn2Spell(x));
    }
}
