package com.cloud.vm.cloud.vm.pve.data.resource;

import com.cloud.vm.cloud.vm.pve.data.Resource;
import org.json.JSONException;
import org.json.JSONObject;



public class Pool extends Resource {
	private String pool;
	private int maxcpu;
	private long maxmem;
	private int uptime;
	private float cpu;
	private long mem;

	public Pool(JSONObject data) throws JSONException {
		super(data);
		pool = data.getString("pool");
		maxcpu = data.getInt("maxcpu");
		maxmem = data.getLong("maxmem");
		uptime = data.optInt("uptime");
		cpu = (float) data.optDouble("cpu");
		mem = data.optLong("mem");
	}

	public String getPool() {
		return pool;
	}

	public int getMaxcpu() {
		return maxcpu;
	}

	public long getMaxmem() {
		return maxmem;
	}

	public int getUptime() {
		return uptime;
	}

	public float getCpu() {
		return cpu;
	}

	public long getMem() {
		return mem;
	}
}
