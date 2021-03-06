package com.dianrong.common.uniauth.cas.model;

import java.io.Serializable;

/**
 * 会过期的session的model
 */
public class ExpiredSessionObj<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = -5592978188308898593L;

	/**
	 * . 时间戳
	 */
	private long startMilles;

	/**
	 * . 存活时间milles
	 */
	private long lifeMilles;

	/**
	 * . 内容
	 */
	private  T content;

	/**
	 * . 构造函数
	 * 
	 * @param content
	 */
	public ExpiredSessionObj(T content, long lifeMilles) {
		this.content = content;
		this.startMilles = System.currentTimeMillis();
		this.lifeMilles = lifeMilles < 0 ? 0 : lifeMilles;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	/**
	 * . 判断当前对象是否已过期
	 * 
	 * @param expireMilles
	 * @return
	 */
	public boolean isExpired() {
		long nowMilles = System.currentTimeMillis();
		return nowMilles - startMilles > lifeMilles;
	}
	
	/**
	 *  build a new ExpiredSessionObj
	 * @param content the content
	 * @param lifeMilles  the content alive milliseconds
	 * @return a new ExpiredSessionObj
	 */
	public static <E extends Serializable> ExpiredSessionObj<E> build(E content, long lifeMilles) {
	    return new ExpiredSessionObj<E>(content, lifeMilles);
	}
}
