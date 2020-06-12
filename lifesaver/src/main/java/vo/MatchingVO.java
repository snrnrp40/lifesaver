package vo;

public class MatchingVO {
	private String saver_code;
	private int ssb_situaion_num;
	
	public MatchingVO() {
		// TODO Auto-generated constructor stub
	}

	public MatchingVO(String saver_code, int ssb_situaion_num) {
		super();
		this.saver_code = saver_code;
		this.ssb_situaion_num = ssb_situaion_num;
	}

	public String getSaver_code() {
		return saver_code;
	}

	public void setSaver_code(String saver_code) {
		this.saver_code = saver_code;
	}

	public int getSsb_situaion_num() {
		return ssb_situaion_num;
	}

	public void setSsb_situaion_num(int ssb_situaion_num) {
		this.ssb_situaion_num = ssb_situaion_num;
	}
	
	
}
