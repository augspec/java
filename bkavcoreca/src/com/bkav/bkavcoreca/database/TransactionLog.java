package com.bkav.bkavcoreca.database;

import java.util.Date;

public class TransactionLog {
	private int id;
	private int userId;
	private Date tranTime;
	private String fileName;
	private long fileSize;
	private String fileType;
	private String fileSizeText;
	private String signedPath;
	private int status;

	public TransactionLog() {
	}

	public TransactionLog(int id, int userid, Date time, String fileName,
			long fileSize, String fileType, String signedPath, int status) {
		this.setId(id);
		this.setUserId(userid);
		this.setTranTime(time);
		this.setFileName(fileName);
		this.setFileSize(fileSize);
		this.setFileType(fileType);
		this.setSignedPath(signedPath);
		this.setStatus(status);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTranTime() {
		return tranTime;
	}

	public void setTranTime(Date tranTime) {
		this.tranTime = tranTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getSignedPath() {
		return signedPath;
	}

	public void setSignedPath(String signedPath) {
		this.signedPath = signedPath;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getFileSizeText() {
		return fileSizeText;
	}

	public void setFileSizeText(String fileSizeText) {
		this.fileSizeText = fileSizeText;
	}
}
