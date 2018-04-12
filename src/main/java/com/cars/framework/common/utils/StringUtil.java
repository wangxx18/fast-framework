package com.cars.framework.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static final String ELLIPSIS = "..."; //省略号
    public static final String BLANK = ""; //空字符
    public static final String SPACE = " "; //空格

    /**
     * 
     * <p>功能描述:	截取输入空格</p>
     * @param str1
     * @return
     * @author:张然
     * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public static String getTrim(String str1) {
        if(str1 != null) {

            return str1.trim();
        }
        return null;
    }

    /**
     * 
     * <p>功能描述:	截取输入空格(数组)</p>
     * @param str1
     * @return
     * @author:张然
     * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public static void getTrims(String[] objs) {
        System.out.println(objs[0].trim());

        for(String str : objs) {
            if(str != null) {
                str = str.trim();
                System.out.println(str);
            }

        }
    }

    public static boolean isHaveChineseStr(String str) {
        if(str == null || "".equals(str)) {
            return false;
        }
        String regEx = "[\\u4e00-\\u9fa5]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        while (m.find()) {
            return true;
        }
        return false;
    }

    public static boolean contains(int subStr, String str) {
        if(str != null && !str.equals("")) {
            if(str.contains(",," + subStr + ",,")) {
                return true;
            }
        }
        return false;
    }

    public static String ellipsisStr(String str, int len) {
        return ellipsisStr(str, len, false);
    }

    /**
     * 将字符串截取为指定长度，如果超长，在尾部附加省略号
     * @param str	要截取的字符串
     * @param len	要保留的字符串的长度
     * @param nullToBlank	null对象是否转换为空字符串
     * @return		按要求截取后的字符串
     * 示例:	len = 6
      	null	==>	null 或者为空字符串
    	12345	==>	12345
    	123456	==>	123456
    	1234567	==>	123456...
    	中华人民共	==>	中华人民共
    	中华人民共和	==>	中华人民共和
    	中华人民共和国	==>	中华人民共和...
     */
    public static String ellipsisStr(String str, int len, boolean nullToBlank) {
        if(str == null) if(nullToBlank) return BLANK;
        else return str;
        if(str.length() <= len) return str;
        else return str.substring(0, len) + ELLIPSIS;
    }

    /**
     * 判断给定字符串是否为空 或者为空字符串
     * @param str
     * @return true表示空， false表示不为空
     */
    public static boolean isEmpty(String str) {
        return (str == null || "".equals(str) || "null".equals(str) || "(null)".equals(str));
    }

    /**
     * 判断给定字符串是否不为空 或者不为空字符串
     * @param str
     * @return fasle表示空， true表示不为空
     */
    public static boolean isNotEmpty(String str) {
        return (str != null && !"".equals(str) && !"null".equals(str) && !"(null)".equals(str));
    }

    /**
     * 判断给定Long是否为空 或者为0
     * @param str
     * @return true表示空， false表示不为空
     */
    public static boolean isEmpty(Long str) {
        return (str == null || str.longValue() == 0);
    }

    /**
     * 判断给定Long是否不为空 或者不为0
     * @param str
     * @return fasle表示空， true表示不为空
     */
    public static boolean isNotEmpty(Long str) {
        return (str != null && str.longValue() != 0);
    }

    /**
     * 判断给定Integer是否为空 或者为0
     * @param str
     * @return true表示空， false表示不为空
     */
    public static boolean isEmpty(Integer str) {
        return (str == null || str.intValue() == 0);
    }

    /**
     * 判断给定Integer是否不为空 或者不为0
     * @param str
     * @return fasle表示空， true表示不为空
     */
    public static boolean isNotEmpty(Integer str) {
        return (str != null && str.intValue() != 0);
    }
    
    /**
	 * 判断字符串对象与给定值是否相等
	 * 都为空表示相等
	 * @param StringObject 字符串对象
	 * @param value 给定值
	 * @return 相等返回true，不相等返回false
	 */
	public static boolean isEqualString(String StringObject, String value) {
		if ((StringObject==null && value==null)||(isNotEmpty(StringObject) && StringObject.equals(value) ))
			return true;
		return false;
	}
    
    public static String toJavaScriptStyle(String str) {
        if(str == null || "".equals(str)) return "";
        int strLen = str.length();
        StringBuffer sb = new StringBuffer();
        boolean lastCharIsCR = false;
        for(int i = 0; i < strLen; i++) {
            switch(str.charAt(i)) {
                case '\\':
                    sb.append("\\\\");
                    break;
                case '"':
                    sb.append('\\').append('"');
                    break;
                case '\n':
                    sb.append("\\").append('n').append("\\").append('r');
                    break;
                case '\r':
                    lastCharIsCR = true;
                    break;
                default:
                    if(lastCharIsCR) {
                        sb.append("\\").append('n').append("\\").append('r');
                        lastCharIsCR = false;
                        sb.append(str.charAt(i));
                    } else {
                        sb.append(str.charAt(i));
                    }
            }
        }
        return sb.toString();
//        return str.replaceAll("\\\\", "\\\\\\\\").replaceAll("\"", "\\\"").replaceAll("\n\r", "\\\\\\\\n\\\\\\\\r");

    }

    public static void main(String[] args) {
        String[] s = { "  a", "  b", "  c" };
        StringUtil.getTrims(s);
        System.out.println(StringUtil.ellipsisStr(null, 6)); //null
        System.out.println(StringUtil.ellipsisStr("12345", 6)); //12345
        System.out.println(StringUtil.ellipsisStr("123456", 6)); //123456
        System.out.println(StringUtil.ellipsisStr("1234567", 6));  //123456...
        System.out.println(StringUtil.ellipsisStr("中华人民共", 6));  //中华人民共
        System.out.println(StringUtil.ellipsisStr("中华人民共和", 6)); //中华人民共和
        System.out.println(StringUtil.ellipsisStr("中华人民共和国", 6)); //中华人民共和...

        System.out.println(StringUtil.toJavaScriptStyle("\"\\sd\n\rfgf")); //中华人民共和...
        //System.out.println(s[0]);
    }

}
