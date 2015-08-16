package com.sea.dao;

import java.util.List;

/**
 * 
 * @author sea
 *
 * @param <T>
 * @param <ID>
 */
public interface IBaseDao<T, ID>
{

	/**
	 * 持久化实体
	 * 
	 * @param t
	 */
	public void save(T t);

	/**
	 * 根据id删除实体
	 * 
	 * @param id
	 */
	public void deleteById(ID id);

	/**
	 * 修改实体
	 * 
	 * @param t
	 */
	public void update(T t);

	/**
	 * 根据id获取实体信息
	 * 
	 * @param id
	 * @return
	 */
	public T getObject(ID id);

	/**
	 * 获取列表的记录条数
	 * 
	 * @param param
	 * @return 记录数
	 */
	public Integer getListCount(Condition condition);

	/**
	 * 
	 * @param conditions
	 * @return
	 */
	public Integer getListCount(List<Condition> conditions);

	/**
	 * 通过条件获取实体列表
	 * 
	 * @param condition
	 */
	public void findListByCondition(Condition condition);

	/**
	 * 通过条件获取实体列表
	 * 
	 * @param condition
	 * @param sort
	 */
	public void findListByCondition(Condition condition, Sort sort);

	/**
	 * 通过条件获取实体列表
	 * 
	 * @param conditions
	 * @return
	 */
	public List<T> findListByCondition(List<Condition> conditions);

	/**
	 * 通过条件获取实体列表
	 * 
	 * @param conditions
	 * @param sort
	 * @return
	 */
	public List<T> findListByCondition(List<Condition> conditions, Sort sort);

	/**
	 * 分页获取实体列表
	 * 
	 * @param conditions
	 * @param sort
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PageData<T> findListByPage(List<Condition> conditions, Sort sort, int pageNo, int pageSize);
	
	
	
	
	
	

	//////////////////////////////////////////////////////////////////////////////////////////////////////////

	// 粗力度的获取数据接口//

	/**
	 * 通过执行sql获取实体列表
	 * @note 如不是以上接口无法满足业务，尽量不要使用该接口，尽量使用以上方法实现
	 * @param sql
	 * @return
	 */
	public List<T> findListBySql(String whereSql);

	//////////////////////////////////////////////////////////////////////////////////////////////////////////

}
