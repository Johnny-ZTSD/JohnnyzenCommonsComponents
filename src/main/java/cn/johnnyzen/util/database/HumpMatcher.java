package cn.johnnyzen.util.database;

/**
 * [驼峰转换的匹配器]
 * + 原作者 https://blog.csdn.net/jiutianhe/article/details/40827899
 */
public class HumpMatcher implements Matcher {
    @Override
    public boolean match(String columnName, String propertyName) {
        if (columnName == null)
            return false;
        columnName = columnName.toLowerCase();
        String[] _ary = columnName.split("_");
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < _ary.length; i++) {
            String str = _ary[i];
            if (!"".equals(str) && i > 0) {
                StringBuilder _builder = new StringBuilder();
                str = _builder.append(str.substring(0, 1).toUpperCase())
                        .append(str.substring(1)).toString();
            }
            strBuilder.append(str);
        }
        return strBuilder.toString().equals(propertyName);
    }
}
