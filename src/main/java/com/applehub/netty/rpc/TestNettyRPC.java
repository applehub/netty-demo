package com.applehub.netty.rpc;

import com.applehub.netty.rpc.client.NettyRPCProxy;

public class TestNettyRPC {
    public static void main(String[] args) {
        // 1.第一次远程调用
        HelloNetty helloNetty = (HelloNetty) NettyRPCProxy.create(HelloNetty.class);
        System.out.println(helloNetty.hello());

        // 2. 第二次远程调用
        HelloRPC helloRPC = (HelloRPC)NettyRPCProxy.create(HelloRPC.class);
        System.out.println(helloRPC.hello("RPC"));
    }
}