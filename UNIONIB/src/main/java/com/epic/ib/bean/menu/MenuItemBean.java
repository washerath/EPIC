package com.epic.ib.bean.menu;
/**
 * This Class sets the menu page items for the menu.
*@author : Bilal AK
*@Date Time : Mar 28, 2016:9:59:29 AM
*@Class :MenuItemBean.java
**/
public class MenuItemBean {
	
	private String description;
	private String pageURL;
	private String sectionCode;
	
	
	/**
	 * @return the sectionCode
	 */
	public String getSectionCode() {
		return sectionCode;
	}
	/**
	 * @param sectionCode the sectionCode to set
	 */
	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	/**
	 * @param description
	 * @param pageURL
	 * @param sectionCode
	 */
	public MenuItemBean(String sectionCode,String description, String pageURL) {
		super();
		this.description = description;
		this.pageURL = pageURL;
		this.sectionCode = sectionCode;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the pageURL
	 */
	public String getPageURL() {
		return pageURL;
	}
	/**
	 * @param pageURL the pageURL to set
	 */
	public void setPageURL(String pageURL) {
		this.pageURL = pageURL;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MenuItemBean [description=" + description + ", pageURL="
				+ pageURL + ", sectionCode=" + sectionCode + "]";
	}

	

}
