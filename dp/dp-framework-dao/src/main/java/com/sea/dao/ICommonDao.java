package com.sea.dao;

import java.util.List;
import java.util.Map;

/**
 * 直接使用sql
 * @note 如果能使用ibasedao 接口实现业务，请尽量使用ibasedao实现。
 * @author sea
 *
 */
public interface ICommonDao
{

	/**
	 * 通过执行sql返回数据
	 * @param sql
	 * @return
	 */
	public List<Map<String, Object>> findListBySql(String sql);
	
	
	/**
	 * 执行sql
	 * @param sql
	 */
	public void excuteSql(String sql);
	
	
}
