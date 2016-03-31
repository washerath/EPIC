package com.epic.ib.dao.login;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

import com.epic.ib.mapping.Ibmobuser;

/**
 * @author : Bilal AK
 * @Date Time : Mar 22, 2016:11:45:12 AM
 * @Class :LoginDAO.java
 **/
@Repository
@Scope("prototype")
public class LoginDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	UserRowMapper userMapper;
	

	private final Log logger = LogFactory.getLog(getClass());
	/**
	 * Get User function
	 * 
	 * @param username
	 * @return boolean
	 */
	private String username;
	private String title;
	private String firstname;
	private String lastname;
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname
	 *            the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname
	 *            the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	private byte[] userImage;
	public byte[] getUserImage() {
		return userImage;
	}
	public void setUserImage(byte[] userImage) {
		this.userImage = userImage;
	}
	public boolean getUser(String username) {
		boolean loginVerify = false;

		try {
			System.out.println("in the try for username block");
			List<Map<String, Object>> map = jdbcTemplate.query(
					"select username,image,title,firstname,lastname from Ib_mob_user where username='"
							+ username + "'",
					new RowMapper<Map<String, Object>>() {
						public Map<String, Object> mapRow(ResultSet rs, int i)
								throws SQLException {
							Map<String, Object> results = new HashMap<String, Object>();
							String uname = rs.getString("username");
							String title = rs.getString("title");
							String firstname = rs.getString("firstname");
							String lastname = rs.getString("lastname");
							// byte[] blobBytes = lobHandler.getBlobAsBytes(rs,
							// "image");
							int blobLength=0;
							byte[] blobAsBytes=null;
							Blob blob=null;
							try{
							blob = rs.getBlob("image");
							logger.info("username inside:" + uname	+ "image length:" + blob.length());
							blobLength = (int) blob.length();
							blobAsBytes = blob.getBytes(1, blobLength);
						
							setUserImage(blobAsBytes);
							setTitle(title);
							setFirstname(firstname);
							setLastname(lastname);
							results.put("BLOB", blob);		
							}
							catch(Exception e){
								logger.error("error"+e);
								setUserImage(null);
								setTitle(title);
								setFirstname(firstname);
								setLastname(lastname);
								results.put("BLOB", "");	
							}

												
							results.put("USER", uname);
							return results;
						}
					});
			if (map.size() != 0) {// User is there in the db...
				String user = map.get(0).get("USER").toString();
				logger.info("username:" + user);

				loginVerify = true;

			} else {
				System.out.println("User not in db!");
			}

		} catch (Exception e) {
			System.out.println("Error in loginDao:" + e.toString());
			loginVerify = false;
		}
		return loginVerify;
	}

	/**
	 * Get the user password from given username
	 * 
	 * @param username
	 * @param password
	 * @return boolean
	 */
	public boolean getUserPassword(String username, String password) {
		boolean loginVerify = false;

		String sql = "select username from Ib_mob_user where username= ? and password=?";
		logger.info(sql);

		try {
			logger.info("in the try for username block");
			List<Map<String, Object>> map = jdbcTemplate.queryForList(sql,
					username, password);
			if (map.size() != 0) {
				logger.info("password valid for user:"
						+ map.get(0).get("username"));
				loginVerify = true;

			} else {
				logger.info("Invalid password is entered.");
			}

		} catch (Exception e) {
			logger.error("Error in loginDao:" + e.toString());
			loginVerify = false;
		}
		return loginVerify;
	}

	/**
	 * This is the User class that would be saved in the session throughout.
	 * 
	 * @param username
	 * @param password
	 * @return Ibmobuser
	 */
	public Ibmobuser getUserProfile(String username, String password) {
		List<Ibmobuser> userList = new ArrayList<Ibmobuser>();

		String sql = "select * from Ib_mob_user where username= '" + username
				+ "' and password='" + password + "'";

		logger.info(sql + ":" + username + ":" + password);

		try {
			List<Map<String, Object>> map = jdbcTemplate.queryForList(sql);
			if (map.size() != 0) {
				logger.info(map.get(0).get("password"));
				userList = jdbcTemplate.query(sql, userMapper);
			} else {
				logger.info("User not in db!");
			}

		} catch (Exception e) {
			logger.error("Error in loginDao:" + e.toString());
		}
		return userList.get(0);
	}
}
