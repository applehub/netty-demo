package com.applehub.netty.rpc.server;

import com.applehub.netty.rpc.HelloNetty;

public class HelloNettyImpl implements HelloNetty {
    @Override
    public String hello() {
        return "hello,netty";
    }
}