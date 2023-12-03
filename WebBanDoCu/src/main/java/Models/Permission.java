package Models;

import java.io.Serializable;

public class Permission implements Serializable{
	private static final long serialVersionUID = 1L;
	private int permission_id;
	private String  permission_name;
	public Permission() {
		super();
	}
	public Permission(int permission_id, String permission_name) {
		super();
		this.permission_id = permission_id;
		this.permission_name = permission_name;
	}
	@Override
	public String toString() {
		return "Permission [permission_id=" + permission_id + ", permission_name=" + permission_name + "]";
	}
	public int getPermission_id() {
		return permission_id;
	}
	public void setPermission_id(int permission_id) {
		this.permission_id = permission_id;
	}
	public String getPermission_name() {
		return permission_name;
	}
	public void setPermission_name(String permission_name) {
		this.permission_name = permission_name;
	}

}
