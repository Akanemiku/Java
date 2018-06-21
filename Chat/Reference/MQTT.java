package com.bnuz.javafxthread;

import org.eclipse.paho.client.mqttv3.MqttCallback;

//import java.util.concurrent.Executors;  
//import java.util.concurrent.ScheduledExecutorService;  
//import java.util.concurrent.TimeUnit;  

import org.eclipse.paho.client.mqttv3.MqttClient;  
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;  
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
//import org.eclipse.paho.client.mqttv3.MqttSecurityException;  
import org.eclipse.paho.client.mqttv3.MqttTopic;  
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MQTT {
	public static final String HOST = "tcp://120.79.146.91:1883";
	public static final String TOPIC = "chat";
	private String clientid = "wxy";
	public  String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	private MqttClient client;
	private MqttConnectOptions options;
	private String userName = "guest";
	private String passWord = "guest";

//	private ScheduledExecutorService scheduler;

	public void start(MqttCallback callBack) {
		try {
			// hostΪ��������clientid������MQTT�Ŀͻ���ID��һ����Ψһ��ʶ����ʾ��MemoryPersistence����clientid�ı�����ʽ��Ĭ��Ϊ���ڴ汣��
			client = new MqttClient(HOST, clientid, new MemoryPersistence());
			// MQTT����������
			options = new MqttConnectOptions();
			// �����Ƿ����session,�����������Ϊfalse��ʾ�������ᱣ���ͻ��˵����Ӽ�¼����������Ϊtrue��ʾÿ�����ӵ������������µ��������
			options.setCleanSession(true);
			// �������ӵ��û���
			options.setUserName(userName);
			// �������ӵ�����
			options.setPassword(passWord.toCharArray());
			// ���ó�ʱʱ�� ��λΪ��
			options.setConnectionTimeout(10);
			// ���ûỰ����ʱ�� ��λΪ�� ��������ÿ��1.5*20���ʱ����ͻ��˷��͸���Ϣ�жϿͻ����Ƿ����ߣ������������û�������Ļ���
			options.setKeepAliveInterval(20);
			// ���ûص�
			client.setCallback(callBack);
			MqttTopic topic = client.getTopic(TOPIC);
			// setWill�����������Ŀ����Ҫ֪���ͻ����Ƿ���߿��Ե��ø÷������������ն˿ڵ�֪ͨ��Ϣ
			options.setWill(topic, "close".getBytes(), 2, true);

			client.connect(options);
			// ������Ϣ
			int[] Qos = { 1 };
			String[] topic1 = { TOPIC };
			client.subscribe(topic1, Qos);
			this.sendMessage(MQTT.TOPIC, "Hi,ALL!");
		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendMessage(String topic,String msg) throws MqttException{
		
		String content = "{\"user\":\""+ this.getClientid()
		           +"\", \"say\": \""+msg+"\"}";

        //�˴���Ϣ��ֻ��Ҫ���� byte ���鼴�ɣ������������͵���Ϣ����������ɶ��������ݵ�ת����
        final MqttMessage message = new MqttMessage(content.getBytes());
        message.setQos(1);

		client.publish(topic, message);
	}

	public static void main(String[] args) throws MqttException {
		MQTT client = new MQTT();
		client.start(new PushCallback());
		client.sendMessage(MQTT.TOPIC, "R U Ok?");
	}
}
