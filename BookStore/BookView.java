package BookStore;

import java.util.Scanner;

//图书系统的界面
public class BookView{
	private Scanner input = null;
	private BookBiz bookBiz = null;
	
	public BookView(){
		input = new Scanner(System.in);
		bookBiz = new BookBiz();
		
		System.out.println("***********************");
		System.out.println("\t欢迎使用图书管理系统");
		System.out.println("\t1、登录\t\t2、退出系统");
		System.out.println("***********************");
		System.out.println("请选择：");
		String choice = input.next();
		if("1".equals(choice)){
			//执行登录操作
			//验证成功，就显示主菜单
			System.out.println("登录功能暂未实现，默认已登录");
			showMainView();
		}
		System.out.println("图书系统已成功推出，欢迎再次使用");
	}
	public void showMainView(){
		System.out.println("\n图书管理系统 >> 主菜单");
		System.out.println("1、新增图书\t2、删除图书\t3、查看所有图书\t4、检索图书\t5、入库\t6、出库\t7、退出");
		System.out.println("请选择：");
		String choice = input.next();
		switch(choice){
			case "1":
				showAddNewBookView();
				showBooks(Datas.BookStore);
			break;
			case "2":
				showDelOldBookView();
			break;
			case "3":
			break;
			case "4":
			break;
		}
	}
	
	public Book showAddNewBookView() {
		System.out.println("\n图书管理系统 >> 新增图书");
		System.out.println("内部编号：");
		String bookId = input.next();
		//需要验证用户输入的编号是否存在
		Book newBook = bookBiz.findById(bookId);
		if(newBook == null){//可以添加图书
			newBook = new Book();
			newBook.setBookId(bookId);
			System.out.print("名称：");
			newBook.setBookName(input.next());
			System.out.print("库存：");
			newBook.setCount(input.nextInt());
			
			bookBiz.addBook(newBook);//调用图书业务对象，将新增的图书对象添加到图书仓库中
		}else {//图书已存在
			System.out.println("此内部编号已存在，请重新输入！");
			newBook = showAddNewBookView();//重新调用本方法，让用户再次输入 - 递归调用
		}
		return newBook;
	}
	
	public Book showDelOldBookView() {
		System.out.println("\n图书管理系统 >> 删除图书");
		System.out.println("内部编号：");
		String bookId = input.next();
		Book delBook = bookBiz.findById(bookId);
		if(delBook == null) {
			System.out.println("此内部编号不存在，请重新输入！");
			delBook = showDelOldBookView();
		}else {
			bookBiz.delBook(delBook);
		}
		return delBook;
	}
	
	public void showBooks(Book ...BookArray){
		System.out.println("内部编号\t名称\t库存");
		int bookCount = bookBiz.getBookCount(BookArray);
		for(int i=0;i<bookCount;i++){
			System.out.printf("%s\t%s\t%d\n",BookArray[i].getBookId(),BookArray[i].getBookName(),BookArray[i].getCount());
		}
	}
}