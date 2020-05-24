package com.cloud.vm.cloud.vm.pve.data.resource;

import com.cloud.vm.cloud.vm.pve.data.Resource;
import org.json.JSONException;
import org.json.JSONObject;



public class Storage extends Resource {
	private String storage;
	private String node;
	private long maxdisk;
	private long disk;

	public Storage(JSONObject data) throws JSONException {
		super(data);
		storage = data.getString("storage");
		node = data.getString("node");
		disk = data.getLong("disk");
		maxdisk = data.getLong("maxdisk");
	}

	public String getStorage() {
		return storage;
	}

	public String getNode() {
		return node;
	}

	public long getMaxdisk() {
		return maxdisk;
	}

	public long getDisk() {
		return disk;
	}
}
