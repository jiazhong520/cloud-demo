package com.cloud.vm.cloud.vm.pve.data.storage;




import com.cloud.vm.cloud.vm.pve.data.Storage;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.EnumSet;
import com.cloud.vm.cloud.vm.pve.BaseApi.PveParams;

public class Dir extends Storage {
	private String path;
	int maxfiles;

	public Dir(JSONObject data) throws JSONException {
		super(data);
		path = data.getString("path");
		maxfiles = data.getInt("maxfiles");
	}

	// for create
	public Dir(String storage, EnumSet<Content> content, String nodes, boolean shared,
			   boolean disable, String path, int maxfiles) {
		super(storage, content, nodes, shared, disable);
		this.path = path;
		this.maxfiles = maxfiles;
	}

	// for update
	public Dir(String storage, String digest, EnumSet<Content> content, String nodes,
			boolean shared, boolean disable, int maxfiles) {
		super(storage, digest, content, nodes, shared, disable);
		this.maxfiles = maxfiles;
	}

	public String getPath() {
		return path;
	}

	public int getMaxfiles() {
		return maxfiles;
	}

	public PveParams getCreateParams() {
		return super.getCreateParams().Add("type", "dir").Add("path", path).Add("maxfiles", maxfiles);
	}

	public PveParams getUpdateParams() {
		return super.getUpdateParams().Add("maxfiles", maxfiles);
	}
}
