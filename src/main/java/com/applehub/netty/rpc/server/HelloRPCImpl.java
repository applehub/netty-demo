package com.applehub.netty.rpc.server;

import com.applehub.netty.rpc.HelloRPC;

public class HelloRPCImpl implements HelloRPC {
    @Override
    public String hello(String name) {
        return "hello,"+name;
    }
}