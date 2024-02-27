package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Province implements Serializable{
	private int provinceCode;
	private String provinceName;
	
	public Province(int provinceCode, String provinceName) {
		this.provinceCode = provinceCode;
		this.provinceName = provinceName;
	}

	public int getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(int provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	@Override
	public String toString() {
		return "Province [provinceCode=" + provinceCode + ", provinceName=" + provinceName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(provinceCode, provinceName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Province other = (Province) obj;
		return provinceCode == other.provinceCode && Objects.equals(provinceName, other.provinceName);
	}
	
	public static ArrayList<Province> getProvinceList() {
		ArrayList<Province> provinceList = new ArrayList<>();
		String[] arrProvince = {
				"01 - HÀ NỘI",
			    "02 - HỒ CHÍ MINH",
			    "03 - HẢI PHÒNG",
			    "04 - ĐÀ NẴNG",
			    "05 - HÀ GIANG",
			    "06 - CAO BẰNG",
			    "07 - LAI CHÂU",
			    "08 - LÀO CAI",
			    "09 - TUYÊN QUANG",
			    "10 - LẠNG SƠN",
			    "11 - BẮC KẠN",
			    "12 - THÁI NGUYÊN",
			    "13 - YÊN BÁI",
			    "14 - SƠN LA",
			    "15 - PHÚ THỌ",
			    "16 - VĨNH PHÚC",
			    "17 - QUẢNG NINH",
			    "18 - BẮC GIANG",
			    "19 - BẮC NINH",
			    "21 - HẢI DƯƠNG",
			    "22 - HƯNG YÊN",
			    "23 - HÒA BÌNH",
			    "24 - HÀ NAM",
			    "25 - NAM ĐỊNH",
			    "26 - THÁI BÌNH",
			    "27 - NINH BÌNH",
			    "28 - THANH HÓA",
			    "29 - NGHỆ AN",
			    "30 - HÀ TĨNH",
			    "31 - QUẢNG BÌNH",
			    "32 - QUẢNG TRỊ",
			    "33 - THỪA THIÊN - HUẾ",
			    "34 - QUẢNG NAM",
			    "35 - QUẢNG NGÃI",
			    "36 - KON TUM",
			    "37 - BÌNH ĐỊNH",
			    "38 - GIA LAI",
			    "39 - PHÚ YÊN",
			    "40 - ĐĂK LĂK",
			    "41 - KHÁNH HÒA",
			    "42 - LÂM ĐỒNG",
			    "43 - BÌNH PHƯỚC",
			    "44 - BÌNH DƯƠNG",
			    "45 - NINH THUẬN",
			    "46 - TÂY NINH",
			    "47 - BÌNH THUẬN",
			    "48 - ĐỒNG NAI",
			    "49 - LONG AN",
			    "50 - ĐỒNG THÁP",
			    "51 - AN GIANG",
			    "52 - BÀ RỊA - VŨNG TÀU",
			    "53 - TIỀN GIANG",
			    "54 - KIÊN GIANG",
			    "55 - CẦN THƠ",
			    "56 - BẾN TRE",
			    "57 - VĨNH LONG",
			    "58 - TRÀ VINH",
			    "59 - SÓC TRĂNG",
			    "60 - BẠC LIÊU",
			    "61 - CÀ MAU",
			    "62 - ĐIỆN BIÊN",
			    "63 - ĐĂK NÔNG",
			    "64 - HẬU GIANG"
		};
		int i = 0;
		for (String provinceName : arrProvince) {
			Province province = new Province(i + 1, provinceName);
			provinceList.add(province);
		}
		return provinceList;
	}

	public static Province getProvinceById(int hometownId) {
		return Province.getProvinceList().get(hometownId);
	}

	public static Province getProvinceByName(String provinceName) {
		ArrayList<Province> newProvinceList = Province.getProvinceList();
		for (Province province : newProvinceList) {
			if(province.getProvinceName().equals(provinceName)) {
				return province;
			}
		}
		return null;
	}
	
}
