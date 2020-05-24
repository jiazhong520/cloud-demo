package com.cloud.vm.cloud.vm.pve;

public class Main {
    public static void main(String[] args)throws Exception {
        NewApi api = new NewApi("192.168.95.132","root","pam","12345678");
        api.login();
        api.cloneVm(100,103,"pve");
        String pve = api.startQemu("pve", 103);
        System.out.println(pve);
    }
}
