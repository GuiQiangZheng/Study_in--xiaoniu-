package cn.edu360.day07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Repository {
	/**
	 * 把poi数据写到本地仓库中 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 把poi数据写到本地仓库中 用转换流读csv数据
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream("D:\\Learn\\TcPeng\\data\\bj-poi-1.csv"),"gbk"));
				BufferedWriter bw=new BufferedWriter(new FileWriter("d:/repository.txt"))
				) {
			//京广线,地名地址信息;交通地名;铁路,116.146842,39.723968,
			//北京市房山区拱辰街道长虹东路20号,北京市,10,房山区,长虹东路,110111,190311,
			String line;
			while((line=br.readLine())!=null){
				//System.out.println(line);
				
				try {
					String[] split = line.split(",");
					String addr = split[0];
					String lngStr = split[2];
					double lng = Double.parseDouble(lngStr);
					String latStr = split[3];
					double lat = Double.parseDouble(latStr);
					String city = split[5];
					String district=split[7];
					//二维变成一维
					String xy=BikeUtils.getOneData(lng,lat);
					String ret=xy+"\t"+"北京"+"\t"+city+"\t"+district+"\t"+addr;
					bw.write(ret);
					bw.newLine();
					bw.flush();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					continue;
				}
			}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
