///**
// * 项目名称：hithere-center
// * 包名：com.cyou.hithere.center.util.netty.lession502
// * 文件名：EchoServer.java
// * 版本信息：V1.0
// * 日期：2015-10-27-上午10:53:01
// * 作者：Administrator
// * Copyright (c) 2015畅游天下-版权所有
// */
//
//package com.cyou.hithere.center.util.netty.lession502;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.ChannelFuture;
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelOption;
//import io.netty.channel.EventLoopGroup;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//import io.netty.handler.codec.FixedLengthFrameDecoder;
//import io.netty.handler.codec.string.StringDecoder;
//import io.netty.handler.logging.LogLevel;
//import io.netty.handler.logging.LoggingHandler;
//
//import com.cyou.hithere.center.util.netty.lession501.EchoServerHandler;
//
///**
// * 类名称：EchoServer
// * 类描述：(使用FixedLengthFrameDecoder解码，固定长度处理)
// * 
// * 创建人：Administrator
// * 创建时间：2015-10-27 上午10:53:01
// * 修改人：
// * 修改时间：2015-10-27 上午10:53:01
// * 修改备注：
// * 
// * @version 1.0.0
// */
//
//public class EchoServer {
//	public void bind(int port) throws Exception {
//		// 配置服务端的NIO线程组
//		EventLoopGroup bossGroup = new NioEventLoopGroup();
//		EventLoopGroup workerGroup = new NioEventLoopGroup();
//		try {
//			ServerBootstrap b = new ServerBootstrap();
//			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 100)
//					.handler(new LoggingHandler(LogLevel.INFO)).childHandler(new ChannelInitializer<SocketChannel>() {
//						@Override
//						public void initChannel(SocketChannel ch) throws Exception {
//							ch.pipeline().addLast(new FixedLengthFrameDecoder(20));
//							ch.pipeline().addLast(new StringDecoder());
//							ch.pipeline().addLast(new EchoServerHandler());
//						}
//					});
//			// 绑定端口，同步等待成功
//			ChannelFuture f = b.bind(port).sync();
//			// 等待服务端监听端口关闭
//			f.channel().closeFuture().sync();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			// 优雅退出，释放线程池资源
//			bossGroup.shutdownGracefully();
//			workerGroup.shutdownGracefully();
//		}
//	}
//
//	public static void main(String[] args) throws Exception {
//		int port = 8080;
//		if (args != null && args.length > 0) {
//			try {
//				port = Integer.valueOf(args[0]);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		new EchoServer().bind(port);
//	}
//}
