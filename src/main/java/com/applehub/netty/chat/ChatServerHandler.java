package com.applehub.netty.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.ArrayList;
import java.util.List;

public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    public static List<Channel> channels = new ArrayList<>();

    // 通道就绪
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel inChannel = ctx.channel();
        channels.add(inChannel);
        System.out.println("[Server]:"+inChannel.remoteAddress().toString().substring(1)+"上线");
    }

    // 通道未就绪
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel inChannel = ctx.channel();
        channels.remove(inChannel);
        System.out.println("[Server]:"+inChannel.remoteAddress().toString().substring(1)+"离线");
    }

    // 读取数据
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        Channel inChannel = ctx.channel();
        for (Channel channel : channels) {
            if(channel!=inChannel){
                channel.writeAndFlush("["+inChannel.remoteAddress().toString().substring(1)+"]说： "+s+"\n");
            }
        }
    }
}