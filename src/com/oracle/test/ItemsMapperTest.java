package com.oracle.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oracle.mapper.ItemsMapper;
import com.oracle.po.Items;
import com.oracle.po.ItemsExample;

public class ItemsMapperTest {
	private ApplicationContext context;
	private ItemsMapper itemsMapper;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("bean2.xml");
		itemsMapper = (ItemsMapper) context.getBean("itemsMapper");
	}

	// 根据主键删除
	@Test
	public void testDeleteByPrimaryKey() {
		itemsMapper.deleteByPrimaryKey(3);
	}

	@Test
	public void testInsert() {
		Items items = new Items();
		items.setName("手机");
		items.setPrice(5888F);
		items.setDetail("iphone x");
		itemsMapper.insert(items);
	}

	// 自定义条件查询
	@Test
	public void testSelectByExample() {
		// 构造example对象
		ItemsExample itemsExample = new ItemsExample();
		// 通过criteria构造查询条件
		ItemsExample.Criteria criteria = itemsExample.createCriteria();
		criteria.andNameEqualTo("书");
		// 可能返回多条记录
		List<Items> list = itemsMapper.selectByExample(itemsExample);
		System.out.println(list.get(0).getName());
	}

	// 根据主键查询
	@Test
	public void testSelectByPrimaryKey() {
		Items items = itemsMapper.selectByPrimaryKey(1);
		System.out.println(items.getId() + "--" + items.getName());
	}

	// 更新数据
	@Test
	public void testUpdateByPrimaryKey() {
		Items items = itemsMapper.selectByPrimaryKey(2);
		items.setDetail("巧克力味的");
		// 更新所有字段
		itemsMapper.updateByPrimaryKey(items);
		// 只更新输入的字段不为空的字段，不需要查询，在批量生产里使用，构造有id的对象就可以更新
		// itemsMapper.updateByPrimaryKeySelective(items);
	}
}
