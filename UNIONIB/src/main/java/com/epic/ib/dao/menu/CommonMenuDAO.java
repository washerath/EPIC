package com.epic.ib.dao.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epic.ib.bean.menu.MenuItemBean;

/**
 * @author : Bilal AK
 * @Date Time : Mar 25, 2016:6:14:35 PM
 * @Class :CommonMenuDAO.java
 **/
@Repository
public class CommonMenuDAO {
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	JdbcTemplate jdbcTemplate;

	public Map<String, Object> getMenuSections() {
		String sql = "select ib_section.section_code,ib_section.description from ib_section where status ='ACT'";
		logger.info(sql);
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		Map<String, Object> map = new HashMap<String, Object>();
		if (list.size() != 0) {

//			logger.info("Following are the Menu Sections");

//			logger.info("Size of the Menu section list is:" + list.size());
			for (int i = 0; i < list.size(); i++) {
				map.put(list.get(i).get("SECTION_CODE") + "",
						list.get(i).get("DESCRIPTION"));
//				logger.info("Iteration key=" + list.get(i).get("SECTION_CODE")						+ ",value=" + list.get(i).get("DESCRIPTION"));

			}
		}
		return map;

	}

	/**
	 * All pages and sections: select
	 * ib_section.section_code,ib_section.description,ib_page.page_code,ib_page.
	 * description from ib_section,ib_page where ib_page.status ='ACT' and
	 * ib_section.section_code = ib_page.section_code
	 * 
	 * @param section
	 * @return
	 */
	public Map<String, List<MenuItemBean>> getPageBySection(
			Map<String, Object> sectionmap) {
		String sql = "select ib_page.section_code,ib_page.description,ib_page.URL from ib_page left outer join ib_section on ib_page.section_code=ib_section.section_code where ib_page.status ='ACT'";
		logger.info(sql);
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		Map<String, List<MenuItemBean>> map = new HashMap<String, List<MenuItemBean>>();
		Set<String> valueSet = sectionmap.keySet();
//		logger.info("The value set from the map:"+valueSet);
		/*
		 * Get the list		  
		 */
		List<MenuItemBean> menuList = new ArrayList<MenuItemBean>();
		if (list.size() != 0) {

			/**
			 * In this for-loop we add all the pages by section to
			 * List<MenuItemBean> menuList
			 */
			for (int i = 0; i < list.size(); i++) {
				MenuItemBean pageBean = new MenuItemBean(
						list.get(i).get("SECTION_CODE").toString(),
						list.get(i).get("DESCRIPTION").toString(),
						list.get(i).get("URL").toString());
				menuList.add(pageBean);				

			}
			int i = 0;
			/**
			 * in this enhanced loop we get the section code from the Map<String, Object> sectionmap
			 * object which is stored in the session. We iterate over the Set valueSet and
			 * create a List of pages for each section from List<MenuItemBean> menuList.
			 * Then we add the section code and a list of pages to the key of the 
			 * Map<String, List<MenuItemBean>> map.
			 */
			
			for (String menuSection : valueSet) {
				List<MenuItemBean> sectionList = new ArrayList<MenuItemBean>();
//				logger.info("In Section code:"+menuSection);
				
				for(int k=0;k<menuList.size();k++){		
//					logger.info("in the forloop"+menuList.get(k).getSectionCode());
					if (menuSection.equals(menuList.get(k).getSectionCode())) {
//						logger.info("Found section code matching list:"+menuList.get(k).getSectionCode());
						sectionList.add(menuList.get(k));					
					}			
						
				}			
				
				map.put(menuSection, sectionList);
//				logger.info("current menu item:"+map);
				i++;

			}

		}
		return map;

	}

}
