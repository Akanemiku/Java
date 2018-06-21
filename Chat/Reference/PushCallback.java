package com.bnuz.javafxthread;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import javafx.application.Platform;
import javafx.collections.ObservableList;

public class PushCallback implements MqttCallback {
	//方式二：传应用
	private Chatter chatter ;
	//方式一：传数据
	private ObservableList<String> items ;
	public ObservableList<String> getItems() {
		return items;
	}

	public void setItems(ObservableList<String> items) {
		this.items = items;
	}

	public void connectionLost(Throwable cause) {
		// ??????????????????????????
		System.out.println("??????????????????");
	}

	public void deliveryComplete(IMqttDeliveryToken token) {
		//System.out.println("deliveryComplete---------" + token.isComplete());
	}

	public void messageArrived(String topic, MqttMessage message) throws Exception {
		// subscribe?????????????е???????
//		System.out.println("??????????? : " + topic);
//		System.out.println("???????Qos : " + message.getQos());
        System.out.println("??????????? : " + new String(message.getPayload()));
//       方式一：传数据 
//		Platform.runLater(new Runnable(){
//			public void run(){
//				items.add(new String(message.getPayload()));
//			};
//		});
//      方式二：传应用
		chatter.addItem(new String(message.getPayload()));
        //System.out.println("???д?С="+items.size());
	}

	public Chatter getChatter() {
		return chatter;
	}

	public void setChatter(Chatter chatter) {
		this.chatter = chatter;
	}
}
