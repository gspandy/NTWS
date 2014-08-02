package com.myh.ntws.clientpool;
import com.myh.ntws.rpc.service.ClientSender;

public interface ClientSenderPool{

    /**
     * ��ǰ��pool���client
     * @param client
     */
    public void addClient(ClientSender client);


    /**
     * �Ƴ�һ��client
     * @param client
     */
    public void removeClient(ClientSender client);
    
    /**
     * ����client�˳���ʱ��Ĵ����൱���ṩ��client�Ļص�
     * @param client
     */
    public void clientExit(ClientSender client);
}
