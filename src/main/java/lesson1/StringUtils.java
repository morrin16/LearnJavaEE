package lesson1;

public final class StringUtils
{

public static final String EMPTY_STR = "";


private StringUtils()
{
}


public static boolean isEmpty(String str)
{
    return str == null || EMPTY_STR.equals(str);
}


public static boolean isNotEmpty(String str)
{
    return !isEmpty(str);
}


public static boolean isBlank(String str)
{
    return isEmpty(str) || EMPTY_STR.equals(str.trim());
}


public static boolean isNotBlank(String str)
{
    return !isBlank(str);
}


public static String capitalizeFirstLetter(String str)
{
    if (isBlank(str)) return str;
    
    Character firstChar = str.charAt(0);
    Character firstCapitalChar = Character.toUpperCase(firstChar);
    
    return firstCapitalChar + str.substring(1);
}

}
