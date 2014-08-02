package com.myh.ntws.clientpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;
import com.myh.ntws.rpc.service.ClientSender;

public class NettyClientPool implements ClientSenderPool {
	  private int size=10;
	    private String remoteHost;
	    private LinkedBlockingQueue<ClientSender> clients;

	    public NettyClientPool() {
	        this.clients = new LinkedBlockingQueue<ClientSender>();
	    }
	    /**
	     * ��ȡ��ǰ���ӵ�Զ�˵ĵ�ַ
	     *
	     * @return
	     */
	    public String getRemoteHost() {
	        return this.remoteHost;
	    }

	    /**
	     * ��ȡ��ǰpool�Ĺ�ģ����ʵҲ�����ж��ٸ�client
	     *
	     * @return
	     */
	    public int getSize() {
	        return this.size;
	    }

	    /**
	     * ����client�˳���ʱ��Ĵ����൱���ṩ��client�Ļص�
	     *
	     * @param client
	     */
	    public void clientExit(ClientSender clientsender) {
	        Logger.getLogger("main").warning("��client�˳���");
	        this.clients.remove(clientsender);
	    }
	    /**
	     * ��ǰ��pool���client
	     *
	     * @param client
	     */
	    public void addClient(ClientSender client) {
	        try {
	            this.clients.put(client);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	    /**
	     * �Ƴ�һ��client
	     *
	     * @param client
	     */
	    public void removeClient(ClientSender clientsender) {
	        this.clients.remove(clientsender);
	    }
}
