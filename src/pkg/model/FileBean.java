package pkg.model;

import java.sql.Blob;

public class FileBean {
	int fileId;
	int dirId;
	String filenm;
	Blob files;
	String description;
	String formatype;
	
	public FileBean(int fileId, int dirId, String filenm, Blob files, String description, String formatype) {
		super();
		this.fileId = fileId;
		this.dirId = dirId;
		this.filenm = filenm;
		this.files = files;
		this.description = description;
		this.formatype = formatype;
	}

	
	public FileBean() {}


	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public int getDirId() {
		return dirId;
	}

	public void setDirId(int dirId) {
		this.dirId = dirId;
	}

	public String getFilenm() {
		return filenm;
	}

	public void setFilenm(String filenm) {
		this.filenm = filenm;
	}

	public Blob getFiles() {
		return files;
	}

	public void setFiles(Blob files) {
		this.files = files;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFormatype() {
		return formatype;
	}

	public void setFormatype(String formatype) {
		this.formatype = formatype;
	}
	
	
}
