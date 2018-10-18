package com.ch.test;

import java.util.List;
import org.junit.jupiter.api.Test;
import com.ch.BookInfo;
import com.ch.BookInfo_DAO;
/**
 * 2018-10-18
 * @author xiaolin
 *
 */
class BookInfo_DAO_Test {

	@Test
	void testFind() {
		/**
		 * ����page�����鼮��Ϣ
		 */
		List<BookInfo> li = BookInfo_DAO.find(1);
		for (BookInfo bi :li) {
			System.out.println(bi.getBookName()+bi.getPrice());
		}
	
	}

	@Test
	void testGetRecordCount() {
		/**
		 * ��ȡ�ܹ����ٱ���
		 */
		int i=BookInfo_DAO.getRecordCount();
		System.out.println(i);	
	}

	@Test
	void testYeshu() {
		/**
		 * ��ȡҳ��
		 */
		int i=BookInfo_DAO.yeshu();
		System.out.println(i);	
	}

	@Test
	void testFindId() {
	BookInfo bi	= BookInfo_DAO.findId(1);
	
	System.out.println(bi.getBookName()+bi.getPrice());
	}

}
