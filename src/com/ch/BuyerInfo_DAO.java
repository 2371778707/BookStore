package com.ch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 2018-10-18
 * @author xiaolin
 *
 */
public class BuyerInfo_DAO {

	/**
	 * ����һ����Ա����
	 */
	public static BuyerInfo buyer = new BuyerInfo();
	
	/**
	 * �ж��Ƿ�Ϊ��Ա
	 * @param ID
	 * @param pwd
	 * @return
	 */
	public static boolean isMember(String ID,String pwd) {
		//��¼�Ƿ�Ϊ��Ա
		boolean r=false;
		/**
		 * ��ѯ�û�
		 */
		String sql = "select * from buyerinfo where memberID=? and pwd=?";
		
		
		try {
			/**
			 * ����Bookjdbc_Util��getConnection����
			 * ����cnn ����
			 */
			Connection cnn = Bookjdbc_Util.getConnection();
			//������ѯ
			PreparedStatement ps= cnn.prepareStatement(sql);
			ps.setString(1,ID);
			ps.setString(2, pwd);
			
			//ִ�в�ѯ�����ؽ��
			ResultSet rs= ps.executeQuery();
			
			//���õ���
			if (rs.next()) {
				//�з��ؽ����˵��Ϊ��Ա
				r=true;
				
				buyer.setAddress(rs.getString("address"));
				buyer.setEmail(rs.getString("email"));
				buyer.setId(rs.getInt("Id"));
				buyer.setLoginTimes(rs.getInt("loginTimes"));
				buyer.setMemberID(ID);
				buyer.setMembername(rs.getString("membername"));
				buyer.setPhoneCode(rs.getString("phoneCode"));
				buyer.setPwd(pwd);
				buyer.setZipcode(rs.getString("zipcode"));
				sql = "update buyerInfo set loginTimes = loginTimes+1 where memberID=?";
				ps = cnn.prepareStatement(sql);
				ps.setString(1, ID);
				ps.executeUpdate();
			}
			
			if (rs!=null) {
				rs.close();
			}
			if (ps!=null) {
				ps.close();
			}
			if (cnn!=null) {
				cnn.close();
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
	}
	
	//public static void main(String[] args) {
		
	//	isMember("0000001", "123");
	//	System.out.println(buyer.getMembername());
	//}
	
	
}
