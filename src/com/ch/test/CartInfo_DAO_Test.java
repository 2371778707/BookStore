package com.ch.test;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.ch.CartInfo_BookInfo;
import com.ch.CartInfo_DAO;
/**
 * 2018-10-18
 * @author xiaolin
 *
 */
class CartInfo_DAO_Test {

	@Test
	void testAddcart() {
		String userId ="0000002";
		String bookId ="1";
		CartInfo_DAO.addcart(userId, bookId);
	    List<CartInfo_BookInfo> li = CartInfo_DAO.find("0000002");
		for(CartInfo_BookInfo cb:li) {
			System.out.println("0000002 �˿� ���ﳵ��"+cb.getCi().getBookCount()+"����"+cb.getBi().getBookName()+"��");
		}
	}

	@Test
	void testFind() {
		List<CartInfo_BookInfo> li = CartInfo_DAO.find("0000002");
		for(CartInfo_BookInfo cb:li) {
			System.out.println("0000002 �˿�  ���ﳵ��"+cb.getCi().getBookCount()+"����"+cb.getBi().getBookName()+"��");
		}
	}

	@Test
	void testDel() {
		//����bookIdɾ���鼮
		CartInfo_DAO.del("4");
		List<CartInfo_BookInfo> li = CartInfo_DAO.find("0000001");
		for(CartInfo_BookInfo cb:li) {
			System.out.println("0000001 �˿�  ���ﳵ��"+cb.getCi().getBookCount()+"����"+cb.getBi().getBookName()+"��");
		}
	}

	@Test
	void testEmpty() {
		//��չ��ﳵ
		CartInfo_DAO.empty("0000003");
	}

	@Test
	void testChange() {
		//���Ĺ��������
		CartInfo_DAO.change("0000001", "3", 4);
	}

}
