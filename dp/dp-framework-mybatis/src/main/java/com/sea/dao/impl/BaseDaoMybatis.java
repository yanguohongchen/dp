package com.sea.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.sea.dao.Condition;
import com.sea.dao.IBaseDao;
import com.sea.dao.PageData;
import com.sea.dao.Sort;

public class BaseDaoMybatis<T, ID> extends SqlSessionDaoSupport implements IBaseDao<T, ID>
{

	public static final String SQLNAME_SEPARATOR = ".";

	public static final String SQL_SAVE = "insertSelective";
	public static final String SQL_UPDATE = "updateByPrimaryKeySelective";
	public static final String SQL_GETBYID = "selectByPrimaryKey";
	public static final String SQL_DELETEBYID = "deleteByPrimaryKey";
	public static final String SQL_DELETEBYIDS = "deleteByIds";
	public static final String SQL_FINDPAGEBY = "findPageBy";
	public static final String SQL_FINDLISTBY = "findListBy";
	public static final String SQL_GETCOUNTBY = "getCountBy";

	/**
	 * mybatis支持多数据源。所以数据源需要自己注入
	 */
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory)
	{
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	/**
	 * 获取默认SqlMapping命名空间。 使用泛型参数中业务实体类型的全限定名作为默认的命名空间。
	 * 如果实际应用中需要特殊的命名空间，可由子类重写该方法实现自己的命名空间规则。
	 * 
	 * @return 返回命名空间字符串
	 */
	@SuppressWarnings("unchecked")
	protected String getDefaultSqlNamespace()
	{
		Class<T> clazz = ReflectGeneric.getInterfaceType(this.getClass());

		String nameSpace = clazz.getName();
		return nameSpace;
	}

	/**
	 * SqlMapping命名空间
	 */
	private String sqlNamespace = getDefaultSqlNamespace();

	/**
	 * 将SqlMapping命名空间与给定的SqlMapping名组合在一起。
	 * 
	 * @param sqlName
	 *            SqlMapping名
	 * @return 组合了SqlMapping命名空间后的完整SqlMapping名
	 */
	protected String getSqlName(String sqlName)
	{
		return sqlNamespace + SQLNAME_SEPARATOR + sqlName;
	}

	/**
	 * 获取SqlMapping命名空间
	 * 
	 * @return SqlMapping命名空间
	 */
	public String getSqlNamespace()
	{
		return sqlNamespace;
	}

	/**
	 * 设置SqlMapping命名空间。 此方法只用于注入SqlMapping命名空间，以改变默认的SqlMapping命名空间，
	 * 不能滥用此方法随意改变SqlMapping命名空间。
	 * 
	 * @param sqlNamespace
	 *            SqlMapping命名空间
	 */
	public void setSqlNamespace(String sqlNamespace)
	{
		this.sqlNamespace = sqlNamespace;
	}

	/**
	 * 生成主键值。 默认情况下什么也不做； 如果需要生成主键，需要由子类重写此方法根据需要的方式生成主键值。
	 * 
	 * @param ob
	 *            要持久化的对象
	 */
	protected void generateId(T ob)
	{

	}

	@Override
	public void save(T t)
	{
		generateId(t);
		this.getSqlSession().insert(getSqlName(SQL_SAVE), t);
	}

	@Override
	public void deleteById(ID id)
	{
		this.getSqlSession().delete(getSqlName(SQL_DELETEBYID), id);
	}

	@Override
	public void update(T t)
	{
		this.getSqlSession().update(getSqlName(SQL_UPDATE), t);

	}

	@SuppressWarnings("unchecked")
	@Override
	public T getObject(ID id)
	{
		return (T) this.getSqlSession().selectOne(getSqlName(SQL_GETBYID), id);
	}

	@Override
	public Integer getListCount(Condition condition)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getListCount(List<Condition> conditions)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void findListByCondition(Condition condition)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void findListByCondition(Condition condition, Sort sort)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public List<T> findListByCondition(List<Condition> conditions)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findListByCondition(List<Condition> conditions, Sort sort)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageData<T> findListByPage(List<Condition> conditions, Sort sort, int pageNo, int pageSize)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findListBySql(String whereSql)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
