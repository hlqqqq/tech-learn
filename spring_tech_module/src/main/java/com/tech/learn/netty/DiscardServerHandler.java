package com.tech.learn.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.nio.ByteBuffer;

/**
 * Created by heliqing on 2017/7/18.
 */
public class DiscardServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx , Object msg){
        ((ByteBuf)msg).release();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx , Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }
}
