package com.epic.ib.bean.session;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.epic.ib.bean.menu.MenuItemBean;
import com.epic.ib.mapping.Ibmobuser;

/**
 * @author : Asitha Perera, Bilal AK
 * @Date Time : Mar 18, 2016:5:34:18 PM
 * @Class :SessionBean.java
 **/
public class SessionBean {
	private String username;

	private Ibmobuser ibmobuser;
	private Map<String, Object> favouritesMap;
	private Map<String, Object> menuSectionMap;
	private Map<String, List<MenuItemBean>> menuPagesMap;
	private String image;
	
	
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the menuPagesMap
	 */
	public Map<String, List<MenuItemBean>> getMenuPagesMap() {
		return menuPagesMap;
	}

	/**
	 * @param menuPagesMap the menuPagesMap to set
	 */
	public void setMenuPagesMap(Map<String, List<MenuItemBean>> menuPagesMap) {
		this.menuPagesMap = menuPagesMap;
	}

	/**
	 * @return the menuSectionMap
	 */
	public Map<String, Object> getMenuSectionMap() {
		return menuSectionMap;
	}

	/**
	 * @param menuSectionMap the menuSectionMap to set
	 */
	public void setMenuSectionMap(Map<String, Object> menuSectionMap) {
		this.menuSectionMap = menuSectionMap;
	}

	/**
	 * @return the favouritesMap
	 */
	public Map<String, Object> getFavouritesMap() {
		return favouritesMap;
	}

	/**
	 * @param favouritesMap the favouritesMap to set
	 */
	public void setFavouritesMap(Map<String, Object> favouritesMap) {
		this.favouritesMap = favouritesMap;
	}

	public Ibmobuser getIbmobuser() {
		return ibmobuser;
	}

	public void setIbmobuser(Ibmobuser ibmobuser) {
		this.ibmobuser = ibmobuser;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void logout(){		
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		
		
	}

}
