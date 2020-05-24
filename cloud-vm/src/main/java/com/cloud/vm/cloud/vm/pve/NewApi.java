package com.cloud.vm.cloud.vm.pve;

import org.json.JSONException;
import org.json.JSONObject;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Map;

public class NewApi  extends BaseApi {

    public NewApi(String pve_hostname, String pve_username, String pve_realm, String pve_password) {
        super(pve_hostname, pve_username, pve_realm, pve_password);
    }

    public boolean cloneVm(int vmId, int newVmId, String nodeName){
        try {
            PveParams params = new PveParams("newid", newVmId);
            JSONObject jObj = pve_action("/nodes/" + nodeName + "/qemu/"+vmId+"/clone", RestClient.RequestMethod.POST, params);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
