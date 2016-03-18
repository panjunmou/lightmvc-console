package com.pjm.lightmvc.vo.base;

/**
 * Vo基类
 */

public class BaseVo {

	protected Long id;

	private SessionInfo sessionInfo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SessionInfo getSessionInfo() {
		return sessionInfo;
	}

	public void setSessionInfo(SessionInfo sessionInfo) {
		this.sessionInfo = sessionInfo;
	}
}