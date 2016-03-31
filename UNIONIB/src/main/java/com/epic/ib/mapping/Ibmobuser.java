package com.epic.ib.mapping;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Ibmobuser implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private long userid;

	private BigDecimal attempts;

	private String channel;

	private String cif;
	
	private String contactHome;
	
	private String contactMobile;
	
	private String contactOffice;

	private Date createdtime;

	private String email;

	private Object expirydate;

	private BigDecimal firstlogin;

	private String firstname;

	private String gender;
	
	private byte[] image;

	private Object lastlogindate;

	private String lastname;

	private Date lastupdatedtime;

	private String lastupdateduser;

	private String middlename;

	private String nic;

	private String password;

	private String permAddress;

	private String postalcode;

	private String remark;

	private String status;

	private String title;

	private String username;

	public Ibmobuser() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public BigDecimal getAttempts() {
		return this.attempts;
	}

	public void setAttempts(BigDecimal attempts) {
		this.attempts = attempts;
	}

	public String getCif() {
		return this.cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public Date getCreatedtime() {
		return this.createdtime;
	}

	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Object getExpirydate() {
		return this.expirydate;
	}

	public void setExpirydate(Object expirydate) {
		this.expirydate = expirydate;
	}

	public BigDecimal getFirstlogin() {
		return this.firstlogin;
	}

	public void setFirstlogin(BigDecimal firstlogin) {
		this.firstlogin = firstlogin;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Object getLastlogindate() {
		return this.lastlogindate;
	}

	public void setLastlogindate(Object lastlogindate) {
		this.lastlogindate = lastlogindate;
	}

	public Date getLastupdatedtime() {
		return this.lastupdatedtime;
	}

	public void setLastupdatedtime(Date lastupdatedtime) {
		this.lastupdatedtime = lastupdatedtime;
	}

	public String getLastupdateduser() {
		return this.lastupdateduser;
	}

	public void setLastupdateduser(String lastupdateduser) {
		this.lastupdateduser = lastupdateduser;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getChannel() {
		return this.channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	/**
	 * @return the contactHome
	 */
	public String getContactHome() {
		return contactHome;
	}

	/**
	 * @param contactHome the contactHome to set
	 */
	public void setContactHome(String contactHome) {
		this.contactHome = contactHome;
	}

	/**
	 * @return the contactMobile
	 */
	public String getContactMobile() {
		return contactMobile;
	}

	/**
	 * @param contactMobile the contactMobile to set
	 */
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	/**
	 * @return the contactOffice
	 */
	public String getContactOffice() {
		return contactOffice;
	}

	/**
	 * @param contactOffice the contactOffice to set
	 */
	public void setContactOffice(String contactOffice) {
		this.contactOffice = contactOffice;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the middlename
	 */
	public String getMiddlename() {
		return middlename;
	}

	/**
	 * @param middlename the middlename to set
	 */
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	/**
	 * @return the nic
	 */
	public String getNic() {
		return nic;
	}

	/**
	 * @param nic the nic to set
	 */
	public void setNic(String nic) {
		this.nic = nic;
	}

	/**
	 * @return the permAddress
	 */
	public String getPermAddress() {
		return permAddress;
	}

	/**
	 * @param permAddress the permAddress to set
	 */
	public void setPermAddress(String permAddress) {
		this.permAddress = permAddress;
	}

	/**
	 * @return the postalcode
	 */
	public String getPostalcode() {
		return postalcode;
	}

	/**
	 * @param postalcode the postalcode to set
	 */
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	



}