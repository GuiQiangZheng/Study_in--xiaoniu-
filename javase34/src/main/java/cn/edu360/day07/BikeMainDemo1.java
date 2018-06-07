package cn.edu360.day07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

import com.alibaba.fastjson.JSON;

public class BikeMainDemo1 {
	static Map<String, String> map=null;
	static{
		map=getBikeMap();
	}

	public static void main(String[] args) {
		
			
			
	
		try (BufferedReader br = new BufferedReader(new FileReader(
				"D:\\Learn\\TcPeng\\data\\bikes.log"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("d:/aaa.txt"));
				) {
			String line;
			while((line=br.readLine())!=null){
				BikeBean bikeBean = JSON.parseObject(line, BikeBean.class);
				//System.out.println(bikeBean);
				double lat = bikeBean.getLatitude();
				double lng = bikeBean.getLongitude();
				//查找位置
				try {
					String addr=findAddr(lat,lng);
					//System.out.println(addr);
					bw.write(addr);
					bw.newLine();
					bw.flush();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	/**
	 * 找位置根据本地仓库
	 * 
	 * @param lat
	 * @param lng
	 */
	private static String findAddr(double lat, double lng) {
		String data = BikeUtils.getOneData(lng, lat);
		String addr = map.get(data);
		if(addr==null){
			//从网上查找
			addr=findAddrByNet(lat,lng);
		}
		return addr;
	}
	
	/**
	 * 从网上查找数据
	 * 
	 * @param lat
	 * @param lng
	 * @return
	 */
	private static String findAddrByNet(double lat, double lng) {
		HttpClient client=new HttpClient();
		String uri="http://gc.ditu.aliyun.com/regeocoding?l=" + lat + "," + lng + "&type=010";
		HttpMethod method=new GetMethod(uri);
		try {
			 client.executeMethod(method);
			 String addr = method.getResponseBodyAsString();
			// System.out.println(addr);
			 AddrNet addrNet = JSON.parseObject(addr, AddrNet.class);
			 String xy = BikeUtils.getOneData(lng, lat);
			 String addr1 = addrNet.getAddrList()[0].getName();
			 String province_city = addrNet.getAddrList()[0].getAdmName();
			 String[] split = province_city.split(",");
			 if(split.length>2){ 
				 String province=split[0];
				 String city =split[1];
				 String district=split[2];
				 String str=xy+"\t"+province+"\t"+city+"\t"+district+"\t"+addr1;
				 
				 //把网上数据保存到本地仓库中
				 BufferedWriter bw = new BufferedWriter(new FileWriter("d:/repository.txt",true));
				 bw.write(str);
				 bw.newLine();
				 bw.flush();
				 map.put(xy, str);
				 //System.err.println(str);
				 return str;
			 }
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * 把本地仓库中的数据加载到map中,
	 * 
	 * @return
	 */
	private static Map<String, String> getBikeMap() {
		Map<String, String> map = new HashMap<>();
		try (BufferedReader br = new BufferedReader(new FileReader(
				"d:/repository.txt"));) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] split = line.split("\t");
				String xy = split[0];
				// 把数据加载到map中，在允许的误差范围内是可以的，所以数据value可以覆盖
				map.put(xy, line);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

}
