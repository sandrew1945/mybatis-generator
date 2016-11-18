/**********************************************************************
* <pre>
* FILE : TableUtil.java
* CLASS : TableUtil
*
* AUTHOR : Administrator
*
* FUNCTION : TODO
*
*
*======================================================================
* CHANGE HISTORY LOG
*----------------------------------------------------------------------
* MOD. NO.| DATE | NAME | REASON | CHANGE REQ.
*----------------------------------------------------------------------
* 		  |2016年11月17日| Administrator| Created |
* DESCRIPTION:
* </pre>
***********************************************************************/
/**
* $Id: TableUtil.java,v 0.1 2016年11月17日 下午2:42:04 Administrator Exp $
*/

package org.mybatis.generator.internal.util;

/**
 * Function    : add by weibin PO类名与表名转换工具类
 * @author     : Administrator
 * CreateDate  : 2016年11月17日
 * @version    :
 */
public class TableUtil
{
	final static String PO_SUFFIX = "PO";

	/**
	 *  
	 * Function    : 根据表名生成PO类名
	 * LastUpdate  : 2010-4-30
	 * @param tableName
	 * @return
	 */
	public static String getPONameByTableName(String tableName)
	{
		// 将表名变为小写
		tableName = tableName.toLowerCase();
		// 按"_"分割,然后首字母大写
		String[] parts = tableName.split("_");
		StringBuilder PO = new StringBuilder();
		for (int i = 0; i < parts.length; i++)
		{
			String temp = toUpCaseOfInitial(parts[i]);
			PO.append(temp);
		}
		PO.append("PO");
		return PO.toString();
	}

	/**
	 * 
	 * Function    : 根据PO类名(不包含包名)解析表名
	 * Example	   : TmVehiclePO 解析后为 tm_vehicle
	 * LastUpdate  : 2010-8-30
	 * @param poName
	 * @return
	 */
	public static String getTabNameByPOName(String poName)
	{
		// 先去掉PO后缀
		if (poName.contains(PO_SUFFIX))
		{
			poName = poName.substring(0, poName.length() - PO_SUFFIX.length());
		}
		// 遍历poName, 如果遇到大写字母前加"_"
		StringBuilder sB = new StringBuilder();
		for (int i = 0; i < poName.length(); i++)
		{
			char c = poName.charAt(i);
			if (c >= 'A' && c <= 'Z' && i != 0)
			{
				sB.append('_');
			}
			sB.append(Character.toLowerCase(c));
		}
		return sB.toString();
	}

	/**
	 * 
	 * Function    : 首字母大写(可能返回null,注意处理)
	 * LastUpdate  : 2010-4-20
	 * @param str
	 * @return
	 */
	public static String toUpCaseOfInitial(String str)
	{
		String retStr = null;
		if (null != str && !str.equals(""))
		{
			String initial = str.substring(0, 1);
			initial = initial.toUpperCase();
			retStr = initial + str.substring(1, str.length());
		}
		return retStr;
	}
}
