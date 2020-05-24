package com.cloud.vm.cloud.vm.pve.data.storage;

import java.util.EnumSet;

import com.cloud.vm.cloud.vm.pve.data.Storage;
import org.json.JSONException;
import org.json.JSONObject;

import com.cloud.vm.cloud.vm.pve.BaseApi.PveParams;

public class Lvm extends Storage {
	private String vgname;
	private boolean saferemove;

	public Lvm(JSONObject data) throws JSONException {
		super(data);
		vgname = data.getString("vgname");
		saferemove = data.optInt("saferemove") == 1;
	}

	// for create
	public Lvm(String storage, EnumSet<Content> content, String nodes, boolean shared,
			boolean disable, String vgname) {
		super(storage, content, nodes, shared, disable);
		this.vgname = vgname;
	}

	// for update
	public Lvm(String storage, String digest, EnumSet<Content> content, String nodes,
			boolean shared, boolean disable) {
		super(storage, digest, content, nodes, shared, disable);
	}

	public String getVgname() {
		return vgname;
	}

	public boolean isSaferemove() {
		return saferemove;
	}

	public PveParams getCreateParams() {
		return super.getCreateParams().Add("type", "lvm").Add("vgname", vgname);
	}
}
