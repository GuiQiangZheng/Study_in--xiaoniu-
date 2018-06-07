package cn.edu360.day07;

import java.util.Arrays;

public class AddrNet {
	private double[] queryLocation;
	private AddrList[] addrList;
	public double[] getQueryLocation() {
		return queryLocation;
	}
	public void setQueryLocation(double[] queryLocation) {
		this.queryLocation = queryLocation;
	}
	public AddrList[] getAddrList() {
		return addrList;
	}
	public void setAddrList(AddrList[] addrList) {
		this.addrList = addrList;
	}
	@Override
	public String toString() {
		return "AddrNet [queryLocation=" + Arrays.toString(queryLocation)
				+ ", addrList=" + Arrays.toString(addrList) + "]";
	}
	
	

}
