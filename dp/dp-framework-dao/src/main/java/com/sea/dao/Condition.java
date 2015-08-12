package com.sea.dao;

public class Condition
{

	/**
	 * 条件key
	 */
	private Object key;

	/**
	 * 条件值
	 */
	private Object value;

	/**
	 * 操作类型
	 */
	private Operation operation;

	/**
	 * 连接类型
	 */
	private LinkType linkType;

	public Condition(String key, String value)
	{
		this(key, value, Operation.DENGYU);

	}

	public Condition(String key, String value, Operation operation)
	{
		this(key, value, operation, LinkType.AND);
	}

	public Condition(String key, String value, Operation operation, LinkType linkType)
	{
		this.key = key;
		this.value = value;
		this.operation = operation;
		this.linkType = linkType;
	}

	public Condition(String key, Integer value)
	{
		this(key, value, Operation.DENGYU);
	}

	public Condition(String key, Integer value, Operation operation)
	{
		this(key, value, operation, LinkType.AND);
	}

	public Condition(String key, Integer value, Operation operation, LinkType linkType)
	{
		this.key = key;
		this.value = value;
		this.operation = operation;
		this.linkType = linkType;
	}

	public Condition(String key, Long value)
	{
		this(key, value, Operation.DENGYU);
	}

	public Condition(String key, Long value, Operation operation)
	{
		this(key, value, operation, LinkType.AND);
	}

	public Condition(String key, Long value, Operation operation, LinkType linkType)
	{
		this.key = key;
		this.value = value;
		this.operation = operation;
		this.linkType = linkType;
	}

	public Object getKey()
	{
		return key;
	}

	public Object getValue()
	{
		return value;
	}

	public String getOperation()
	{
		return operation.getValue();
	}

	public LinkType getLinkType()
	{
		return linkType;
	}

	public static void main(String[] args)
	{
		Condition condition = new Condition("1", "2", Operation.LIKE);
		System.out.println(condition.getOperation());
	}

}
