package com.cloud.vm.cloud.vm.pve.data;

import java.util.ArrayList;
import java.util.List;

import com.cloud.vm.cloud.vm.pve.data.resource.Pool;
import com.cloud.vm.cloud.vm.pve.data.resource.Vm;
import org.json.JSONException;
import org.json.JSONObject;

public class Resource {
	private String id;
	private Type type;

	public Resource(JSONObject data) throws JSONException {
		id = data.getString("id");
		type = convertType(data.getString("type"));
	}

	public String getId() {
		return id;
	}

	public Type getType() {
		return type;
	}

	public static Resource createResource(JSONObject data) throws JSONException {
		switch (convertType(data.getString("type"))) {
		case Pool:
			return new Pool(data);
		case VmQemu:
			return new Vm(data);
		case Node:

			return new Node(data);
		case Storage:
			return new Storage(data);
		default:
			return new Resource(data);
		}
	}

	public static List<Resource> getResourcesByType(List<Resource> src, Type type) {
		List<Resource> res = new ArrayList<Resource>();
		for (Resource r : src) {
			if (r.type == type)
				res.add(r);
		}
		return res;
	}

	public static Type convertType(String name) {
		if (name.equals("pool"))
			return Type.Pool;
		else if (name.equals("qemu"))
			return Type.VmQemu;
		else if (name.equals("node"))
			return Type.Node;
		else if (name.equals("storage"))
			return Type.Storage;
		else
			return Type.Unknown;
	}

	enum Type {
		Pool, VmQemu, Node, Storage, Unknown,
	}
}
