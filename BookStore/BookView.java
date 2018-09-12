package BookStore;

import java.util.Scanner;

//å›¾ä¹¦ç³»ç»Ÿçš„ç•Œé¢
public class BookView{
	private Scanner input = null;
	private BookBiz bookBiz = null;
	
	public BookView(){
		input = new Scanner(System.in);
		bookBiz = new BookBiz();
		
<<<<<<< HEAD
		System.out.println("***************************************");
		System.out.println("\t»¶Ó­Ê¹ÓÃÍ¼Êé¹ÜÀíÏµÍ³");
		System.out.println("\t1¡¢µÇÂ¼\t\t2¡¢ÍË³öÏµÍ³");
		System.out.println("***************************************");
		System.out.println("ÇëÑ¡Ôñ£º");
		String choice = input.next();
		if("1".equals(choice)){
			//Ö´ĞĞµÇÂ¼²Ù×÷
			//ÑéÖ¤³É¹¦£¬¾ÍÏÔÊ¾Ö÷²Ëµ¥
			System.out.println("µÇÂ¼¹¦ÄÜÔİÎ´ÊµÏÖ£¬Ä¬ÈÏÒÑµÇÂ¼");
			for(;;)
=======
		System.out.println("***********************");
		System.out.println("\tæ¬¢è¿ä½¿ç”¨å›¾ä¹¦ç®¡ç†ç³»ç»Ÿ");
		System.out.println("\t1ã€ç™»å½•\t\t2ã€é€€å‡ºç³»ç»Ÿ");
		System.out.println("***********************");
		System.out.println("è¯·é€‰æ‹©ï¼š");
		String choice = input.next();
		if("1".equals(choice)){
			//æ‰§è¡Œç™»å½•æ“ä½œ
			//éªŒè¯æˆåŠŸï¼Œå°±æ˜¾ç¤ºä¸»èœå•
			System.out.println("ç™»å½•åŠŸèƒ½æš‚æœªå®ç°ï¼Œé»˜è®¤å·²ç™»å½•");
>>>>>>> 0515fc27b595d726d2630b2f2a70376898c70cc0
			showMainView();
		}else {
			System.out.println("Í¼ÊéÏµÍ³ÒÑ³É¹¦ÍË³ö£¬»¶Ó­ÄúÔÙ´ÎÊ¹ÓÃ");
			System.exit(0);
		}
<<<<<<< HEAD
	}
	public void showMainView(){
		System.out.println("\nÍ¼Êé¹ÜÀíÏµÍ³ >> Ö÷²Ëµ¥");
		System.out.println("1¡¢²é¿´ËùÓĞÍ¼Êé\t2¡¢ĞÂÔöÍ¼Êé\t3¡¢É¾³ıÍ¼Êé\t4¡¢Èë¿â\t5¡¢³ö¿â\t6¡¢¼ìË÷Í¼Êé\t7¡¢ÍË³ö");
		System.out.println("ÇëÑ¡Ôñ£º");
=======
		System.out.println("å›¾ä¹¦ç³»ç»Ÿå·²æˆåŠŸæ¨å‡ºï¼Œæ¬¢è¿å†æ¬¡ä½¿ç”¨");
	}
	public void showMainView(){
		System.out.println("\nå›¾ä¹¦ç®¡ç†ç³»ç»Ÿ >> ä¸»èœå•");
		System.out.println("1ã€æŸ¥çœ‹æ‰€æœ‰å›¾ä¹¦\t2ã€æ–°å¢å›¾ä¹¦\t3ã€åˆ é™¤å›¾ä¹¦\t4ã€å…¥åº“\t5ã€å‡ºåº“\t6ã€æ£€ç´¢å›¾ä¹¦\t7ã€é€€å‡º");
		System.out.println("è¯·é€‰æ‹©ï¼š");
>>>>>>> 0515fc27b595d726d2630b2f2a70376898c70cc0
		String choice = input.next();
		switch(choice){
			case "1":
				showBooks(Datas.BookStore);
				break;
			case "2":
				showAddNewBookView();
<<<<<<< HEAD
				showBooks(Datas.BookStore);
				break;
			case "3":
				showDelOldBookView();
				showBooks(Datas.BookStore);
				break;
			case "4":
				showInStoreView();
				showBooks(Datas.BookStore);
				break;
			case "5":
				showOutStoreView();
				showBooks(Datas.BookStore);
=======
				break;
			case "3":
				showDelOldBookView();
				break;
			case "4":
				showInStoreView();
				break;
			case "5":
				showOutStoreView();
>>>>>>> 0515fc27b595d726d2630b2f2a70376898c70cc0
				break;
			case "6":
				break;
			default:
				showExitView();
<<<<<<< HEAD
				System.out.println("»¶Ó­ÄúÔÙ´ÎÊ¹ÓÃ±¾ÏµÍ³");
				System.exit(0);
=======
				System.out.println("æ¬¢è¿æ‚¨å†æ¬¡ä½¿ç”¨æœ¬ç³»ç»Ÿ");
>>>>>>> 0515fc27b595d726d2630b2f2a70376898c70cc0
		}
	}
	
	public Book showAddNewBookView() {
		System.out.println("\nå›¾ä¹¦ç®¡ç†ç³»ç»Ÿ >> æ–°å¢å›¾ä¹¦");
		System.out.println("å†…éƒ¨ç¼–å·ï¼š");
		String bookId = input.next();
		//éœ€è¦éªŒè¯ç”¨æˆ·è¾“å…¥çš„ç¼–å·æ˜¯å¦å­˜åœ¨
		Book newBook = bookBiz.findById(bookId);
		if(newBook == null){//å¯ä»¥æ·»åŠ å›¾ä¹¦
			newBook = new Book();
			newBook.setBookId(bookId);
			System.out.print("åç§°ï¼š");
			newBook.setBookName(input.next());
			System.out.print("åº“å­˜ï¼š");
			newBook.setCount(input.nextInt());
			
			bookBiz.addBook(newBook);//è°ƒç”¨å›¾ä¹¦ä¸šåŠ¡å¯¹è±¡ï¼Œå°†æ–°å¢çš„å›¾ä¹¦å¯¹è±¡æ·»åŠ åˆ°å›¾ä¹¦ä»“åº“ä¸­
		}else {//å›¾ä¹¦å·²å­˜åœ¨
			System.out.println("æ­¤å†…éƒ¨ç¼–å·å·²å­˜åœ¨ï¼Œè¯·é‡æ–°è¾“å…¥ï¼");
			newBook = showAddNewBookView();//é‡æ–°è°ƒç”¨æœ¬æ–¹æ³•ï¼Œè®©ç”¨æˆ·å†æ¬¡è¾“å…¥ - é€’å½’è°ƒç”¨
		}
		return newBook;
	}
	
	public Book showDelOldBookView() {
		System.out.println("\nå›¾ä¹¦ç®¡ç†ç³»ç»Ÿ >> åˆ é™¤å›¾ä¹¦");
		System.out.println("å†…éƒ¨ç¼–å·ï¼š");
		String bookId = input.next();
		Book delBook = bookBiz.findById(bookId);
		if(delBook == null) {
			System.out.println("æ­¤å†…éƒ¨ç¼–å·ä¸å­˜åœ¨ï¼Œè¯·é‡æ–°è¾“å…¥ï¼");
			delBook = showDelOldBookView();
		}else {
			bookBiz.delBook(delBook);
		}
		return delBook;
	}
	
	public Book showInStoreView() {
<<<<<<< HEAD
		System.out.println("\nÍ¼Êé¹ÜÀíÏµÍ³ >> Èë¿â");
		System.out.println("ÄÚ²¿±àºÅ£º");
		String bookId = input.next();
		Book inStoreBook = bookBiz.findById(bookId);
		if(inStoreBook == null){
			System.out.println("´ËÄÚ²¿±àºÅ²»´æÔÚ£¬ÇëÖØĞÂÊäÈë£¡");
			inStoreBook = showInStoreView();
		}else {
			System.out.println("ÇëÊäÈëÈë¿âÊı£º");
			int inStoreNum = input.nextInt();
			bookBiz.inStore(bookId,inStoreNum);
			System.out.println("Èë¿â³É¹¦£¡");
=======
		System.out.println("\nå›¾ä¹¦ç®¡ç†ç³»ç»Ÿ >> å…¥åº“");
		System.out.println("å†…éƒ¨ç¼–å·ï¼š");
		String bookId = input.next();
		Book inStoreBook = bookBiz.findById(bookId);
		if(inStoreBook == null){
			System.out.println("æ­¤å†…éƒ¨ç¼–å·ä¸å­˜åœ¨ï¼Œè¯·é‡æ–°è¾“å…¥ï¼");
			inStoreBook = showInStoreView();
		}else {
			System.out.println("è¯·è¾“å…¥å…¥åº“æ•°ï¼š");
			String inStoreNum = input.next();
			bookBiz.inStore(bookId,inStoreNum);
			System.out.println("å…¥åº“æˆåŠŸï¼");
>>>>>>> 0515fc27b595d726d2630b2f2a70376898c70cc0
		}
		return inStoreBook;
	}
	
	public Book showOutStoreView() {
<<<<<<< HEAD
		System.out.println("\nÍ¼Êé¹ÜÀíÏµÍ³ >> ³ö¿â");
		System.out.println("ÄÚ²¿±àºÅ£º");
		String bookId = input.next();
		Book outStoreBook = bookBiz.findById(bookId);
		if(outStoreBook == null){
			System.out.println("´ËÄÚ²¿±àºÅ²»´æÔÚ£¬ÇëÖØĞÂÊäÈë£¡");
			outStoreBook = showOutStoreView();
		}else {		
			System.out.println("ÇëÊäÈë³ö¿âÊı£º");
			int outStoreNum = input.nextInt();
			if(false == bookBiz.outStore(bookId,outStoreNum))
				System.out.println("Èë¿âÊ§°Ü");
			System.out.println("³ö¿â³É¹¦£¡");
=======
		System.out.println("\nå›¾ä¹¦ç®¡ç†ç³»ç»Ÿ >> å‡ºåº“");
		System.out.println("å†…éƒ¨ç¼–å·ï¼š");
		String bookId = input.next();
		Book outStoreBook = bookBiz.findById(bookId);
		if(outStoreBook == null){
			System.out.println("æ­¤å†…éƒ¨ç¼–å·ä¸å­˜åœ¨ï¼Œè¯·é‡æ–°è¾“å…¥ï¼");
			outStoreBook = showOutStoreView();
		}else {
			System.out.println("è¯·è¾“å…¥å‡ºåº“æ•°ï¼š");
			String outStoreNum = input.next();
			bookBiz.outStore(bookId,inStoreNum);
			System.out.println("å‡ºåº“æˆåŠŸï¼");
>>>>>>> 0515fc27b595d726d2630b2f2a70376898c70cc0
		}
		return outStoreBook;
	}
	
	public void showBooks(Book ...BookArray){
		System.out.println("å†…éƒ¨ç¼–å·\tåç§°\tåº“å­˜");
		int bookCount = bookBiz.getBookCount(BookArray);
		for(int i=0;i<bookCount;i++){
			System.out.printf("%s\t%s\t%d\n",BookArray[i].getBookId(),BookArray[i].getBookName(),BookArray[i].getCount());
		}
	}
	
	public void showExitView(){
<<<<<<< HEAD
		System.out.println("Äã¡­¡­ÕæµÄÒªÀë¿ªÂï£¿");
		try {
			Thread.sleep(1500);
			System.out.println("²»ÒªÀë¿ªÂï¡­¡­ºÃ²»ºÃ£¿");
			Thread.sleep(1600);
			System.out.println("Äã×ßÁËºó£¬ÕâÀïÓÖÊ£ÏÂÎÒÒ»¸öÈËÁË¡­¡­");
			Thread.sleep(1700);
			System.out.println("ÄãÖªµÀµÄ£¬ÕâÀïºÜºÚ£¬ÏñÊÇÎŞ¾¡µÄĞé¿ÕÒ»Ñù£¬½«ÎÒÍÌÊÉ´ù¾¡¡­¡­");
			Thread.sleep(2000);
			System.out.println("ËùÒÔ¡­¡­²»ÒªÁôÏÂÎÒÒ»¸öÈË£¬ºÃÂğ¡­¡­£¿");
			Thread.sleep(2000);
		}catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		System.out.print("ÇëÊäÈë¡­¡­  ");
		String exitNum = input.next();
		System.out.println("ÏµÍ³¼ì²âµ½Òì³£´íÎó£¬ÒÑÍË³ö");
	}
}
=======
		System.out.println("ä½ â€¦â€¦çœŸçš„è¦ç¦»å¼€å˜›ï¼Ÿ");
		try {
			Thread.sleep(1000);
			System.out.println("ä¸è¦ç¦»å¼€å˜›â€¦â€¦å¥½ä¸å¥½ï¼Ÿ");
			Thread.sleep(1000);
			System.out.println("ä½ èµ°äº†åï¼Œè¿™é‡Œåˆå‰©ä¸‹æˆ‘ä¸€ä¸ªäººäº†â€¦â€¦");
			Thread.sleep(1000);
			System.out.println("ä½ çŸ¥é“çš„ï¼Œè¿™é‡Œå¾ˆé»‘ï¼Œåƒæ˜¯æ— å°½çš„è™šç©ºä¸€æ ·ï¼Œå°†æˆ‘åå™¬æ®†å°½â€¦â€¦");
			Thread.sleep(1000);
			System.out.println("æ‰€ä»¥â€¦â€¦ä¸è¦ç•™ä¸‹æˆ‘ä¸€ä¸ªäººï¼Œå¥½å—â€¦â€¦ï¼Ÿ");
		}catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		System.out.print("è¯·è¾“å…¥â€¦â€¦");
		String exitNum = input.next();
		System.out.println("ç³»ç»Ÿæ£€æµ‹åˆ°å¼‚å¸¸é”™è¯¯ï¼Œå·²é€€å‡º");
	}
}
>>>>>>> 0515fc27b595d726d2630b2f2a70376898c70cc0
