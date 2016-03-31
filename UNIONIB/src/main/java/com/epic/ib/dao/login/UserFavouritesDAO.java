package com.epic.ib.dao.login;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

/**
 * @author : Bilal AK
 * @Date Time : Mar 23, 2016:11:49:38 AM
 * @Class :ib_userfavouritesDAO.java
 **/
@Repository
public class UserFavouritesDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private byte[] userImage;
	
	
	/**
	 * @return the userImage
	 */
	public byte[] getUserImage() {
		return userImage;
	}

	/**
	 * @param userImage the userImage to set
	 */
	public void setUserImage(byte[] userImage) {
		this.userImage = userImage;
	}

	private final Log logger = LogFactory.getLog(getClass());

	public Map<String, Object> getUserFavourites(long id) {
		String sql = "select description,url from ib_page,ib_userfavourites where ib_userfavourites.userid="
				+ id
				+ " and ib_userfavourites.page_code=ib_page.page_code and ib_page.status='ACT'";
		logger.info(sql);
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		Map<String, Object> map = new HashMap<String, Object>();
		if (list.size() != 0) {

			logger.info("Following are the User Favourites..");

			logger.info("Size of the User Favourite list is:" + list.size());
			for (int i = 0; i < list.size(); i++) {
				map.put(list.get(i).get("URL") + "",
						list.get(i).get("DESCRIPTION"));
				logger.info("Iteration key=" + list.get(i).get("URL")
						+ ",value=" + list.get(i).get("DESCRIPTION"));

			}
		}
		return map;

	}
	
	
	/** This is to add image as blog in the database. Change the pic as necessary!
	 * 
	 */
	public void insertImage(){
		ClassLoader classLoader = getClass().getClassLoader();
		final InputStream image = this.getClass().getClassLoader().getResourceAsStream("img/user2-160x160.jpg");
		//File file = new File(classLoader.getResource("img/user2-160x160.jpg").getFile());
		//File file = new File("/resources/img/user2-160x160.jpg");
		logger.info("Successfully read the file");
		try {
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			int nRead;
			byte[] data = new byte[1024];
			while ((nRead = image.read(data, 0, data.length)) != -1) {
				  buffer.write(data, 0, nRead);
				}
			
			buffer.flush();
			byte[] bytes=buffer.toByteArray();			
		setUserImage(bytes);
			logger.info(byteArrayToImage(bytes));
			logger.info("the length of the image byte is:"+bytes.length);
		String sql="update Ib_mob_user set image=? where userid=1";
		
		 
//		jdbcTemplate.update(sql, new Object[] {		           
//		           new SqlLobValue(image, (int)bytes.length, lobHandler),
//		         },
//		         new int[] {Types.BLOB});
		jdbcTemplate.update(sql, new Object[]{new SqlLobValue(bytes)},new int[]{Types.BLOB});  
		
		image.close();
		buffer.close();
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static BufferedImage  byteArrayToImage(byte[] bytes){  
        BufferedImage bufferedImage=null;
        try {
            InputStream inputStream = new ByteArrayInputStream(bytes);
            bufferedImage = ImageIO.read(inputStream);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return bufferedImage;
}
}
