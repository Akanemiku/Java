package BookStore;

//图书业务类(业务层尽量不写打印(界面层写))
//包含对图书以及图书数组的基本操作
public class BookBiz{
	
	//获得图书仓库中Datas.BookStore数组中图书对象的个数
	public int getBookCount(){
		int count = 0;
		for(Book book :  Datas.BookStore){
			if(book == null) break;
			count++;
		}
		return count;
	}
	public int getBookCount(Book ...books){
		int count = 0;
		for(Book book :  Datas.BookStore){
			if(book == null) break;
			count++;
		}
		return count;
	}
	
	//将传入的图书对象放置到图书仓库(数组)中去
	public boolean addBook(Book book){
		int bookCount = getBookCount();
		if(Datas.BookStore.length == bookCount){
			return false;
		}
		//如果仓库不满，就将传入的图书对象放置在数组的最后一个位置(第一个非null位置)
		Datas.BookStore[bookCount] = book;
		return true;
	}
	
	//删除传入的图书对象
	public boolean delBook(Book book){
		int bookCount = getBookCount();
		int delIndex = -1;	//要删除元素的下标
		for(int i=0;i<bookCount;i++){
			//if(book.getBookId().equals(Datas.BookStore[i].getBookId())){
			if(book.equals(Datas.BookStore[i])){	
				delIndex = i;
				break;
			}
		}
		if(delIndex == -1){
			return false;//没有找到要删除的元素时，直接结束方法，返回false
		}
		//执行数组删除套路
		for(int i=delIndex;i<bookCount;i++){
			Datas.BookStore[i] = Datas.BookStore[i+1];
		}
		//将最后一个元素置为null
		Datas.BookStore[bookCount-1] = null;
		return true;
	}
	
	//通过图书id查找对应的图书对象
	public Book findById(String bookId){
		int bookCount = getBookCount();
		for(int i=0;i<bookCount;i++){
			if(bookId.equals(Datas.BookStore[i].getBookId())){
				return Datas.BookStore[i];
			}
		}
		return null;
	}
	
	//为仓库中现有的图书增加库存
	public boolean inStore(String bookId,int count){
		Book book = findById(bookId);
		//如果入库的bookId不存在
		if(null == book){
			return false;
		}
		if(count < 0) {
			return false;
		}
		//增加库存(引用传递)
		book.setCount(book.getCount() + count);
		return true;
	}
	
	//将仓库现有库存减少
	public boolean outStore(String bookId,int count){
		Book book = findById(bookId);
		if(null == book){
			return false;
		}
		if(book.getCount() < count){
			return false;
		}
		book.setCount(book.getCount() - count);
		return true;
	}
}
