package com.epic.ib.mapping;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class Channel implements Serializable {
	private static final long serialVersionUID = 1L;


	private String channelcode;

	private Date createdtime;

	private String description;


	private Date lastupdatedtime;

	private String lastupdateduser;

	private String status;


	private List<Ibmobuser> ibmobusers;

	public Channel() {
	}

	public String getChannelcode() {
		return this.channelcode;
	}

	public void setChannelcode(String channelcode) {
		this.channelcode = channelcode;
	}

	public Date getCreatedtime() {
		return this.createdtime;
	}

	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Ibmobuser> getIbmobusers() {
		return this.ibmobusers;
	}

	public void setIbmobusers(List<Ibmobuser> ibmobusers) {
		this.ibmobusers = ibmobusers;
	}

//	public Ibmobuser addIbmobuser(Ibmobuser ibmobuser) {
//		getIbmobusers().add(ibmobuser);
//		ibmobuser.setChannelBean(this);
//
//		return ibmobuser;
//	}
//
//	public Ibmobuser removeIbmobuser(Ibmobuser ibmobuser) {
//		getIbmobusers().remove(ibmobuser);
//		ibmobuser.setChannel(null);
//
//		return ibmobuser;
//	}

}