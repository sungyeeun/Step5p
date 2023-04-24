/*
 * 가정: 라이브러리 형태로 제공되어 수정할 수 없다.
 */
package network;

public class Network {
	private String host;
	
	public boolean connect(String host) {
		this.host = host;
		System.out.printf("Network.connect(%s)\n", host);
		return true;
	}
	
    public int send(String msg) {
    	System.out.printf("Network.connect(%s)\n", msg);
    	return msg.length();
	}
    
    public boolean disconnect() {
		System.out.printf("Network.disconnect(%s)\n", this.host);
		return true;
	}

}
