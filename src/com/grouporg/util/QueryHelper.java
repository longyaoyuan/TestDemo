package com.grouporg.util;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * 查询助手工具类
 * @author Administrator
 *
 */
import java.util.List;
public class QueryHelper implements Serializable {

	private static final long serialVersionUID = 1L;
	private String fromClause="";//from子句
	private String whereClasue="";//where子句
	private String orderByClasue="";//order by子句
	
	private List<Object> parameter;//参数
	
	private static String ORDER_BY_DESC=null;//降序排列
	private static String ORDER_BY_ASC=null;//升序排列
	
	/**
	 * 构造from子句
	 * @param clazz 实体类名
	 * @param alias 别名
	 */
	public QueryHelper(Class clazz,String alias){
		fromClause="FROM"+clazz.getSimpleName()+" "+alias;
	}
	/**
	 * 构造where子句
	 * @param condition 查询条件
	 * @param params 查询条件对应的条件值
	 */
	public void addCondition(String condition,Object...params){
		if(whereClasue.length()>1){
			whereClasue+="AND"+condition;
		}else{
			whereClasue+="WHERE" +condition;
		}
		
		//设置查询条件到查询条件值集合中
		if(parameter==null){
			parameter=new ArrayList<Object>();
		}
		if(params!=null){
			for (Object param : params) {
				parameter.add(param);
			}
		}
	}
	/**
	 * 排序子句构造
	 * @param property 排序属性by time
	 * @param order排序ASC DESC
	 */
	public  void addOrderByProperty(String property,String order){
		if(orderByClasue.length()>1){
			orderByClasue+=","+property+" "+order;
		}
	}
	
	
	/**
	 * 查询HQL语句
	 * @return
	 */
	public String getQueryListHql(){
		return fromClause+whereClasue+orderByClasue;
	}
	
	
	/**
	 * 查询统计数语句
	 * @return
	 */
	public String getCountHql(){
		return "SELECT COUNT(*) "+fromClause+ whereClasue;
	}
	/**
	 * 查询条件中？对应的查询条件值集合
	 * @return
	 */
	public List<Object> getParameters(){
		return parameter;
	}
	
}
